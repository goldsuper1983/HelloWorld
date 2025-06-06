package spacecat.learn.kotlin

fun main() {
 val nums = intArrayOf(3,2,4)
    println(twoSum(nums,6).joinToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    var runner = 0
    while(runner < nums.size-1){
        for (secondNum in (runner+1) until nums.size){
            if(nums[runner]+nums[secondNum] == target)
                return intArrayOf(runner,secondNum)
        }
        runner++
    }
    return intArrayOf(0,0)
}