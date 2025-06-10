package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(2,2,1)
    println(getAveragesS(nums, 1).joinToString())
}
// sliding window

fun getAveragesS(nums: IntArray, k: Int): IntArray {
    val result = IntArray(nums.size) { -1 }
    var left = 0
    var right = 0
    var sum = 0L
    val window = k * 2 + 1
    var middle = k
    if(k==0) return nums
    if(window > nums.size) return result
    for (i in 0 until window) {
        sum += nums[i]
        right++
    }
    println("right: $right")
    while (right < nums.size) {
        result[middle++] = (sum / window).toInt()
        sum += nums[right++]
        sum -= nums[left++]
        println("right: $right")
    }
    result[middle++] = (sum / window).toInt()
    println("right: $right")
    return result
}

/// prefix Sum strategy  this problem
fun getAverages(nums: IntArray, k: Int): IntArray {
    val result = IntArray(nums.size)
    var sum = 0L
    val prefixSumArray = LongArray(nums.size)
    for (i in nums.indices) {
        sum += nums[i]
        prefixSumArray[i] = sum
    }
    println(prefixSumArray.joinToString())
    for (i in nums.indices) {
        if (i < k || nums.size - i - 1 < k) {
            result[i] = -1
        } else {
            if (i - k - 1 < 0)
                result[i] = ((prefixSumArray[i + k]) / (k * 2 + 1)).toInt()
            result[i] = (if (i - k - 1 < 0) (prefixSumArray[i + k]) / (k * 2 + 1)
            else (prefixSumArray[i + k] - prefixSumArray[i - k - 1]) / (k * 2 + 1)).toInt()

        }
    }
    return result
}


