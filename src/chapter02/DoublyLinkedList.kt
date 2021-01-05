package chapter02

/*
  Implementation of a doubly-linked list with head and tail.
*/

class DoublyLinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun pushFront(key: T) {
        val node = Node(key, head, null)
        head = node
        if (tail == null) {
            tail = head
        }
    }

    fun topFront(): T? = head?.key

    fun popFront() {
        head ?: return
        head = head?.next
        head?.prev = null
        if (head == null) tail = null
    }

    fun pushBack(key: T) {
        val node = Node(key, null, tail)
        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }
        tail = node
    }

    fun topBack(): T? = tail?.key

    fun popBack() {
        head ?: return

        if (head == tail) {
            head = null
            tail = null
            return
        }

        tail = tail?.prev
        tail?.next = null
    }

    fun find(key: T): Boolean {
        var found = false
        var p = head
        while (p?.next != null && !found) {
            if (p.key == key) found = true
            p = p.next
        }
        if (p?.key == key) found = true

        return found
    }

    fun erase(key: T) {
        if (head == null) return

        if (head == tail) {
            head = null
            tail = null
        }

        var p = head
        while (p?.next != null && (p.next?.key) != key) {
            p = p.next
        }
        p?.next = p?.next?.next
        p?.next?.prev = p
        if (p?.next == null) tail = p

    }

    fun empty(): Boolean =
        head == null

    fun addBefore(node: Node<T>, key: T) {
        val newNode = Node(key, node, node.prev)
        node.prev = newNode
        newNode.prev?.next = newNode

        if (node == head) {
            head = newNode
        }
    }

    fun addAfter(node: Node<T>, key: T) {
        val newNode = Node(key, node.next, node)
        node.next = newNode
        newNode.next?.prev = newNode
        if (node == tail) tail = newNode

    }

    override fun toString(): String {
        val sb = StringBuilder()
        var p = head
        while (p?.next != null) {
            sb.append("${p.key} - ")
            p = p.next
        }
        sb.append("${p?.key}")

        return sb.toString()
    }

    fun toStringReversed(): String {
        val sb = StringBuilder()
        var p = tail
        while (p?.prev != null) {
            sb.append("${p.key} - ")
            p = p.prev
        }
        sb.append("${p?.key}")

        return sb.toString()
    }
}