package spacecat.learn.kotlin

//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
//Implement the MovingAverage class:
//
//    MovingAverage(int size) Initializes the object with the size of the window size.
//double next(int val) Returns the moving average of the last size values of the stream.
//
//
//Example 1:
//
//Input
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//Output
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//Explanation
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // return 1.0 = 1 / 1
//movingAverage.next(10); // return 5.5 = (1 + 10) / 2
//movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
//
//
//Constraints:
//
//1 <= size <= 1000
//-105 <= val <= 105
//At most 104 calls will be made to next.

fun main(){
    val movingAverage = MovingAverage(3)
    println(movingAverage.next(3))
    println(movingAverage.next(4))
    println(movingAverage.next(4))
    println(movingAverage.next(4))
    println(movingAverage.next(4))
}
class MovingAverage(size: Int) {
    val size = size
    var sum =0.0
    var currentTotalNode = 0
    var head : LinkNode? = null
    var last : LinkNode? = null
    fun next(`val`: Int): Double {
        val newNode = LinkNode(`val`)
        sum +=`val`
        if(currentTotalNode == 0) {
            head = newNode
            last = head
            currentTotalNode =1
        }else {
            last?.next = newNode
            last = newNode
            if(currentTotalNode >= size ){
                sum-= head?.`val`!!
                head = head?.next
            }else currentTotalNode++
        }
        return sum/currentTotalNode
    }
}
class LinkNode(var `val`:Int){
    var next : LinkNode? = null

}