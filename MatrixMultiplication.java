package processor;

import java.awt.*;

public class MatrixMultiplication extends MatrixOperation {
    @Override
    public void execute() {
        userInput();
        try {
            System.out.println("The multiplication result is:");
            System.out.println(multiply());
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }

    private Matrix multiply() {
        int resultRows = matrix1.getRows();
        int resultColumns = matrix2.getColumns();
        Matrix resultMatrix = new Matrix(resultRows, resultColumns);
        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new MatrixException();
        }

        for (int i = 0; i < resultRows; i++) {
            for (int j = 0; j < resultColumns; j++) {
                Point resultPoint = new Point(i, j);
                for (int k = 0; k < matrix1.getColumns(); k++) {
                    Point matrix1Point = new Point(i, k);
                    Point matrix2Point = new Point(k, j);
                    resultMatrix.setValue(resultPoint, resultMatrix.getValue(resultPoint) + matrix1.getValue(matrix1Point) * matrix2.getValue(matrix2Point));
                }
            }

        }
        return resultMatrix;
    }

}
