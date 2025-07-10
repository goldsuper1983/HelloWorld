package spacecat.learn.kotlin

//A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
//
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//Return the head of the copied linked list.
//
//The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//val: an integer representing Node.val
//        random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
//Your code will only be given the head of the original linked list.
//
//
//
//Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//Example 3:
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */
fun main() {
    val nodeList = arrayToNodeList(intArrayOf(1, 2, 4, 5, 5))
    printNodeList(nodeList)
    println("nodeList")
    printNodeList(copyRandomList(nodeList))
    println("ourcome")

}

/// use map code is cleaner
fun copyRandomList(node: Node?): Node? {
    val map = mutableMapOf<Node, Node>()
    var current = node
    val newListDummyHead = Node(0)
    var newListCurr = newListDummyHead
    while (current != null) {
        val newNode = map[current] ?: Node(current.`val`)
        newNode.isOld = false
        map[current] = newNode
        if (current.random != null) {
            newNode.random = map[current.random] ?: Node(current.random!!.`val`)
            map[current.random!!] = newNode.random!!
        }
        newListCurr.next = newNode
        newListCurr = newNode
        current = current.next
    }
    return newListDummyHead.next
}


////this method modified the input, they told me this is not a good idea
//fun copyRandomList(node: Node?): Node? {
//    if (node == null) return null
//    var current = node
//    while (current!= null) {
//        val temp = Node(current.`val` )
//        temp.isOld = false
//        temp.next = current.next
//        current.next = temp
//        current = current.next!!.next
//    }
////    printNodeList(node)
////    println("node after add")
////    // now work with the copy list random pointers
//    current = node
//    val copyedListHead = node.next
//    var newCurrent = copyedListHead
//    while(newCurrent!=null){
//        if(current?.random!=null) newCurrent.random = current.random!!.next
//        current = current?.next?.next
//        newCurrent = newCurrent.next?.next
//    }
//    // separated copyed node out of orginal list
//    current = node
//    var oldPre = current
//    newCurrent = node.next
//    var newListPreNode = newCurrent
//    while (current?.next?.next!=null&& newCurrent?.next?.next!= null){
//        current = current.next?.next
//        newCurrent = newCurrent.next!!.next
//        oldPre?.next = current
//        oldPre = current
//        newListPreNode?.next = newCurrent
//        newListPreNode = newCurrent
//    }
//    // because last node of the old list still link to last node of the new list so we have to make it point to null
//    current?.next = null
//
//    printNodeList(node)
//    println(" old List")
//    printNodeList(copyedListHead)
//    println("new List")
//    return copyedListHead
//}


class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
    var isOld = true
}

fun arrayToNodeList(arr: IntArray): Node? {
    var current = Node(0)
    val head = current
    for (i in arr) {
        current.next = Node(i)
        current = current.next!!
    }
    return head.next
}

fun printNodeList(node: Node?) {
    if (node == null) return
    var curr = node
    while (curr != null) {
        print("${curr?.`val`} ${curr?.isOld}  randome = ${curr.random?.`val`}  ${curr.random?.isOld}  ")
        curr = curr.next
    }
}

