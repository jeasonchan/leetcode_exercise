package com.zte.腐烂的橘子;

/*
在给定的网格中，每个单元格可以有以下三个值之一：

    值 0 代表空单元格；
    值 1 代表新鲜橘子；
    值 2 代表腐烂的橘子。

每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。



示例 1：

输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4

示例 2：

输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

示例 3：

输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。



提示：

    1 <= grid.length <= 10
    1 <= grid[0].length <= 10
    grid[i][j] 仅为 0、1 或 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotting-oranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
分析：
1、每轮只需要关注新增的坏橘子及其周围的橘子
2、
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        final int NO_ORANGE = 0;
        final int FRESH_ORANGE = 1;
        final int BAD_ORANGE = 2;

        final int GRID_X_WIDTH = grid[0].length;
        final int GRID_Y_WIDTH = grid.length;

//        System.out.println(GRID_X_WIDTH + "   " + GRID_Y_WIDTH);

        List<int[]> newBadOrangeList = new ArrayList<>();//新增的坏橘子的坐标
        List<int[]> tempOrangeList = new ArrayList<>();
        boolean hasNewBadOrange = false;
        int leftFreshOrange = 0;
        int days = 0;

        //第一次遍历，初始化数据
        for (int x = 0; x < GRID_X_WIDTH; x++) {
            for (int y = 0; y < GRID_Y_WIDTH; y++) {
                switch (grid[y][x]) {
                    case FRESH_ORANGE:
                        leftFreshOrange++;
                        break;
                    case BAD_ORANGE:
                        hasNewBadOrange = true;
                        newBadOrangeList.add(new int[]{y, x});
                }

            }

        }

        if (leftFreshOrange == 0) {
            return 0;
        }

        while (hasNewBadOrange) {
            days++;

            //开始感染新鲜橘子
            Iterator iterator = newBadOrangeList.iterator();
            while (iterator.hasNext()) {
                int[] badOrangeXY = (int[]) iterator.next();

                int temp_x = badOrangeXY[1];
                int temp_y = badOrangeXY[0];

                if (temp_x + 1 < GRID_X_WIDTH && grid[temp_y][temp_x + 1] == FRESH_ORANGE) {
                    grid[temp_y][temp_x + 1] = BAD_ORANGE;
                    leftFreshOrange--;
                    tempOrangeList.add(new int[]{temp_y, temp_x + 1});
                }

                if (temp_x - 1 < GRID_X_WIDTH && temp_x - 1 >= 0 && grid[temp_y][temp_x - 1] == FRESH_ORANGE) {
                    grid[temp_y][temp_x - 1] = BAD_ORANGE;
                    leftFreshOrange--;
                    tempOrangeList.add(new int[]{temp_y, temp_x - 1});
                }

                if (temp_y + 1 < GRID_Y_WIDTH && grid[temp_y + 1][temp_x] == FRESH_ORANGE) {
                    grid[temp_y + 1][temp_x] = BAD_ORANGE;
                    leftFreshOrange--;
                    tempOrangeList.add(new int[]{temp_y + 1, temp_x});
                }

                if (temp_y - 1 < GRID_Y_WIDTH && temp_y - 1 >= 0 && grid[temp_y - 1][temp_x] == FRESH_ORANGE) {
                    grid[temp_y - 1][temp_x] = BAD_ORANGE;
                    leftFreshOrange--;
                    tempOrangeList.add(new int[]{temp_y - 1, temp_x});
                }


            }

            hasNewBadOrange = tempOrangeList.size() > 0;

            newBadOrangeList = new ArrayList<>(tempOrangeList);
            tempOrangeList.clear();


//            for (int x = 0; x < GRID_X_WIDTH; x++) {
//                for (int y = 0; y < GRID_Y_WIDTH; y++) {
//                    System.out.print(grid[y][x] + "   ");
//                }
//
//                System.out.println("\n");
//            }
//
//            System.out.println("//=================================");
//            //=========================

        }

        //无坏橘子产生，且新鲜橘子数>1，说明无法都变成坏橘子
        //今天知道没有坏橘子产生时，说明昨天是才是结果
        return leftFreshOrange > 0 ? -1 : days - 1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }
}
