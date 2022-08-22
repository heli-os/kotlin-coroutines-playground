import kotlinx.coroutines.*

/**
 * @Author Heli
 */
fun main() = runBlocking {
    val pool = newFixedThreadPoolContext(3, "myPool")
    val ctx = newSingleThreadContext("ctx")

    val tasks = mutableListOf<Deferred<Unit>>()
    for (i in 0..5) {
        val task = GlobalScope.async(pool) {
            println("Processing $i in ${Thread.currentThread().name}")

            withContext(ctx) {
                println("Step two of $i happening in thread ${Thread.currentThread().name}")
            }

            println("Finishing $i in ${Thread.currentThread().name}")
        }

        tasks.add(task)
    }

    tasks.forEach {
        it.await()
    }
}
