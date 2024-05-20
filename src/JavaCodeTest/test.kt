package JavaCodeTest

fun square(x: Int): Int {
    return x * x
}

fun getTypeOfDay(dayOfWeek: Int): String {
    return when (dayOfWeek) {
        1 -> "한주의 시작"
        2,3,4 -> "주중"
        5 -> "한주의 끝"
        6, 7 -> "주말"
        else -> "질못된 날"
    }
}

// 확장함수기능
fun List<Int>.laseElement(): Int = this[this.size - 1]


fun main() {
    val result: Int = square(2)
    println(result)

    var sum = 0
    for (i in 10 downTo 0 step 2) {
        sum += i
        println("$i 코틀린 대박")
        println(sum)
    }
    println("-------")

    for (i in 1..10){
        println(getTypeOfDay(i))
    }

    val list = listOf(1,2,3,4,5)
    println(list.javaClass)
    println(list.laseElement())
}


