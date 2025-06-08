package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    println(nums.joinToString ())
    rotate(nums, 4)
    println(nums.joinToString())
}

fun rotate(nums: IntArray, k: Int) {
    val size = nums.size - 1
    val insideK = if (k < nums.size) k else (k % nums.size)
    val tempArray = IntArray(insideK)
    if (size > 0) {
        for (i in 0 until insideK) {
            var j = size - i
            val t = nums[j]
            while (j - insideK >= 0) {
                nums[j] = nums[j - insideK]
                j -= insideK
            }
            tempArray[i] = t
//            println(tempArray.joinToString ())
//        println(nums.joinToString(":"))
        }
        for (i in 0 until insideK) {
            nums[insideK - i - 1] = tempArray[i]
        }
//        println(nums.joinToString(":"))
    }
}





