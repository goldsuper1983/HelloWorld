package spacecat.learn.kotlin

fun main() {
    val nums = intArrayOf(-7,-3,2,3,11)
    println(sortedSquares(nums).joinToString())
}

fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var left = 0
    var right = nums.size - 1
    var runner = nums.size-1
    while (left <= right){
        if(nums[left]*nums[left] < nums[right]*nums[right]){
            result[runner] = nums[right]*nums[right]
            right--
        }else{
            result[runner] = nums[left]*nums[left]
            left++
        }
        runner--
    }
return result
}
