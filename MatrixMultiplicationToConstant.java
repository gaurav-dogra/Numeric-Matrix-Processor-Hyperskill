package processor;

import java.awt.*;

public class MatrixMultiplicationToConstant extends MatrixOperation {
    protected double number;

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public void execute() {
        userInput();
        System.out.println("Multiplication to constant result is :");
        System.out.println(multiplyByNumber());
    }

    @Override
    public void userInput() {
        inputMatrix1();
        System.out.println("Enter number:");
        number = scanner.nextDouble();
    }

    protected Matrix multiplyByNumber() {
        int rows = matrix1.getRows();
        int columns = matrix1.getColumns();
        Matrix resultMatrix = new Matrix(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Point p = new Point(row, column);
                resultMatrix.setValue(p, matrix1.getValue(p) * number);
            }
        }
        return resultMatrix;
    }
}
