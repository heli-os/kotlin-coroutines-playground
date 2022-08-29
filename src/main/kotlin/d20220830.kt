import kotlinx.coroutines.runBlocking

/**
 * @author Heli
 * Created on 2022. 08. 30
 */

suspend fun first() = "first"
suspend fun second() = 2
suspend fun third() = 3L

suspend fun wrap() {
    println("step 1")
    println("---Result1 ${first()}")

    println("step 2")
    println("---Result2 ${second()}")

    println("step 3")
    println("---Result3 ${third()}")
}

fun main() = runBlocking {
    wrap()
}
