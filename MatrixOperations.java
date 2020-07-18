package processor;

import java.util.Scanner;

public class MatrixOperations {

    public static double[][] multiplyWithConstant(double[][] matrix, double scalar) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = matrix[row][column] * scalar;
            }
        }
        return matrix;
    }

    public static double[][] add(double[][] firstMatrix, double[][] secondMatrix) {
        final int rows = firstMatrix.length;
        final int columns = firstMatrix[0].length;
        double[][] matrix = new double[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = firstMatrix[row][column] + secondMatrix[row][column];
            }
        }
        return matrix;
    }

    public static double[][] readMatrix(int rows, int columns) {
        final Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = scanner.nextDouble();
            }
        }
        return matrix;
    }


    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {
        int resultRows = firstMatrix.length;
        int resultColumns = secondMatrix[0].length;

        double[][] resultMatrix = new double[resultRows][resultColumns];

        if (isMultiplicationPossible(firstMatrix, secondMatrix)) {
            for (int i = 0; i < resultRows; i++) {
                for (int j = 0; j < resultColumns; j++) {
                    for (int k = 0; k < firstMatrix[0].length; k++) {
                        resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }

            }
        }
        return resultMatrix;
    }

    private static boolean isMultiplicationPossible(double[][] firstMatrix, double[][] secondMatrix) {
        int n1 = firstMatrix[0].length;
        int m2 = secondMatrix.length;
        return n1 == m2;
    }

}