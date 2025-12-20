import java.util.Arrays;
import java.util.List;

public class Sudoku {
    private int[][] sudokuOriginalTable = new int[9][9];
    private final int[][] sudokuTable = new int[9][9];

    public Sudoku(List<String> numbers) {
        for (String position : numbers) {
            var positionSplited = position.split(";");

            int row = Integer.parseInt(positionSplited[0]);
            int column = Integer.parseInt(positionSplited[1]);
            int number = Integer.parseInt(positionSplited[2]);

            this.sudokuTable[row][column] = number;
            this.sudokuOriginalTable[row][column] = number;
        }

    }

    private boolean verifySudokuPosition(int row, int column) {
        boolean isAvailablePosition = this.sudokuOriginalTable[row][column] == 0;
        return isAvailablePosition;
    }

    private boolean isNumberAvailableQuadrant(int row, int column, int number) {
        int blockRowNumber = row/3;
        int blockColNumber = column/3;

        int blockRowStart = blockRowNumber * 3;
        int blockColStart = blockColNumber * 3;

        boolean result = true;
        for (int i = blockRowStart; i < blockRowStart+3; i++) {
            for (int j = blockColStart; j < blockColStart+3; j++) {
                if(this.sudokuTable[i][j] == number) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isColumnAndRowAvailable(int row, int column, int number) {
        boolean result = true;

        for(int columnVerification = 0; columnVerification != 9; columnVerification++) {
            if(this.sudokuTable[row][columnVerification] == number) {
                result = false;
                break;
            }
        }

        for(int rowVerification = 0; rowVerification != 9; rowVerification++) {
            if(this.sudokuTable[rowVerification][column] == number) {
                result = false;
                break;
            }
        }

        return result;
    }

    public void showSudokuTable() {
        System.out.printf("    0  1  2   3  4  5   6  7  8\n");
        System.out.printf("  -------------------------------\n");

        int columnCountToFormat = 0;
        int rowCountToFormat = 0;
        for(int row = 0; row != 9; row++) {
            if(rowCountToFormat == 3) {
                rowCountToFormat = 0;
                System.out.printf("  |-----------------------------|\n");
            }
            rowCountToFormat += 1;

            for(int column = 0; column != 9; column++) {
                if(column == 0) {System.out.printf("%s |", row);}
                System.out.printf(" %s ", sudokuTable[row][column]);
                columnCountToFormat += 1;

                if(columnCountToFormat == 3) {
                    System.out.print("|");
                    columnCountToFormat = 0;
                }
            }
            System.out.println();
        }
        System.out.printf("  -------------------------------\n");
    }

    public void insertNumberInPosition(String userRow, String userColumn, String userNumber) {
        try {
            int row = Integer.parseInt(userRow);
            int column = Integer.parseInt(userColumn);
            int number = Integer.parseInt(userNumber);

            if(!this.isNumberAvailableQuadrant(row, column, number) || !this.isColumnAndRowAvailable(row, column, number)) {
                System.out.println(">> Posição indisponível, selecione outra posição. <<");
            } else if(!this.verifySudokuPosition(row, column)) {
                System.out.println(">> Já existe um número ocupando esta posição. <<");
            } else {
                this.sudokuTable[row][column] = number;
                this.showSudokuTable();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
