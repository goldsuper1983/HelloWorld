package spacecat.learn.kotlin

fun main(){
    val nums = intArrayOf(2,5,0,1,4)
    println(canJump(nums))
}

fun canJump(nums:IntArray): Boolean{
    var runner = nums.size-2
    var jumpPoint = nums.size-1
    while( runner >=0){
        if(nums[runner]>=jumpPoint-runner) jumpPoint = runner
        println("jump points =${nums[jumpPoint]} i = $jumpPoint")
        runner--
    }
    return jumpPoint==0
}