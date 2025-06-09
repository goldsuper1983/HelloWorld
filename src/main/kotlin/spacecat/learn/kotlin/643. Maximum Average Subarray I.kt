package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(4, 0, 4, 3, 3)
    println(findMaxAverageb(nums, 5))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var left = 0
    var right = 0
    var maxTotal = 0.0
    var curren = 0.0
    if (nums.size == 1) return (nums[k - 1].toDouble() / k)
    while (right < nums.size) {
        while (right < k && right < nums.size) {
            curren += nums[right]
            maxTotal = curren
            right++
        }
        if (right > nums.size - 1) return maxTotal / k
        curren = curren - nums[left++] + nums[right++]
        maxTotal = if (curren > maxTotal) curren else maxTotal
//        println("max = $maxTotal c = $curren left :$left right :$right")
    }
    return maxTotal / k
}

// best solution

fun findMaxAverageb(nums: IntArray, k: Int): Double {
    var sum = 0.0
    for (i in 0 until k) {
        sum += nums[i]
    }
    var maxSum = sum
    for(i in k until nums.size){
        sum += nums[i] - nums[i-k]
        maxSum = if(sum> maxSum) sum else maxSum
    }
    return maxSum/k
}

