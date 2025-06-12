package spacecat.learn.kotlin
//Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//
//
//
//Example 1:
//
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//Example 2:
//
//Input: target = 4, nums = [1,4,4]
//Output: 1
//Example 3:
//
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
//
//
//Constraints:
//
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 104

fun main() {
    val nums = intArrayOf(1,2,3,4,5)
    println(minSubArrayLen(11, nums))
}
//chat leetcode way
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var right = 0
    var min = Int.MAX_VALUE
    var sum = 0
    while (right < nums.size) {
        sum += nums[right]
        while (sum >= target) {
            if (right - left + 1 < min) min = right - left + 1
            sum -= nums[left]
            left++
        }
        println("left = $left right= $right min = $min")
        right++
    }
    return if(min == Int.MAX_VALUE) 0 else min

}