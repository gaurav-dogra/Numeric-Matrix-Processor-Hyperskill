package processor;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Matrix {
    private final int rows;
    private final int columns;
    private final double[][] matrix;

    private final Scanner scanner = new Scanner(System.in);

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    public void userInput() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = scanner.nextDouble();
            }
        }
    }

    public boolean isSameSize(Matrix matrix) {
        if (matrix.getColumns() != this.getColumns()) {
            return false;
        }

        return matrix.getRows() == this.getRows();
    }

    public double getValue(Point p) {
        return matrix[p.x][p.y];
    }

    public void setValue(Point p, double value) {
        if (value == (long) value) {
            matrix[p.x][p.y] = (long) value;
        } else {
            matrix[p.x][p.y] = value;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                double value = matrix[row][col];
                if (value == (long)value) {
                    sb.append((long)value).append(".0");
                } else {
                    DecimalFormat df = new DecimalFormat("0.######");
                    //df.setRoundingMode(RoundingMode.DOWN);
                    value = Double.parseDouble(df.format(value));
                    sb.append(value);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        if (getRows() != matrix1.getRows()) return false;
        if (getColumns() != matrix1.getColumns()) return false;
        return Arrays.deepEquals(matrix, matrix1.matrix);
    }
}
