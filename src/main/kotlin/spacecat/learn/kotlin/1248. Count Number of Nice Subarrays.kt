package spacecat.learn.kotlin

//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//
//Return the number of nice sub-arrays.
//
//
//
//Example 1:
//
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
//Example 2:
//
//Input: nums = [2,4,6], k = 1
//Output: 0
//Explanation: There are no odd numbers in the array.
//Example 3:
//
//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16
//
//
//Constraints:
//
//1 <= nums.length <= 50000
//1 <= nums[i] <= 10^5
//1 <= k <= nums.length

fun main() {
    val nums= intArrayOf(1,1,2,1,1)
    val k= 3
    println(numberOfSubarrays(nums,k))
}

fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    var counter = 0
    val map = hashMapOf<Int, Int>()
    var prefixSumOfOddNumber = 0
    map[0] = 1
    for (i in nums.indices) {
        if(nums[i]%2==1){
            prefixSumOfOddNumber++
        }
        if (map.contains(prefixSumOfOddNumber - k)) {
            counter += map[prefixSumOfOddNumber - k]!!
        }
        if (map.contains(prefixSumOfOddNumber)) {
            map[prefixSumOfOddNumber] = map[prefixSumOfOddNumber]!! + 1
        } else map[prefixSumOfOddNumber] = 1
    }
    return counter
}
