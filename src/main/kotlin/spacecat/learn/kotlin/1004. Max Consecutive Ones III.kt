package spacecat.learn.kotlin

import kotlin.math.max

fun main() {
    val nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1)
    println(longestOnesw(nums,3))

}
fun longestOnes(nums: IntArray, k: Int): Int{
    var left =0
    var countZ =0
    var outcome =0
    for(i  in 0 until nums.size){
        if(nums[i]==0) countZ++

        while (countZ >k){
            if(nums[left]== 0) countZ--
            left++
        }
        outcome= if (i-left+1 >outcome) i-left+1 else outcome
    }
    return outcome
}
fun longestOnesw(nums: IntArray, k: Int): Int {
    var maxLength = 0
    var countK = 0
    var left = 0
    var right = 0
    while (countK < k && right < nums.size) {
        if (nums[right] == 0) countK++
        right++
    }
    maxLength = right - left+1
    println("left: $left right:$right max:$maxLength k: $k")
    while (right < nums.size) {
        if (nums[right] == 0) countK++
        while (countK > k) {
            left++
            if (nums[left] == 0) countK--
        }
        maxLength = if (maxLength > right - left+1) maxLength else right - left+1
        println("left: $left right:$right max:$maxLength k: $k")
        right++
    }
    return maxLength
}

