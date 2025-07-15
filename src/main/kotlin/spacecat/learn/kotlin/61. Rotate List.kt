package spacecat.learn.kotlin

//Given the head of a linked list, rotate the list to the right by k places.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 500].
//-100 <= Node.val <= 100
//0 <= k <= 2 * 109
fun main(){
    val listNodes = arrayToListNode(intArrayOf(1,2,3,4,5))
    printListNote(listNodes)
    println()
    printListNote(rotateRight(listNodes,2))
}
//fun rotateRight (head :ListNode?, k :Int):ListNode?{
//    if(head?.next == null || k== 0) return head
//    val dummyHead = ListNode(0).apply { next = head }
//    var fastNode = dummyHead.next
//    var slowNode = dummyHead
//    var listNoteLength = 1
//    while(fastNode?.next!=null){
//        fastNode = fastNode.next
//        listNoteLength++
//    }
//    val rotate = k%listNoteLength
//    if(rotate ==0 ) return head
//    repeat(listNoteLength - rotate) {
//        slowNode = slowNode.next!!
//    }
//    fastNode?.next = dummyHead.next
//    dummyHead.next = slowNode.next
//    slowNode.next = null
//    return dummyHead.next
//}
// another solution dont need to use unessesary memory
fun rotateRight (head :ListNode?, k :Int):ListNode?{
    if(head?.next == null || k== 0) return head
    val dummyHead = ListNode(0).apply { next = head }
    var currentNode = dummyHead.next
    var listNoteLength = 1
    while(currentNode?.next!=null){
        currentNode = currentNode.next
        listNoteLength++
    }
    /// last node of the list point to head
    currentNode?.next = head
    val rotate = k%listNoteLength
    if(rotate ==0 ) return head
    currentNode = head
    repeat(listNoteLength - rotate-1) {
        currentNode = currentNode?.next!!
    }
    dummyHead.next =currentNode?.next
    currentNode?.next = null
    return dummyHead.next
}