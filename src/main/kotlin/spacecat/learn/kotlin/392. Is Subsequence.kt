package spacecat.learn.kotlin
fun main(){
    val s1= "abcd"
    val s2 = "ahbgdc"
    println(isSubsequence(s1,s2))
}
fun isSubsequence(s: String, t: String): Boolean {
    var i =0
    var sLength = s.length
    if(s=="") return false
    for(j in 0 until t.length){
        if(s[i] == t[j]) {
//            println(" ${s[i]}  ${t[j]} $j")
            i++
//            println("$i  $sLength" )
        }
        if(i >= sLength) return true
    }
return false
}