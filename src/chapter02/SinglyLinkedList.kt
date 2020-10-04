package chapter02

/*
  Implementation of a singly-linked list with tail pointer.
*/

class SinglyLinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null

    fun pushFront(key: T) {
        val node = Node(key, head)
        head = node
        if (tail == null) {
            tail = head
        }
    }

    fun topFront(): T? {
        return head?.key
    }

    fun popFront() {
        head ?: return
        head = head?.next
        if (head == null) tail = null
    }

    fun pushBack(key: T) {
        val node = Node(key, null)
        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }
        tail = node
    }

    fun pushBackWithNode(key: T): Node<T> {
        val node = Node(key, null)
        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }
        tail = node

        return node
    }

    fun topBack(): T? {
        return tail?.key
    }

    fun popBack() {
        head ?: return

        if (head == tail) {
            head = null
            tail = null
            return
        }

        var p = head
        while (p?.next?.next != null) {
            p = p.next
        }
        p?.next = null
        tail = p
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
        head ?: return

        if (head == tail) {
            if (key == head?.key) {
                head = null
                tail = null
            }
            return
        }

        if (key == head?.key) {
            head = head?.next
            return
        }

        var p = head
        while (p?.next?.key != key && p?.next?.next != null) {
            p = p.next
        }

        if (p?.next?.key != key) return
        if (p?.next == tail) tail = p
        p?.next = p?.next?.next

    }

    // this method doesn't work for the last node (tail)
    fun eraseWithNode(node: Node<T>) {
        node.apply {
            key = this.next!!.key
            next = this.next!!.next
        }
    }

    fun empty(): Boolean =
        head == null

    fun addBefore(node: Node<T>, key: T) {
        val newNode = Node(key, node)

        if (node == head) {
            head = newNode
            return
        }

        var p = head
        while (p?.next != node) {
            p = p?.next
        }
        p.next = newNode
    }

    fun addAfter(node: Node<T>, key: T) {
        val newNode = Node(key, node.next)
        node.next = newNode
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

    fun removeDuplicates() {
        head ?: return

        val checkMap = mutableMapOf<T, Boolean>()
        var node = head
        checkMap[node!!.key] = true
        while (node?.next != null) {
            if (checkMap.containsKey(node.next?.key)) {
                node.next = node.next?.next
            } else {
                checkMap[node.next!!.key] = true
                node = node.next
            }
        }
    }

    fun removeDuplicatesWithoutBufferA() {
        head ?: return

        var node = head
        while (node?.next != null) {
            var p1 = node
            var p2 = node.next
            while (p2 != null) {
                if (p2.key == node.key) {
                    p1?.next = p2.next
                    p2 = p2.next
                } else {
                    p1 = p1?.next
                    p2 = p2.next
                }
            }
            node = node.next
        }
    }

    fun removeDuplicatesWithoutBufferB() {
        head ?: return

        var prevNode = head
        var curNode = head?.next
        while (curNode != null) {
            var p = head
            var deleted = false
            while (p != curNode) {
                if (p?.key == curNode.key) {
                    prevNode?.next = curNode.next
                    deleted = true
                    break
                }
                p = p?.next
            }

            if (!deleted) prevNode = curNode
            curNode = curNode.next
        }
    }

    fun <T> nToLastElement(list: SinglyLinkedList<T>, n: Int)
            : Node<T>? {

        var p1 = list.head
        for (i in 1..n) {
            p1 = p1?.next
            p1 ?: return null
        }

        var p2 = list.head
        while (p1!!.next != null) {
            p1 = p1.next
            p2 = p2!!.next
        }

        return p2
    }
}

data class Node<T>(var key: T, var next: Node<T>?, var prev: Node<T>? = null)