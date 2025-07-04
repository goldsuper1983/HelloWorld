package spacecat.learn.kotlin

//Given a binary array nums, return the maximum number of consecutive 1's in the array.
//
//
//
//Example 1:
//
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
//Example 2:
//
//Input: nums = [1,0,1,1,0,1]
//Output: 2
//
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.

fun main(){
    val nums = intArrayOf(1,1)
    println(findMaxConsecutiveOnes(nums))
}
fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxOne =0
    var countOne =0
    for(i in nums){
        if(i==1) countOne++
        if(i!=1){
            if(maxOne < countOne) maxOne = countOne
            countOne = 0
        }
    }
    if( nums.last() == 1) {
        if(maxOne < countOne) maxOne = countOne
    }
    return maxOne
}