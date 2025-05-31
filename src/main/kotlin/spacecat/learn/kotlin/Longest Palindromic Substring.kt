package spacecat.learn.kotlin

fun main(){
    val s="bbsdfsdfsdfsdf"
    val allPalSubString = allPalindromicSubString(s)
    var longest:String = ""
    println(s)
    allPalSubString.forEach {
        if(longest.length<it.length) longest = it
    }
    println(allPalSubString)
    println(longest)
}
fun allPalindromicSubString(str:String): List<String>{
    val listString = mutableListOf("")
    val allString = mutableListOf("")
    for(beginSubString in str.indices){
        for(endSubString in beginSubString .. str.length){
            allString.add(str.substring(beginSubString,endSubString))

            if(endSubString== beginSubString) listString.add(str[beginSubString].toString())
            else if(isPalindromicString(str.substring(beginSubString,endSubString)))
                listString.add(str.substring(beginSubString,endSubString))
        }
    }
    println(allString)
    return listString
}
fun isPalindromicString(str:String):Boolean{
    if(str.length ==1) return true
    if(str.length>2) {
        for(i in 0 .. str.length/2)
            if(str[i]!= str[str.length-i-1])return false
    }else   {
        if (str[0]!=str[1]) return false
    }
    return true
}