package spacecat.learn.kotlin

//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//Return the max sliding window.
//
//
//
//Example 1:
//
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
//1 [3  -1  -3] 5  3  6  7       3
//1  3 [-1  -3  5] 3  6  7       5
//1  3  -1 [-3  5  3] 6  7       5
//1  3  -1  -3 [5  3  6] 7       6
//1  3  -1  -3  5 [3  6  7]      7
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//1 <= k <= nums.length

fun main() {
    val nums = intArrayOf(1,2)
    println(maxSlidingWindow(nums, k = 3).joinToString())
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.size <= k) {
        return nums
    }
    val resultArray = IntArray(nums.size)
    var stackHead = 0
    var stackTail = -1
    val stack = IntArray(nums.size)
    var resultArrayRunner = 0
    for (i in nums.indices) {
        while (stackTail >= stackHead && nums[stack[stackTail]] <= nums[i]) stackTail--
        stackTail++
        stack[stackTail] = i
        resultArray[resultArrayRunner++] = nums[stack[stackHead]]
        if (stack[stackHead] + k - 1 == i) stackHead++

//        println(stack.joinToString())
//        println("head = $stackHead tail = $stackTail")
//        println(resultArray.joinToString())
    }
    return resultArray.copyOfRange(k-1, resultArray.size)
}
