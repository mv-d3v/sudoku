import java.util.List;

public class Sudoku {
    private final int[][] sudokuTable = new int[9][9];

    public Sudoku(List<String> numbers) {
        for (String position : numbers) {
            var positionSplited = position.split(";");

            int row = Integer.parseInt(positionSplited[0]);
            int column = Integer.parseInt(positionSplited[1]);
            int number = Integer.parseInt(positionSplited[2]);

            this.sudokuTable[row][column] = number;
        }
    }

    private boolean verifySudokuPosition(int row, int column) {
        boolean isAvailablePosition = this.sudokuTable[row][column] == 0;
        return isAvailablePosition;
    }

    private boolean verifyIfNumberAvailableInArrayRange(int row, int column, int number) {
        boolean result = true;
        for (int i = 0; i != row+1; i++) {
            for (int j = 0; j != column+1; j++) {
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
        System.out.printf("    0 1 2 3 4 5 6 7 8\n");
        System.out.println();
        for(int row = 0; row != 9; row++) {
            for(int column = 0; column != 9; column++) {
                if(column == 0) {System.out.printf("%s   ", row);}
                System.out.printf("%s ", sudokuTable[row][column]);
            }
            System.out.println();
        }
    }

    public void insertNumberInPosition(String userRow, String userColumn, String userNumber) {
        try {
            int row = Integer.parseInt(userRow);
            int column = Integer.parseInt(userColumn);
            int number = Integer.parseInt(userNumber);

            if(!this.verifyIfNumberAvailableInArrayRange(row, column, number)) {
                System.out.println(">> Posição não disponível, selecione outra posição. <<");
            } else if(!this.isColumnAndRowAvailable(row, column, number)) {
                System.out.println(">> Número já está presente no quadrante selecionado. <<");
            } else if(!this.verifySudokuPosition(row, column)) {
                System.out.println(">> Número já está presente na linha ou coluna. <<");
            } else {
                this.sudokuTable[row][column] = number;
                this.showSudokuTable();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
