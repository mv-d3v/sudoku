public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();

        sudoku.showSudokuTable();
        sudoku.isColumnAndRowAvailable(0, 3, 10);
    }
}