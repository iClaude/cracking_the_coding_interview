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


// Test
fun main() {
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
    }

}