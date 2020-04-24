package ua.rolinskiy.counter.model

fun Counter.increment() {
    value++
}

fun Counter.decrement() {
    if (value > 0) {
        value--
    }
}

fun Counter.reset() {
    value = 0
}