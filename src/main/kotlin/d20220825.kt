/**
 * @author Heli
 * Created on 2022. 08. 25
 */
fun main() {
    val eagor = listOf(5, 4, 3, 2, 1)
    val eagorSum: List<Int> = eagor.map { print("$it "); it * it }

    println(eagorSum.sum())


    val lazy = sequence {
        yield(5)
        yield(4)
        yield(3)
        yield(2)
        yield(1)
    }.map {
        println("$it ")
        it * it
    }
    println("before sum ")

    val lazySum = lazy.sum() // terminal

    println(lazySum)
}
