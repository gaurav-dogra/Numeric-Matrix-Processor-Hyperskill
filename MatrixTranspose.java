package processor;

import java.awt.*;

public class MatrixTranspose extends MatrixOperation {
    int selection;

    @Override
    public void execute() {
        userInput();
        try {
            System.out.println("The result is:");
            System.out.println(transpose());
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }

    private Matrix transpose() {
        switch (selection) {
            case 1:
                return transposeMainDiagonal();
            case 2:
                return transposeSideDiagonal();
            case 3:
                return transposeVerticalLine();
            case 4:
                return transposeHorizontalLine();
            default:
                throw new MatrixException();
        }
    }

    @Override
    public void userInput() {
        printOptions();
        selection = scanner.nextInt();
        inputMatrix1();
    }

    private void printOptions() {
        String text = "\n1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: > ";
        System.out.print(text);
    }

    protected Matrix transposeMainDiagonal() {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix resultMatrix = new Matrix(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Point resultMatrixPoint = new Point(row, column);
                Point currentMatrixPoint = new Point(column, row);
                resultMatrix.setValue(resultMatrixPoint, matrix1.getValue(currentMatrixPoint));
            }
        }
        return resultMatrix;
    }

    private Matrix transposeSideDiagonal() {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix resultMatrix = new Matrix(rows, columns);

        for (int i = rows - 1, k = 0; i >= 0; i--, k++) {
            for (int j = columns - 1, l = 0; j >= 0; j--, l++) {
                Point resultPoint = new Point(k, l);
                Point matrix1Point = new Point(j, i);
                resultMatrix.setValue(resultPoint, matrix1.getValue(matrix1Point));
            }
        }
        return resultMatrix;
    }

    private Matrix transposeVerticalLine() {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix resultMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1, k = 0; j >= 0; j--, k++) {
                Point resultPoint = new Point(i, k);
                Point matrix1Point = new Point(i, j);
                resultMatrix.setValue(resultPoint, matrix1.getValue(matrix1Point));
            }
        }
        return resultMatrix;
    }

    private Matrix transposeHorizontalLine() {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix resultMatrix = new Matrix(rows, columns);

        for (int i = rows - 1, k = 0; i >= 0; i--, k++) {
            for (int j = 0; j < columns; j++) {
                Point resultPoint = new Point(k, j);
                Point matrix1Point = new Point(i, j);
                resultMatrix.setValue(resultPoint, matrix1.getValue(matrix1Point));
            }
        }
        return resultMatrix;
    }

}
