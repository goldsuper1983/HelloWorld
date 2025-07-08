package spacecat.learn.kotlin

//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [3,4,5]
//Explanation: The middle node of the list is node 3.
//Example 2:
//
//
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
//
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 100].
//1 <= Node.val <= 100
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
    val linkList = arrayToListNode(intArrayOf(1))
    printListNote(middleNode(linkList))
}

fun middleNode(head: ListNode?): ListNode? {
    if( head?.next== null) return head
    var slow = head
    var fast = head
    var isThisOdd = true
    while ((fast?.next != null) && (fast.next!!.next != null)) {
        slow = slow?.next
        fast = fast.next!!.next
        if( fast?.next ==null) isThisOdd=false

    }
    return if(isThisOdd) slow?.next else slow
}
