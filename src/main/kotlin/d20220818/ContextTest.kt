package d20220818

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * @Author Heli
 */
fun main() = runBlocking {
    val job = GlobalScope.async {
        delay(1000)
        "a"
    }

    val millis = measureTimeMillis {
        println(
            "${job.await()} / ${
                withContext(Dispatchers.IO) {
                    "b"
                }
            }"
        )
    }
    println(millis)
}
