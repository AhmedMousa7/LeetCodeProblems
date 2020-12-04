fun main(){
    println(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var max = 0
    var counter = 0
    var repution: Char? = null
    val map = mutableMapOf<Char, Int>()

    s.forEachIndexed {index, c ->
        if (map.containsKey(c)){
            max = kotlin.math.max(max, counter)
            val prIndex = map[c]
            val diff = index - prIndex!!
            if (repution == null || repution == c){
                counter = index - prIndex
            }else {
                if (diff > counter)
                    counter++
                else if (counter != diff){
                    counter = diff
                }
            }
            map[c] = index
            repution = c
        }else {
            map[c] = index
            counter++
        }
    }

    return kotlin.math.max(max, counter)
}