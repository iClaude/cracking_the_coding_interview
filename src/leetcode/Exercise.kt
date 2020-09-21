package leetcode

fun sumListsRecursive(list1: ListNode?, list2: ListNode?, rem: Int): ListNode? {
    val sum = ((list1?.value ?: 0) + (list2?.value ?: 0) + rem)

    return if (list1 == null && list2 == null && rem == 1) {
        ListNode(1)
    } else if (list1 == null && list2 == null && rem == 0) {
        null
    } else {
        ListNode(sum.rem(10)).apply {
            next = sumListsRecursive(list1?.next, list2?.next, if (sum >= 10) 1 else 0)
        }
    }
}

data class ListNode(val value: Int) {
    var next: ListNode? = null
}

fun main() {
    val list1 = ListNode(3).apply {
        next = ListNode(1).apply {
            next = ListNode(5)
        }
    }
    val list2 = ListNode(5).apply {
        next = ListNode(9).apply {
            next = ListNode(2)
        }
    }

    var result = sumListsRecursive(list1, list2, 0)
    while (result != null) {
        print("${result.value}")
        result = result.next
    }

}
