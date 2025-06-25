package spacecat.learn.kotlin

//Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
//
//
//
//Example 1:
//
//Input: nums = [5,7,3,9,4,9,8,3,1]
//Output: 8
//Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.
//Example 2:
//
//Input: nums = [9,9,8,8]
//Output: -1
//Explanation: There is no number that occurs only once.
//
//
//Constraints:
//
//1 <= nums.length <= 2000
//0 <= nums[i] <= 1000

fun main() {
    val nums = intArrayOf(0,0,0)
    println(largestUniqueNumber(nums))
}

fun largestUniqueNumber(nums: IntArray): Int {
    val map = IntArray(1001) { 0 }
    for (num in nums) {
        map[num]++
    }
    for (num in 1000 downTo 0) {
        if (map[num] == 1) return num
    }
    return -1
}