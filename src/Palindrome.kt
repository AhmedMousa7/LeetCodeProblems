fun main() {
    print(isPalindrome(122))
}

// Solution 2 by reverse the number without converting it to string
// https://medium.com/@ManBearPigCode/how-to-reverse-a-number-mathematically-97c556626ec6

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    var copyX = x
    var reversedX = 0
    while (copyX > 0) {
        // Step 1- Isolate the last digit in number
        val lastDigit = copyX % 10
        // Step 2- Append lastDigit to reverse
        reversedX = (reversedX * 10) + lastDigit
        // Step 3- Remove last digit from number
        copyX /= 10
    }

    return reversedX == x
}


/*

Solution 1 by converting the number into string

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    val xString = x.toString()
    var newX = ""
    for (i  in xString.length-1 downTo 0){
        newX += xString[i]
    }

    return newX == xString
}

 */