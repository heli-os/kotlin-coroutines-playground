package d20220818

import kotlinx.coroutines.*

/**
 * @Author Heli
 */
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val dispatcher = newFixedThreadPoolContext(2, "default")
    val job = GlobalScope.async(dispatcher) {
        delay(1000)
        "a"
    }
    val immediatelySuspend = withContext(dispatcher) {
        "b"
    }
    println(job.await())
    println(immediatelySuspend)
}
