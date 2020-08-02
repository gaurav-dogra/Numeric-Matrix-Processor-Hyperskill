package processor;

import java.awt.*;

public class MatrixInverse extends MatrixOperation {
    @Override
    public void execute() {
        userInput();
        try {
            System.out.println(inverse());
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }

    private Matrix inverse() throws MatrixException {
        MatrixDeterminant md = new MatrixDeterminant();
        double determinant = md.determinant(matrix1);
        if (determinant == 0) {
            throw new MatrixException();
        }
        int signControl;
        Matrix cofactosMatrix = new Matrix(matrix1.getRows(), matrix1.getColumns());
        //1. Getting matrix of cofactors
        for (int row = 0; row < cofactosMatrix.getRows(); row++) {
            if (row % 2 == 0) {
                signControl = 1;
            } else {
                signControl = -1;
            }
            for (int column = 0; column < cofactosMatrix.getColumns(); column++) {
                Point p = new Point(row, column);
                Matrix coFactor = md.getCofactor(matrix1, row, column);
//                System.out.println(coFactor);
                double coFactorDet = md.determinant(coFactor);
                coFactorDet *= signControl;
                signControl *= -1;
                cofactosMatrix.setValue(p, coFactorDet);
//                System.out.println(coFactorDet);
            }
        }

        // 2. transpose the result
        MatrixTranspose mt = new MatrixTranspose();
        mt.matrix1 = cofactosMatrix;
        Matrix transposedMatrix = mt.transposeMainDiagonal();

        // 3. multiply the result by 1/det|A|
        MatrixMultiplicationToConstant mmC = new MatrixMultiplicationToConstant();
        mmC.matrix1 = transposedMatrix;
        mmC.setNumber(1/determinant);
        return mmC.multiplyByNumber();

    }

    @Override
    public void userInput() {
        inputMatrix1();
    }
}
