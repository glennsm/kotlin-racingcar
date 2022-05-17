package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ValueSource(strings = ["glenn", "이상민"])
    @ParameterizedTest
    fun `자동차는 이름을 가진다`(name: String) {
        val car = Car(name)
        assertThat(car.name).isEqualTo(name)
    }

    @Test
    fun `자동차의 이름은 1글자 이상이자 5글자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Car("5자초과초과초과") }
    }

    @Test
    fun `자동차의 이름은 1글자 이상이어야 한다`() {
        assertThrows<IllegalArgumentException> { Car("") }
    }

    @ValueSource(ints = [4, 5, 6, 7, 8])
    @ParameterizedTest
    fun `무작위로 나온 숫자가 4 이상일 때 전진한다`(condition: Int) {
        val car = Car("glenn", 3)
        car.move(condition)
        assertThat(car.position).isEqualTo(4)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `무작위로 나온 숫자가 4 미만일 때는 움직이지 않는다`(condition: Int) {
        val car = Car("glenn", 3)
        car.move(condition)
        assertThat(car.position).isEqualTo(3)
    }
}
