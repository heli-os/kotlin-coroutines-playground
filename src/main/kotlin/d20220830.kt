import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author Heli
 * Created on 2022. 08. 30
 */

suspend fun first() = "first"
suspend fun second() = 2
suspend fun third() = 3L
suspend fun fourth() = "fourth"

suspend fun wrap() {
    println("step 1")
    println("---Result1 ${first()}")

    println("step 2")
    println("---Result2 ${second()}")

    println("step 3")
    println("---Result3 ${third()}")
}

fun main() = runBlocking {
    withContext(Dispatchers.IO) {
        wrap()
    }
}

