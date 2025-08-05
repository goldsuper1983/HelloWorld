package spacecat.learn.kotlin

//You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.
//
//From left to right, place the fruits according to these rules:
//
//Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
//Each basket can hold only one type of fruit.
//If a fruit type cannot be placed in any basket, it remains unplaced.
//Return the number of fruit types that remain unplaced after all possible allocations are made.
//
//
//
//Example 1:
//
//Input: fruits = [4,2,5], baskets = [3,5,4]
//
//Output: 1
//
//Explanation:
//
//fruits[0] = 4 is placed in baskets[1] = 5.
//fruits[1] = 2 is placed in baskets[0] = 3.
//fruits[2] = 5 cannot be placed in baskets[2] = 4.
//Since one fruit type remains unplaced, we return 1.
//
//Example 2:
//
//Input: fruits = [3,6,1], baskets = [6,4,7]
//
//Output: 0
//
//Explanation:
//
//fruits[0] = 3 is placed in baskets[0] = 6.
//fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) but can be placed in the next available basket, baskets[2] = 7.
//fruits[2] = 1 is placed in baskets[1] = 4.
//Since all fruits are successfully placed, we return 0.
//
//
//
//Constraints:
//
//n == fruits.length == baskets.length
//1 <= n <= 100
//1 <= fruits[i], baskets[i] <= 1000

fun main() {
    val fruits = intArrayOf(4, 2, 5)
    val baskets = intArrayOf(3, 5, 4)
    println(numOfUnplacedFruits(fruits, baskets))
}

fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray):Int {
    var result = 0
    for (fruit in fruits) {
        var isBasketFound = false
        for (basket in baskets.indices) {
            if (fruit <= baskets[basket]) {
                baskets[basket] = 0
                isBasketFound = true
                break
            }
        }
        if (!isBasketFound) result++
    }
    return result
}

/// stupid way with link list
fun numOfUnplacedFruits1(fruits: IntArray, baskets: IntArray): Int {
    var result = 0
    var currentNode = putBasketInBasketLinkList(baskets)
    val dummyBasketList = BasketLinkList(0)
    dummyBasketList.next = currentNode
//    println(fruits.joinToString())
//    printBasket(dummyBasketList.next)
    var preBasketNode = dummyBasketList
    for (fruit in fruits) {
        while (currentNode != null && currentNode.`val` < fruit) {
            currentNode = currentNode.next
            preBasketNode = preBasketNode.next!!
            println(if (currentNode != null) currentNode.`val` else "null")
        }
        if (currentNode == null) result++
        else {
            preBasketNode.next = currentNode.next
        }
        currentNode = dummyBasketList.next
        preBasketNode = dummyBasketList
    }
    return result
}

class BasketLinkList(var `val`: Int) {
    var next: BasketLinkList? = null
}

fun putBasketInBasketLinkList(baskets: IntArray): BasketLinkList? {
    if (baskets.isEmpty()) return null
    val dummyHead = BasketLinkList(0)
    var currentNode = dummyHead
    for (basket in baskets) {
        val newNode = BasketLinkList(basket)
        currentNode.next = newNode
        currentNode = newNode
    }
//    printBasket(dummyHead.next)
    return dummyHead.next
}

fun printBasket(head: BasketLinkList?) {
    if (head == null) return
    var current = head
    while (current != null) {
        print("${current.`val`}, ")
        current = current.next
    }
//    println()
}