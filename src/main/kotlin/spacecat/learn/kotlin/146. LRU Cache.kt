package spacecat.learn.kotlin

//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
//Implement the LRUCache class:
//
//    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//The functions get and put must each run in O(1) average time complexity.
//
//
//
//Example 1:
//
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
//
//
//Constraints:
//
//1 <= capacity <= 3000
//0 <= key <= 104
//0 <= value <= 105
//At most 2 * 105 calls will be made to get and put.
fun main() {
    val lru = LRUCache(10)
    lru.apply {
        put(10,13)
        put(3,17)
        put(6,11)
        put(10,5)
        put(9,10)
        get(13)
        put(2,19)
        get(2)
        put(5,5)
        get(3)
    }

}

class LRUCache(private val capacity: Int) {
    val map = hashMapOf<Int, LRUDoubleLinkList>()
    var currentCap = 0
    var lastNode = LRUDoubleLinkList(0,0)
    var dummyHead = LRUDoubleLinkList(0,0)

    fun get(key: Int): Int {
        var result = -1
        print("get $key =")
        if (map.containsKey(key)) {
            val currentNote = map[key]
            result = currentNote?.`val`!!
            if(currentNote!=lastNode){
                // move this to end list recently use
               moveDoubleLinkNodeToEnd(currentNote)
            }
        }
        println(" lastkey = (${lastNode.key},${lastNode.`val`})")
        printDoubleLinkList(dummyHead)
        return result
    }
    fun put(key: Int, value: Int) {
        print("put ($key,$value)")
        if (map.containsKey(key)) {
            // if key already in the list just update value and move this node to the last
            val currentNOde = map[key]
            currentNOde?.`val` = value
            if (currentNOde != lastNode) {
               moveDoubleLinkNodeToEnd(currentNOde!!)
            }
        } else {
            if (currentCap == 0) {
                /// init first node
                val newNode = LRUDoubleLinkList(key,value)
                map[key] = newNode
                lastNode = newNode
                dummyHead.next = lastNode
                lastNode.pre = dummyHead
                currentCap++
            } else {
                // add new node to the tail
                val newNode = LRUDoubleLinkList(key,value).apply { pre = lastNode }
                map[key] = newNode
                lastNode.next = newNode
                lastNode = newNode
                /////
                if (currentCap < capacity) {
                    currentCap++
                } else {
                    // there is no space so need to remove Least Recently Used node
                    map.remove(dummyHead.next?.key)
                    dummyHead.next = dummyHead.next?.next
                    dummyHead.next?.pre = dummyHead
                }
            }
        }
        println(" last key (${lastNode.key},${lastNode.`val`}) current cap  =$currentCap")
        printDoubleLinkList(dummyHead)
    }
    private fun moveDoubleLinkNodeToEnd(currentNote:LRUDoubleLinkList){
        currentNote.pre?.next = currentNote.next
        currentNote.next?.pre = currentNote.pre
        currentNote.pre = lastNode
        currentNote.next = null
        lastNode.next = currentNote
        lastNode = currentNote
    }
}



fun printDoubleLinkList(node: LRUDoubleLinkList) {
    if (node.next == null) return
    var currNote = node.next
    while (currNote != null) {
        print("(${currNote.key},${currNote.`val`})-")
        currNote = currNote.next
    }
    println()
}

class LRUDoubleLinkList(val key: Int, var `val`: Int) {

    var next: LRUDoubleLinkList? = null
    var pre: LRUDoubleLinkList? = null
}