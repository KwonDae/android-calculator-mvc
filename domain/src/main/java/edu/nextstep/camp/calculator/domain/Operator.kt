package edu.nextstep.camp.calculator.domain

enum class Operator(
    val operator: String,
    val calculate: (Int, Int) -> Int
) {
    PLUS("+", { first, second ->
        first.plus(second)
    }),

    MINUS("-", { first, second ->
        first.minus(second)
    }),

    TIMES("*", { first, second ->
        first.times(second)
    }),

    DIV("/", { first, second ->
        first.div(second)
    });

    companion object {
        fun find(operator: String): Operator = values().find {
            it.operator == operator
        } ?: throw IllegalArgumentException()
    }
}
