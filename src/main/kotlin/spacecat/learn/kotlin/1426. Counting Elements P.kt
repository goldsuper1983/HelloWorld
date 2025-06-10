package spacecat.learn.kotlin

fun main(){
    val arr = intArrayOf(1,1,3,3,5,5,7,7)
    println(countingElements(arr))
}

fun countingElements( arr: IntArray):Int{
    var count =0
    val set = hashSetOf<Int>()
    for(i in  arr.indices){
        set.add( arr[i])
    }
    for (i in arr.indices){
        if(set.contains(arr[i]+1)) count++
    }
    return count
}