package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(0, 1)
    println(missingNumber(nums))
}

// using hash map
fun missingNumber(nums: IntArray): Int {
    val set = hashSetOf<Int>()
    var max = 0
    for (i in nums.indices) {
        set.add(nums[i])
        if (nums[i] > max) max = nums[i]
    }
    for (i in 0..max) {
        if (!set.contains(i)) return i

    }
    return max + 1
}
