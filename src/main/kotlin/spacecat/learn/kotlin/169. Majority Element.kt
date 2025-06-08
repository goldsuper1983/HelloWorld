package spacecat.learn.kotlin

fun main(){
 val nums = intArrayOf(2,2,1,1,1,2,2)
    println(majorityElement(nums))
}
//// Boyer-Moore Majority Vote Algorithm
fun majorityElement(nums: IntArray):Int{
    var numAt = 0
    var count=0
    for(i in nums.indices){
        if(count==0) numAt=i
        count += if(nums[numAt]== nums[i]) 1 else -1
    }
    return nums[numAt]
}