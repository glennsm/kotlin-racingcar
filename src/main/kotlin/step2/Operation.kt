package step2

enum class Operation(val exp: String, val compute: (Int, Int) -> Int) {
    PLUS("+", { v1, v2 -> v1 + v2 }),
    MINUS("-", { v1, v2 -> v1 - v2 }),
    MULTIPLY("*", { v1, v2 -> v1 * v2 }),
    DIVIDE("/", { v1, v2 ->
        if (v2 == 0) throw IllegalArgumentException()
        v1 / v2
    }),
    ;

    companion object {
        fun of(exp: String) = runCatching {
            values().first { it.exp == exp }
        }.getOrElse { throw IllegalArgumentException() }

        fun contains(exp: String): Boolean = of(exp) in values()
    }
}
