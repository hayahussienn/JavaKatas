package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixRotateTest {

    @Test
    public void testRotateMatrix_1x1() {
        int[][] matrix = {
                {1}
        };

        int[][] expected = {
                {1}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix, "A 1x1 matrix should remain the same after rotation.");
    }
    @Test
    public void testRotateMatrix_2x2() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {3, 1},
                {4, 2}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix, "The 2x2 matrix should be rotated 90 degrees clockwise.");
    }

    @Test
    public void testRotateMatrix_3x3() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix, "The matrix should be rotated 90 degrees clockwise.");
    }
    @Test
    public void testRotateMatrix_LargerMatrix() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] expected = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix, "The larger matrix should be rotated 90 degrees clockwise.");
    }

    @Test
    public void testRotateMatrix_EmptyMatrix() {
        int[][] matrix = new int[0][0];

        // The matrix is empty, so the result should still be an empty matrix
        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(new int[0][0], matrix, "The empty matrix should remain empty after rotation.");
    }


}
