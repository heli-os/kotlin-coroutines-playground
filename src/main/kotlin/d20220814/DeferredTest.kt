package d20220814

import kotlinx.coroutines.*

/**
 * @Author Heli
 */
fun main() = runBlocking {
    asyncTasks().join()
}

@OptIn(ExperimentalCoroutinesApi::class, InternalCoroutinesApi::class)
private fun asyncTasks() = GlobalScope.launch {

    val feeds = listOf("A", "B", "C", "D")
    val requests = mutableListOf<Deferred<List<String>>>()
    val dispatcher = newFixedThreadPoolContext(2, "IO")

    feeds.mapTo(requests) {
        asyncSomeActions(it, dispatcher)
    }
    requests.forEach {
        it.join()
    }
    val results = requests
        .filter { !it.isCancelled }
        .flatMap { it.getCompleted() }

    val failed = requests
        .filter { it.isCancelled }
        .map { it.getCancellationException().cause }
    println(results)
    println(failed)
}

private fun asyncSomeActions(feed: String, dispatcher: CoroutineDispatcher) =
    GlobalScope.async(dispatcher) {
        if (feed == "C") throw IllegalArgumentException("feed is $feed")
        listOf("result1: $feed", "result2: $feed")
    }
