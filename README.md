# kotlin-coroutines-playground

## d20220830

```kotlin
suspend fun wrap(continuation: Continuation, result: /* .. */) {
	label1: {
		// initiate Continuation
		// ...
		// invocation target method: wrap
		// ...
	}
	label2: {
		label3: {
			when(continuation.label) {
				0 -> {
					// Step 1. first suspending
					break
				}
				1 -> {
					// get Result or throw
					break; 
				}
				2 -> {
					// get Result or throw
					break label3
				}
				3 -> {
					// get Result or throw
					break label2
				}
				else -> throw Exception(...)
			}
			// Step 2. second suspending
			continuation.label = 2
		}
		// Step 3. third suspending
		continuation.label = 3
	}
	// last code block
}

fun main() = runBlocking {
	var label: Int = 0
	var result: /* .. */
	invokeSuspend(result) { continuation ->
		when(label) {
			0 -> {
				label = 1
				wrap(continuation, result)
				// get Result or throw
			}
			1 -> {
				// get Result or throw
			}
		}
	}
}
```
