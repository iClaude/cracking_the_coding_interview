package leetcode

fun main() {
    val list = ListNode(7)

    println("middle node: ${Solution().middleNode(list)?.`val`}")
}

class Solution {

    // 1 scan of the list with 2 pointers: one slow and one fast
    fun middleNode(head: ListNode?): ListNode? {
        var p1 = head?.next
        var p2 = head?.next?.next

        while (p2?.next != null) {
            p1 = p1?.next
            p2 = p2.next?.next
        }

        return p1
    }

    // 2 scans of the list
    /*fun middleNode(head: ListNode?): ListNode? {
        var p = head
        var count = 0
        while (p != null) {
            count++
            p = p.next
        }

        count /= 2
        p = head
        repeat(count) {
            p = p?.next
        }

        return p
    }*/
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}