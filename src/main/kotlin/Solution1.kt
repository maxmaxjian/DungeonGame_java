class Solution1 : Solution {

    private val map = hashMapOf<Pair<Int,Int>,Pair<Int,Int>>()

    override fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val nrow = dungeon.size
        val ncol = dungeon[0].size

        return minHP(dungeon, nrow-1, ncol-1).first
    }

    private fun minHP(dg: Array<IntArray>, x: Int, y: Int): Pair<Int,Int> {
        val pr = Pair(x,y)
        if (!map.containsKey(pr)) {
            var prev: Pair<Int,Int>
            var before: Int
            var after: Int
            if (x == 0 && y == 0) {
                before = when {
                    dg[x][y] < 0 -> 1-dg[x][y]
                    else -> 1
                }
                after = before+dg[x][y]
            } else {
                when {
                    x == 0 -> prev = minHP(dg, x, y-1)
                    y == 0 -> prev = minHP(dg, x-1, y)
                    else -> {
                        val prevLeft = minHP(dg, x, y-1)
                        val prevUp = minHP(dg, x-1, y)
                        prev = when {
                            prevLeft.first < prevUp.first -> prevLeft
                            prevLeft.first == prevUp.first -> when {
                                prevLeft.second < prevUp.second -> prevUp
                                else -> prevLeft
                            }
                            else -> prevUp
                        }
                    }
                }
                when {
                    dg[x][y]+prev.second <= 0 -> {
                        before = prev.first-(dg[x][y]+prev.second)+1
                        after = 1
                    }
                    else -> {
                        before = prev.first
                        after = prev.second+dg[x][y]
                    }
                }
            }
            map[pr] = Pair(before, after)
            println("$pr = ${map[pr]}")
        }
        return map[pr]!!
    }
}