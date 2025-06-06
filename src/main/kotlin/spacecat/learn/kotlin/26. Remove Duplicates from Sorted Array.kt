package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(1, 1, 2)
    println(removeDuplicates(nums))
}

fun removeDuplicates(nums: IntArray): Int {
    var k = 0
    for (i in 1 until nums.size) {
        if (nums[k] != nums[i]) {
            k++
            nums[k] = nums[i]
        }
    }
    println(nums.joinToString())
    return k + 1
}
