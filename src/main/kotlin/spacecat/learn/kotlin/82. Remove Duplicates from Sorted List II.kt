package spacecat.learn.kotlin

//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//Example 2:
//
//
//Input: head = [1,1,1,2,3]
//Output: [2,3]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 300].
//-100 <= Node.val <= 100
//The list is guaranteed to be sorted in ascending order.
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun main() {
    val listOfNodes = arrayToListNode(intArrayOf(1, 1, 1, 1, 2, 1, 1))
    printListNote(listOfNodes)
    println()
    printListNote(deleteDuplicates(listOfNodes))
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) return null
    val dummyHead = ListNode(0).apply { next = head }
    var leftNode = dummyHead
    var currentNode = dummyHead.next
    var foundDupNumber: Boolean
    while (currentNode?.next != null) {
        foundDupNumber = false
        while (currentNode?.next != null && currentNode?.`val` == currentNode?.next!!.`val`) {
            foundDupNumber = true
            currentNode = currentNode.next
        }
        if (!foundDupNumber) leftNode = currentNode!!
        else  leftNode.next = currentNode?.next
        currentNode = currentNode?.next
    }
    return dummyHead.next
}

