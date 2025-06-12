package spacecat.learn.kotlin

//Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.
//
//
//Example 1:
//
//Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
//Output: [3,4]
//Explanation:
//The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
//Example 2:
//
//Input: nums = [[1,2,3],[4,5,6]]
//Output: []
//Explanation:
//There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
//
//
//Constraints:
//
//1 <= nums.length <= 1000
//1 <= sum(nums[i].length) <= 1000
//1 <= nums[i][j] <= 1000
//All the values of nums[i] are unique.

fun main() {
    val nums = arrayOf(intArrayOf(27,21,45,10,12,13), intArrayOf(7,34,45,10,12,27,13))
    println(intersection(nums).toString())
}
/// using hash map
fun intersection(nums: Array<IntArray>): List<Int> {

    val map = HashMap<Int, Int>()
    for (arr in nums) {
        for (num in arr) {

            if (map.contains(num)) map[num] = map[num]!! + 1
            else map[num] = 1
//            println("add: ${map.toString()}")
        }
    }
//    println(map.filter { it.value == nums.size }.keys.toList().joinToString())
    return map.filter { it.value == nums.size }.keys.toList().sorted()
}
