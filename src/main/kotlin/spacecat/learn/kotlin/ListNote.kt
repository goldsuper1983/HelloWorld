package spacecat.learn.kotlin


fun printListNote(listNode: ListNode?){
    var runner = listNode
    while (runner!=null){
        print("${runner?.`val`}")
        runner = runner?.next
    }
}
fun arrayToListNode(arr : IntArray): ListNode? {
    if(arr.isEmpty()) return null
    var current  = ListNode(arr[0])
    val head = current
    for(i in 1 until arr.size){
        val tem = ListNode(arr[i])
        current.next = tem
        current = current.next!!
    }
    return head
}
class ListNode(var `val`: Int){
    var next:ListNode?= null
}