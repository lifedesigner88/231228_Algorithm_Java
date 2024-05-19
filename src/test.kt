fun square(x: Int): Int {
    return x * x
}


fun main() {
    val result: Int = square(2)
    println(result)

    var sum = 0
    for (i in 10 downTo 0 step 2) {
        sum += i
        println("$i 코틀린 대박")
        println(sum)
    }




}


