package chapter01

class DynamicArray<T>(private var capacity: Int = 2) {
    private var backArray: Array<Any> = Array(capacity) { }
    private var size = 0

    fun get(i: Int): T {
        if (i !in backArray.indices) throw IndexOutOfBoundsException()
        return backArray[i] as T
    }

    fun set(i: Int, value: Any) {
        if (i !in backArray.indices) throw IndexOutOfBoundsException()
        backArray[i] = value
    }

    fun pushBack(value: Any) {
        if (size == capacity) {
            capacity *= 2
            val newArray = Array<Any>(capacity) { }
            for (i in backArray.indices) {
                newArray[i] = backArray[i]
            }
            backArray = newArray
        }
        backArray[size++] = value
    }

    fun remove(i: Int) {
        if (i !in backArray.indices) throw IndexOutOfBoundsException()
        for (j in i..size - 2) {
            backArray[j] = backArray[j + 1]
        }
        size--
    }

    fun size() = size

    fun printDetails() {
        print("[")
        for (i in 0..size - 2) print("${backArray[i]},")
        println("${backArray[size - 1]}]")
        println("size: $size - capacity: $capacity")
        println()
    }
}