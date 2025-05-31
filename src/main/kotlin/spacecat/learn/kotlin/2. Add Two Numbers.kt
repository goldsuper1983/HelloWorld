package spacecat.learn.kotlin

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in spacecat.learn.kotlin.reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.

fun main(){

    var listNode1 =  createIntListNote(246)
    var listNode2 = createIntListNote(5649)


     printListNote(listNode1)
    println()
    printListNote(listNode2)
    println()
    print("result = ")
    printListNote(addTwoNumbers(listNode1,listNode2))
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1= l1
        var list2= l2
        var moreThenTen = 0
        val head =ListNode(0)
        var runningNode =head
        var sum =0
        var isFirstLoop = 1
        while (list1!=null||list2!=null){
//            println("l1 = ${list1?.`var`} l2= ${list2?.`var`} ")
            if(list1!=null && list2 != null){
                    sum = list1.`val`.plus(list2.`val`)
            }else if(list1 == null && list2!=null){
                sum = list2.`val`
            }else if(list2 == null &&list1!=null){
                sum = list1.`val`
            }
            if(moreThenTen ==1){
                sum++
                moreThenTen=0
            }
            if(sum >=10){
                sum %= 10
                moreThenTen=1
            }
//            println("more then then = $moreThenTen sum =$sum")
            if(isFirstLoop == 1){
                head.`val` = sum
                runningNode = head
                isFirstLoop=0
            }else{
                runningNode.next = ListNode(sum)
//                println("next value $ ${runningNode.next!!.`var`}")
                runningNode = runningNode.next!!
            }

            list1 = list1?.next
            list2 = list2?.next
        }
        if(moreThenTen ==1)runningNode.next = ListNode(sum)
//    printListNote(head)
    return head
    }
fun createIntListNote(int:Int): ListNode? {
    var numListNodeHead: ListNode? = null
    if(int!=null) {
        var number = int
        numListNodeHead= ListNode(number%10)
        number /= 10
        var runningNode = numListNodeHead
        while(number!=0){
            var tempNode = ListNode(number%10)
            number /= 10
            runningNode?.next= tempNode
            runningNode = tempNode
        }
    }
    return numListNodeHead
}
fun printListNote(listNode: ListNode?){
        var runner = listNode
        while (runner!=null){
            print("${runner?.`val`}")
            runner = runner?.next
        }
}
class ListNode(var `val`: Int){
    var next:ListNode?= null
}