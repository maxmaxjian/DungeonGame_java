class Solution2 : Solution {

    override fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val nrow = dungeon.size
        val ncol = dungeon[0].size
        val dp = Array(nrow+1){ IntArray(ncol+1){ Int.MAX_VALUE } }
        dp[nrow][ncol-1] = 1
        dp[nrow-1][ncol] = 1

        for (i in nrow-1 downTo 0) {
            for (j in ncol-1 downTo 0) {
                val need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]
                dp[i][j] = if (need <= 0) 1 else need
            }
        }

        return dp[0][0]
    }
}