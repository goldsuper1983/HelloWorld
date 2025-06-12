package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(1,2,3,4,5)
    println(minSubArrayLen(11, nums))
}
//chat gpt way
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