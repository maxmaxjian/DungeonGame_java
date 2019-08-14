import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SolutionTest(
    private val input: Array<IntArray>,
    private val expected: Int) {

    private val soln = Solution2()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun params() = arrayOf(
            arrayOf(
                arrayOf(intArrayOf(-2,-3,3), intArrayOf(-5, -10, 1), intArrayOf(10, 30, -5)), 7
            ),
            arrayOf(
                arrayOf(intArrayOf(100)), 1
            ),
            arrayOf(
                arrayOf(intArrayOf(1,-3,3), intArrayOf(0,-2,0), intArrayOf(-3,-3,-3)), 3
            ),
            arrayOf(
                arrayOf(intArrayOf(-1,1)), 2
            )
        )
    }

    @Test
    fun test() {
        assertEquals(expected, soln.calculateMinimumHP(input))
    }
}