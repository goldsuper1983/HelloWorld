package spacecat.learn.kotlin

//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 500
//-500 <= Node.val <= 500
//1 <= left <= right <= n
//
//
//Follow up: Could you do it in one pass?

fun main() {
    val linkList = arrayToListNode(intArrayOf(1, 2))
    printListNote(linkList)
    println()
    printListNote(reverseBetween(linkList, 1, 2))
}

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null || left == right) return head
    val dummyHead = ListNode(0).apply {
        next = head
    }
    var preLeftNode = dummyHead
    repeat(left - 1) {
        preLeftNode = preLeftNode.next!!
    }
    var currentNode = preLeftNode.next
    val headOfSubList = currentNode
    var preNode: ListNode? = null
    repeat(right - left + 1) {
        val nextNode = currentNode?.next
        currentNode?.next = preNode
        preNode = currentNode
        currentNode = nextNode
    }
    preLeftNode.next = preNode
    headOfSubList?.next = currentNode
    return dummyHead.next
}
//fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
//    if(head == null || left == right ) return head
//    var currNode = head
//    var preLeft : ListNode? =null
//    if(left!=1){
//        for(i in 1 until left-1)currNode = currNode?.next
//        preLeft = currNode
//        currNode = currNode?.next
//    }
//    val headOfreverdList = currNode
//    println("left = ${currNode?.`val`} preLeft = ${preLeft?.`val`}")
//    /// begin revered sublist
//    var preNode : ListNode? = null
//    var nextNode :ListNode? = null
//    for( i in left.. right){
//        nextNode = currNode?.next
//        currNode?.next = preNode
//        preNode = currNode
//        currNode = nextNode
//    }
//    if(left!=1){
//        preLeft?.next = preNode
//    }
//    headOfreverdList?.next = nextNode
//    println("curr after end :${nextNode?.next?.`val`}")
//
//    return if(left!=1) head else preNode
//}

fun reverseList(head: ListNode?): ListNode? {
    var preNode: ListNode? = null
    var curr = head
    var nextNode: ListNode? = null
    while (curr != null) {
        nextNode = curr.next
        curr.next = preNode
        preNode = curr
        curr = nextNode
    }
    return preNode
}