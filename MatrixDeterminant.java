package processor;

import java.awt.*;

public class MatrixDeterminant extends MatrixOperation {
    @Override
    public void execute() {
        userInput();
        try {
            System.out.println("The result is:");
            System.out.println(determinant(matrix1));
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }

    protected double determinant(Matrix matrix) {
        double determinant = 0;
        int signControl;
        int length = matrix.getRows();
        if (length == 2) {
            Point p00 = new Point(0, 0);
            Point p01 = new Point(0, 1);
            Point p10 = new Point(1, 0);
            Point p11 = new Point(1, 1);
            return matrix.getValue(p00) * matrix.getValue(p11) - matrix.getValue(p01) * matrix.getValue(p10);
        } else {
            for (int i = 0; i < 1; i++) {
                signControl = 1;
                for (int j = 0; j < length; j++) {
                    Matrix cofactor = getCofactor(matrix, i, j);
                    determinant += signControl * matrix.getValue(new Point(i, j)) * determinant(cofactor);
                    signControl = signControl * -1;
                }
            }
        }
        return determinant;
    }

    protected Matrix getCofactor(Matrix matrix, int row, int column) {
        int length = matrix.getRows();
        int resultMatrixLength = length - 1;
        double[] array = new double[resultMatrixLength * resultMatrixLength];
        int index = 0;
        Matrix resultMatrix = new Matrix(resultMatrixLength, resultMatrixLength);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == row || j == column) {
                    continue;
                }
                array[index] = matrix.getValue(new Point(i, j));
                index++;
            }
        }

        index = 0;
        for (int i = 0; i < resultMatrixLength; i++) {
            for (int j = 0; j < resultMatrixLength; j++) {
                resultMatrix.setValue(new Point(i, j), array[index]);
                index++;
            }
        }
        return resultMatrix;
    }

    @Override
    public void userInput() {
        inputMatrix1();
    }
}
