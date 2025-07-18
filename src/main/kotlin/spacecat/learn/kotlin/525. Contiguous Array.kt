package spacecat.learn.kotlin

//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
//
//
//
//Example 1:
//
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
//Example 2:
//
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//Example 3:
//
//Input: nums = [0,1,1,1,1,1,0,0,0]
//Output: 6
//Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.

fun main() {
    val nums = intArrayOf(1,0,0,1,1,1,0,1,0,0)
    println(findMaxLength(nums))
}
fun findMaxLength(nums: IntArray): Int {
    var result = 0
    val map = hashMapOf<Int,Int>()
    map[0]=-1
    var prefixSum =0
    for(i in nums.indices){
        if(nums[i]==0) prefixSum-=1
        if(nums[i]==1) prefixSum+=1
        if(map.contains(prefixSum)){
            if(result < i - map[prefixSum]!!) result = i - map[prefixSum]!!

        }else map[prefixSum] = i
    }
     return result
}

//fun findMaxLength(nums: IntArray): Int {
//    val numsSize = nums.size - 1
//    var lengthOfsameNunmerOnTheLeft = 1
//    var lengthOfsameNumberOnTheRight = 1
//    var i = 1
//    var result = 0
//    var maxResult = 0
//    while (i <= numsSize) {
//        if (nums[i] == nums[i - 1]) {
//            lengthOfsameNumberOnTheRight++
//
//        }
//        if (nums[i] != nums[i - 1] || i == numsSize) {
////            println("l = $lengthOfsameNunmerOnTheLeft r = $lengthOfsameNumberOnTheRight")
//            result =
//                if (lengthOfsameNunmerOnTheLeft < lengthOfsameNumberOnTheRight)
//                    lengthOfsameNunmerOnTheLeft * 2
//                else lengthOfsameNumberOnTheRight * 2
//            lengthOfsameNunmerOnTheLeft = lengthOfsameNumberOnTheRight
//            lengthOfsameNumberOnTheRight = 1
//            if (maxResult < result) maxResult = result
//        }
//        i++
//    }
//    return maxResult
//}
