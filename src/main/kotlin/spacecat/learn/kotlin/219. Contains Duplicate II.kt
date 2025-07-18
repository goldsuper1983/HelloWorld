package spacecat.learn.kotlin
//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-109 <= nums[i] <= 109
//0 <= k <= 105

fun main() {
    val nums = intArrayOf(1,2,3,1,2,3)
    val k = 3
    println(containsNearbyDuplicate(nums,k))
}
// use hashmap
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = hashMapOf<Int,Int>()
    for(i in nums.indices){
        if(map.contains(nums[i])){
            if(i- map[nums[i]]!! <=k) return true
            else map[nums[i]] = i
        }else map[nums[i]]=i
    }
    return false
}
