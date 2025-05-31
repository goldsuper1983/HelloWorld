package spacecat.learn.kotlin//7. Reverse Integer
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
//
//
//Constraints:
//
//-231 <= x <= 231 - 1

fun main(){
    println(reverse(123123123))
}

fun reverse(x: Int): Int {
    var number= x.toLong()
    var outcome=0L
    println("number =$number")
    if(number in Int.MIN_VALUE..Int.MAX_VALUE){
        while(number!=0L){
            outcome*=10
            outcome +=number%10
            number/=10
            // println("outcome=$outcome number=$number")
        }
    }else return 0
    return outcome.toInt()
}