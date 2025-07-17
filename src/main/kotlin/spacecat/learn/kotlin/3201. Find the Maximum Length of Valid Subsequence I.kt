package spacecat.learn.kotlin

//You are given an integer array nums.
//A subsequence sub of nums with length x is called valid if it satisfies:
//
//(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
//Return the length of the longest valid subsequence of nums.
//
//A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//
//Output: 4
//
//Explanation:
//
//The longest valid subsequence is [1, 2, 3, 4].
//
//Example 2:
//
//Input: nums = [1,2,1,1,2,1,2]
//
//Output: 6
//
//Explanation:
//
//The longest valid subsequence is [1, 2, 1, 2, 1, 2].
//
//Example 3:
//
//Input: nums = [1,3]
//
//Output: 2
//
//Explanation:
//
//The longest valid subsequence is [1, 3].
//
//
//
//Constraints:
//
//2 <= nums.length <= 2 * 105
//1 <= nums[i] <= 107

fun main() {
    val nums = intArrayOf(1,2,2)
    println(nums.joinToString())
    println(maximumLength(nums))
}

fun maximumLength(nums: IntArray): Int {
    var oddNumber = 0
    var nonOddNumber = 0
    var isItOddNumber = nums[0] % 2 != 0
    var starOdd = if (isItOddNumber) 1 else 0
    var starOddFlag = isItOddNumber
    var starNonOdd = if (!isItOddNumber) 1 else 0
    var starNonOddFlag = isItOddNumber

    println(" starodd $isItOddNumber  $starOdd startnonodd $starNonOdd ")
    for (i in nums) {
        isItOddNumber = (i % 2 != 0)
        if (isItOddNumber) oddNumber++ else nonOddNumber++
        if (isItOddNumber != starNonOddFlag) {
            starNonOddFlag = !starNonOddFlag
            starNonOdd++
        }
        if (isItOddNumber != starOddFlag) {
            starOddFlag = !starOddFlag
            starOdd++
        }
    }
    println("odd: $oddNumber noOdd: $nonOddNumber startNonOdd: $starNonOdd startOdd :$starOdd")
    var result = if (oddNumber > nonOddNumber) oddNumber else nonOddNumber
    result = if (result > starOdd) result else starOdd
    result = if (result > starNonOdd) result else starNonOdd
    return result
}