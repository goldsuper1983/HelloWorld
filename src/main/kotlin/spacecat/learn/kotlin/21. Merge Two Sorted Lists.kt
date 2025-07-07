package spacecat.learn.kotlin

//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
//
//
//Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
//
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.

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
    var listNode1 = arrayToListNode(intArrayOf(1, 2, 4))
    var listNode2 = arrayToListNode(intArrayOf(1, 3, 4))
    printListNote(listNode1)
    println()
    printListNote(listNode2)
    println()
    printListNote(mergeTwoLists(listNode1,listNode2))
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1Cur: ListNode? = list1
    var l2Cur: ListNode? = list2
    val dummy = ListNode(0)
    var  current = dummy
    while (l1Cur!=null || l2Cur!=null){
        if(l1Cur!=null && l2Cur!=null ){
            if(l1Cur.`val` <l2Cur.`val`){
                current.next = l1Cur
                l1Cur = l1Cur.next
            }else{
                current.next = l2Cur
                l2Cur = l2Cur.next
            }
        }else if(l2Cur == null && l1Cur!=null){
            current.next = l1Cur
            l1Cur= l1Cur.next
        }else if(l2Cur!= null){
            current.next = l2Cur
            l2Cur = l2Cur.next
        }
        current = current.next!!

    }
    return dummy.next
}