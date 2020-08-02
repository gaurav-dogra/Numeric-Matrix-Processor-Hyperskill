package processor;

import java.util.Scanner;

public abstract class MatrixOperation {
    protected Matrix matrix1;
    protected Matrix matrix2;

    protected final Scanner scanner = new Scanner(System.in);

    public abstract void execute();

    public void userInput() {
        inputMatrix1();
        inputMatrix2();
    }

    protected void inputMatrix1() {
        System.out.print("Enter size of first matrix: > ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        matrix1 = new Matrix(rows, columns);
        System.out.println("Enter first Matrix:");
        matrix1.userInput();
    }

    protected void inputMatrix2() {
        System.out.print("Enter size of second matrix: > ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        matrix2 = new Matrix(rows, columns);
        System.out.println("Enter second Matrix:");
        matrix2.userInput();
    }

    public static MatrixOperation create(int selectecd) {
        switch (selectecd) {
            case 1:
                return new MatrixAddition();
            case 2:
                return new MatrixMultiplicationToConstant();
            case 3:
                return new MatrixMultiplication();
            case 4:
                return new MatrixTranspose();
            case 5:
                return new MatrixDeterminant();
            case 6:
                return new MatrixInverse();
            default:
                throw new MatrixException();
        }
    }
}
