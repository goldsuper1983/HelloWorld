package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(0,0)
    println(minStartValue(nums))
}

fun minStartValue(nums: IntArray): Int {
    var smallest = Int.MAX_VALUE
    var curren = 1
    for (i in nums.indices) {
        curren += nums[i]
        if (smallest > curren) smallest = curren
    }
    return if(smallest >1) 1
    else
        1-smallest +1
}