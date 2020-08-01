package chapter03

/*
    3.1 Describe how you could use a single array to implement three stacks.
 */

// Using a backing array with equal space for the 3 queues.
class ThreeQueues(val size: Int) {
    private var sizeCorr = if (size >= 9) size else 9

    private val backingArray = Array(sizeCorr) { -1 }

    private val mins = Array(3) {
        when (it) {
            0 -> 0
            1 -> (sizeCorr + 1) / 3
            else -> ((sizeCorr + 1) / 3) * 2
        }
    }

    private val maxs = Array(3) {
        when (it) {
            0 -> (sizeCorr + 1) / 3 - 1
            1 -> ((sizeCorr + 1) / 3) * 2 - 1
            else -> sizeCorr - 1
        }
    }

    private val reads = Array(3) {
        mins[it]
    }

    private val writes = Array(3) {
        mins[it]
    }

    private fun nextInd(curr: Int, min: Int, max: Int) = if (curr + 1 <= max) curr + 1 else min

    // queue 1
    fun empty(queue: Int): Boolean {
        if (queue > 2) throw IndexOutOfBoundsException()

        return reads[queue] == writes[queue]
    }

    fun dequeue(queue: Int): Int {
        if (empty(queue)) throw IndexOutOfBoundsException()

        val value = backingArray[reads[queue]]
        backingArray[reads[queue]] = -1
        reads[queue] = nextInd(reads[queue], mins[queue], maxs[queue])
        return value
    }

    fun enqueue(queue: Int, value: Int) {
        val nextInd = nextInd(writes[queue], mins[queue], maxs[queue])
        if (nextInd != reads[queue]) {
            backingArray[writes[queue]] = value
            writes[queue] = nextInd
        } else {
            throw IndexOutOfBoundsException()
        }
    }

    override fun toString(): String {
        return backingArray.contentToString()
    }
}

// Using a backing array with dynamic space for the 3 queues.
class ThreeQueuesSpaceOptimized(size: Int) {
    private data class Element(val value: Int, var nextInd: Int = -1)

    private var arraySize: Int = if (size >= 3) size else 9

    private val backingArray = Array<Element?>(arraySize) { null }

    private val reads = Array(3) { -1 }
    private val writes = Array(3) { -1 }
    private val freeIndexes = Queue<Int>().apply {
        repeat(arraySize) {
            enqueue(it)
        }
    }

    // queue 1
    fun empty(queue: Int): Boolean {
        if (queue !in 0..2) throw IndexOutOfBoundsException()
        return reads[queue] == -1
    }

    fun dequeue(queue: Int): Int {
        if (empty(queue)) throw UnsupportedOperationException()

        val element = backingArray[reads[queue]]
        backingArray[reads[queue]] = null
        freeIndexes.enqueue(reads[queue])
        reads[queue] = element!!.nextInd
        return element.value
    }

    fun enqueue(queue: Int, value: Int) {
        if (queue !in 0..2) throw IndexOutOfBoundsException()

        val writeIndex = freeIndexes.dequeue() ?: throw UnsupportedOperationException()

        backingArray[writeIndex] = Element(value)
        if (writes[queue] != -1) backingArray[writes[queue]]!!.nextInd = writeIndex
        writes[queue] = writeIndex
        if (reads[queue] == -1) reads[queue] = writeIndex

    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (element in backingArray) {
            sb.append("${element?.value} - ")
        }
        return sb.toString()
    }
}

// Test
fun main() {
/*    println("TEST THREQUEUES")
    val queues = ThreeQueues(5).apply {
        enqueue(0, 3)
        enqueue(0, 4)
        enqueue(1, 5)
        enqueue(2, 9)
        println(toString())
        enqueue(1, 5)
        enqueue(2, 8)
        println(toString())
        println(dequeue(0))
        enqueue(0, 8)
        println(toString())
        println(dequeue(1))
        println(toString())
        println(dequeue(1))
        println(empty(1))
        println(toString())
    }*/

    println("TEST THREQUEUESOPTIMIZED")
    val queuesOpt = ThreeQueuesSpaceOptimized(9).apply {
        enqueue(0, 1)
        enqueue(0, 2)
        enqueue(0, 3)

        enqueue(1, 4)
        enqueue(1, 5)
        enqueue(1, 6)
        enqueue(1, 7)

        enqueue(2, 8)
        enqueue(2, 9)

        println(toString())

        println(dequeue(2))
        println(toString())

        enqueue(0, 10)
        println(toString())

        println(dequeue(2))
        println(toString())

        enqueue(2, 4)
        println(toString())

        println(dequeue(0))
        println(dequeue(0))
        println(toString())

        enqueue(2, 6)
        println(toString())

        enqueue(1, 5)
        println(toString())

    }

}