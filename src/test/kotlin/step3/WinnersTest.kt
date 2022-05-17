package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTest {
    @Test
    fun `가장 멀리 간 자동차가 우승한 자동차다`() {
        val cars = listOf(
            Car("glenn", 100),
            Car("pobi", 0)
        )
        val winners = Winners(cars)
        assertThat(winners.find()[0].name).isEqualTo("glenn")
    }
}

class Winners(val cars: List<Car>) {
    fun find(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
