package processor;

import java.util.Scanner;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class MatrixApp {

//    private static final Logger logger = LoggerFactory.getLogger(MatrixApp.class);

    public void start() {
        final String[] menuItems = {"Add matrices", "Multiply matrix to a constant", "Multiply matrices"};
        final Scanner scanner = new Scanner(System.in);
        boolean loopContinue = true;

        while (loopContinue) {
            display(menuItems);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    multiplyWithConstant();
                    break;
                case 3:
                    multiply();
                    break;
                case 0:
                    loopContinue = false;
                    break;
                default:
//                    logger.debug("Wrong choice was entered: {} ", choice);
            }
        }

    }

    private void multiply() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of first matrix: > ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] firstMatrix = MatrixOperations.readMatrix(rows, columns);

        System.out.print("Enter size of second matrix: > ");
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] secondMatrix = MatrixOperations.readMatrix(rows, columns);

        double[][] result = MatrixOperations.multiply(firstMatrix, secondMatrix);
        System.out.println("The multiplication result is:");
        print(result);
    }

    private void multiplyWithConstant() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of matrix: > ");
        final int rows = scanner.nextInt();
        final int columns = scanner.nextInt();
        System.out.println("Enter matrix:");
        double[][] matrix = MatrixOperations.readMatrix(rows, columns);

        System.out.print("Enter constant for multiplication: > ");
        int constant = scanner.nextInt();

        matrix = MatrixOperations.multiplyWithConstant(matrix, constant);
        System.out.println("The constant multiplication result is:");
        print(matrix);

    }

    private void add() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of first matrix: > ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        System.out.println("Enter first matrix:");
        double[][] firstMatrix = MatrixOperations.readMatrix(rows, columns);

        System.out.print("Enter size of second matrix: > ");
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        System.out.println("Enter second matrix:");
        double[][] secondMatrix = MatrixOperations.readMatrix(rows, columns);

        double[][] result = MatrixOperations.add(firstMatrix, secondMatrix);
        System.out.println("The addition result is:");
        print(result);
    }

    private void display(String[] menuItems) {
        int number = 1;
        for (String item : menuItems) {
            System.out.printf("%d. %s\n", number++, item);
        }
        System.out.println("0. Exit");
        System.out.print("Your choice: > ");
    }

    public void print(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                double value = matrix[row][column];
                if ((long)value == value) {
                    System.out.print((long)value + " ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
