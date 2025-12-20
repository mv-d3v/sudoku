import java.util.Arrays;
import java.util.List;

public class Sudoku {
    private int[][] sudokuOriginalTable = new int[9][9];
    private int[][] sudokuTable = new int[9][9];
    private boolean isGameStarted;

    public Sudoku() {}

    private boolean verifySudokuPosition(int row, int column) {
        boolean isAvailablePosition = this.sudokuOriginalTable[row][column] == 0;
        return isAvailablePosition;
    }

    private boolean haveAvailablePositions() {
        boolean operationResult = false;

        for (int row = 0; row != 9; row++) {
            for (int column = 0; column != 9; column++) {
                if(this.sudokuTable[row][column] == 0) {
                    operationResult = true;
                    break;
                }
            }
        }

        return operationResult;
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

    public void startNewGame (List<String> numbers) {
        for (String position : numbers) {
            var positionSplited = position.split(";");

            int row = Integer.parseInt(positionSplited[0]);
            int column = Integer.parseInt(positionSplited[1]);
            int number = Integer.parseInt(positionSplited[2]);

            this.sudokuTable[row][column] = number;
            this.sudokuOriginalTable[row][column] = number;
        }

        this.isGameStarted = true;
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
                int number = sudokuTable[row][column];

                if(column == 0) {
                    System.out.printf("%s |", row);
                }

                if(number == 0) {
                    System.out.printf(" %s ", " ");
                } else {
                    System.out.printf(" %s ", number);
                }

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
                System.out.println(">> Você não pode alterar esse número. <<");
            } else {
                this.sudokuTable[row][column] = number;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean removeNumber(String userRow, String userColumn) {
        boolean operationResult = false;

        try {
            int row = Integer.parseInt(userRow);
            int column = Integer.parseInt(userColumn);

            if(!this.verifySudokuPosition(row, column)) {
                System.out.println(">> Esse número não pode ser removido. <<");
            } else {
                this.sudokuTable[row][column] = 0;
                operationResult = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return operationResult;
    }

    public GameStatusEnum checkGameStatus() {
        GameStatusEnum gameStatus = GameStatusEnum.INCOMPLETE;

        if(!this.isGameStarted()) {
            gameStatus = GameStatusEnum.NOTSTARTED;
        } else if(!this.haveAvailablePositions()) {
            gameStatus = GameStatusEnum.COMPLETE;
        }

        return gameStatus;
    }


    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void clearGame() {
        this.sudokuTable = this.sudokuOriginalTable.clone();
    }

    public boolean isGameFinished() {
        boolean operationResult = false;

        if (!this.haveAvailablePositions()) {
            operationResult = true;
        }

        return operationResult;
    }
}
