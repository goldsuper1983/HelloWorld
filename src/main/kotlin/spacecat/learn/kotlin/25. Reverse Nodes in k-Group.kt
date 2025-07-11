package spacecat.learn.kotlin

//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
//You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
//Example 2:
//
//
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
//
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= k <= n <= 5000
//0 <= Node.val <= 1000
//
//
//Follow-up: Can you solve the problem in O(1) extra memory space?

fun main(){
    val linkList = arrayToListNode(intArrayOf(1, 2,3,4,5,6,7))
    printListNote(linkList)
    println()
    printListNote(reverseKGroup(linkList,9))

}
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    val dummyHead = ListNode(0).apply { next = head }
    var currentNode = dummyHead.next
    var nodeCount = 1
    var fastNode = dummyHead.next
    var count = 0
    while (count <= k){
        println(fastNode?.`val`)
        fastNode = fastNode?.next
        if (fastNode!=null) return dummyHead.next
        count++
    }

//    while (fastNode!=null){
//
//    }
    return dummyHead.next
}