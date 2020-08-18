package leetcode

fun main() {
    val list = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }

    val newList = Solution().swapPairs(list)
    printList(newList)

}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        head?.next ?: return head

        val newHead = head.next
        var p = head
        var prev: ListNode? = null

        while (p?.next != null) {
            val nextPair = p.next?.next

            p.next?.next = p
            p.next = nextPair

            p = nextPair
        }

        return newHead
    }
}

fun printList(head: ListNode?) {
    var p = head
    while (p != null) {
        print("${p.`val`} - ")
        p = p.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}