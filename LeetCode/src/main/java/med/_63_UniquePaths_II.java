package med;

import static org.testng.Assert.assertEquals;

/**
 * Created by udaythota on 5/19/19.
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some OBSTACLES are added to the grids. How many unique paths would there be?
 * </p>
 */
public class _63_UniquePaths_II {

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        // fill the first row
        for (int i = 1; i < rows; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
        }

        // fill the first column
        for (int j = 1; j < columns; j++) {
            obstacleGrid[0][j] = obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1 ? 1 : 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];  // compute the values (starting 1st row and 1st column) only when the grid value is 0
                } else {
                    obstacleGrid[i][j] = 0;   // when the grid value is 1, reset the grid value to 0 (meaning no paths exists through that grid cell)
                }
            }
        }
        return obstacleGrid[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        assertEquals(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), 2);
    }
}
