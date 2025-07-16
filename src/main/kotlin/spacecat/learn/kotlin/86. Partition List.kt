package spacecat.learn.kotlin

//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//
//
//Example 1:
//
//
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//Example 2:
//
//Input: head = [2,1], x = 2
//Output: [1,2]
//
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 200].
//-100 <= Node.val <= 100
//-200 <= x <= 200
fun main() {
    val listNotes = arrayToListNode(intArrayOf(1,4,3,0,5,2))
    printListNote(listNotes)
    println()
    printListNote(partition(listNotes, 2))
}

fun partition(head: ListNode?, x: Int): ListNode? {
    val dummyHead = ListNode(0).apply { next = head }
    var preLeftNode = dummyHead
    var currentNode = head
    var preCurrent = dummyHead
    while(currentNode!=null && currentNode.`val` <x){
        currentNode = currentNode.next
        preLeftNode = preLeftNode.next!!
    }
    preCurrent = preLeftNode
    println(preLeftNode.`val`)
    while ((currentNode !=null)){
        if(currentNode.`val` <x){
          preCurrent.next = currentNode.next
            val temp = preLeftNode.next
            preLeftNode.next = currentNode
            currentNode.next = temp
            currentNode = preCurrent
            preLeftNode = preLeftNode.next!!
        }else preCurrent = preCurrent.next!!
        currentNode = currentNode.next
    }
    return dummyHead.next
}