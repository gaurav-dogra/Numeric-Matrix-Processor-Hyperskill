package processor;

import java.awt.*;

public class MatrixAddition extends MatrixOperation {
    @Override
    public void execute() {
        userInput();
        try {
            System.out.println("Addition result is :");
            System.out.println(sum());
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }

    private Matrix sum() throws MatrixException {
        if (!matrix1.isSameSize(matrix2)) {
            throw new MatrixException();
        }
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix matrixSum = new Matrix(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Point p = new Point(row, col);
                matrixSum.setValue(p, matrix1.getValue(p) + matrix2.getValue(p));
            }
        }
        return matrixSum;
    }


}
