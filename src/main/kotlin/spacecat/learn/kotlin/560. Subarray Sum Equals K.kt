package spacecat.learn.kotlin

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//Example 1:
//
//Input: nums = [1,1,1], k = 2
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3], k = 3
//Output: 2
//
//
//Constraints:
//
//1 <= nums.length <= 2 * 104
//-1000 <= nums[i] <= 1000
//-107 <= k <= 107


fun main() {
    val nums = intArrayOf(1,2,1,2,1)
    println(subarraySum(nums, 3))

}

fun subarraySum(nums: IntArray, k: Int): Int {
    val map = hashMapOf<Int, Int>()
    var prefixSum = 0
    var count = 0
    map[0] = 1
    for (i in nums) {
        prefixSum += i
        if (map.contains(prefixSum - k)) {
            count+= map[prefixSum-k]!!
        }
        if (map.contains(prefixSum)) map[prefixSum] = map[prefixSum]!!+1
        else map[prefixSum] = 1
    }
    return count
}