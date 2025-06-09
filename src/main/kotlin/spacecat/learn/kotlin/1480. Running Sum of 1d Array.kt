package spacecat.learn.kotlin

fun main(){
    val nums = intArrayOf(1,2,3,4)
    println(runningSum(nums).joinToString())
}
fun runningSum(nums:IntArray):IntArray{
    var curr = 0
    for(i in nums.indices){
        curr+= nums[i]
        nums[i]=curr
    }
    return nums
}