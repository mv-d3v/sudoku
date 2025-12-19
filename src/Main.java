import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> defaultPositions = new ArrayList<>(List.of(
                "0;0;6", "1;0;5", "2;0;1", "0;3;8", "0;6;3", "1;4;2", "2;3;4", "2;5;3", "2;7;5", "2;8;6", "3;1;6",
                "3;2;1", "3;6;5", "3;7;9", "3;8;8", "4;0;9", "4;2;4", "4;3;6", "4;5;5", "4;8;2", "5;0;8", "5;1;3", "5;2;5",
                "5;5;9", "5;6;7", "6;0;3", "6;2;9", "6;3;5", "6;5;8", "6;6;4", "7;0;7", "7;1;8", "7;4;4", "7;5;2", "7;6;9",
                "7;7;1", "8;2;2", "8;7;8"
        ));

        Sudoku sudoku = new Sudoku(defaultPositions);
        Scanner keyboard = new Scanner(System.in);

        sudoku.showSudokuTable();

        boolean isContinued = true;
        while(isContinued) {
            System.out.print(" row;column;number : ");
            var position = keyboard.nextLine();
            var rowColumnNumber = Arrays.stream(position.split(";")).toList();
            sudoku.insertNumberInPosition(rowColumnNumber.get(0), rowColumnNumber.get(1), rowColumnNumber.get(2));
        }
    }
}