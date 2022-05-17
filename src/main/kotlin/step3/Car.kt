package step3

class Car(val name: String, var position: Int = 0) {

    init {
        require(name.trim().length in NAME_LENGTH_RANGE) {
            "자동차의 이름은 1글자에서 5글자 사이입니다."
        }
    }

    fun move(condition: Int) {
        // val condition = (0..9).random()
        if (condition >= MOVING_CONDITION) {
            position++
        }
    }

    companion object {
        private const val MOVING_CONDITION: Int = 4
        private val NAME_LENGTH_RANGE: IntRange = (1..5)
    }
}
