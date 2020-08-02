package processor;


import java.util.Scanner;

public class ConsoleOptions {
    private final Scanner scanner = new Scanner(System.in);
    private final String OPTION_TEXT = "1. Add matrices\n" +
            "2. Multiply matrix to a constant\n" +
            "3. Multiply matrices\n" +
            "4. Transpose matrix\n" +
            "5. Calculate a determinant\n" +
            "6. Inverse matrix\n" +
            "0. Exit\n" +
            "Your choice: > ";

    public void start() {
        System.out.print(OPTION_TEXT);
        while (userInput()) {
            System.out.print(OPTION_TEXT);
        }
    }

    private boolean userInput() {
        int selected = scanner.nextInt();
        if (selected == 0) {
            return false;
        }
        try {
            MatrixOperation operation = MatrixOperation.create(selected);
            operation.execute();
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
