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

        Sudoku sudoku = new Sudoku();
        Scanner keyboard = new Scanner(System.in);

        boolean isContinued = true;
        while(isContinued) {
            System.out.println("1. INICIAR NOVO JOGO");
            System.out.println("2. INSERIR NÚMERO");
            System.out.println("3. REMOVER NÚMERO");
            System.out.println("4. CHECAR JOGO");
            System.out.println("5. CHECAR STATUS DO JOGO");
            System.out.println("6. LIMPAR JOGO");
            System.out.println("7. FINALIZAR");
            System.out.println("8. SAIR");
            int option = keyboard.nextInt();

            switch (option) {
                case 8 -> isContinued = false;
                case 1 -> startNewGame(sudoku, defaultPositions);
                case 2 -> insertANewNumber(sudoku);
                case 3 -> removeNumber(sudoku);
                case 4 -> checkGame(sudoku);
                case 5 -> checkGameStatus(sudoku);
                case 6 -> clear(sudoku);
                case 7 -> finishGame(sudoku);
            }
        }
    }

    public static void startNewGame(Sudoku sudoku, List<String> defaultPositions) {
        sudoku.startNewGame(defaultPositions);
    }

    public static void insertANewNumber(Sudoku sudoku) {
        if(sudoku.isGameStarted()) {
            Scanner keyboard = new Scanner(System.in);

            System.out.print("linha;coluna;numero(1-9) : ");
            var position = keyboard.nextLine();

            var rowColumnNumber = Arrays.stream(position.split(";")).toList();
            sudoku.insertNumberInPosition(rowColumnNumber.get(0), rowColumnNumber.get(1), rowColumnNumber.get(2));
        } else {
            System.out.println("Inicie o jogo primeiro.");
        }
    }
    public static void removeNumber(Sudoku sudoku) {
        if(sudoku.isGameStarted()) {
            Scanner keyboard = new Scanner(System.in);

            System.out.print("linha;coluna : ");
            var position = keyboard.nextLine();

            var rowColumnNumber = Arrays.stream(position.split(";")).toList();
            sudoku.removeNumber(rowColumnNumber.get(0), rowColumnNumber.get(1));
        } else {
            System.out.println("Inicie o jogo primeiro.");
        }
    }
    public static void checkGame(Sudoku sudoku) {
        if(sudoku.isGameStarted()) {
            sudoku.showSudokuTable();
        } else {
            System.out.println("Inicie o jogo primeiro.");
        }
    }
    public static void checkGameStatus(Sudoku sudoku) {
        GameStatusEnum gameStatus = sudoku.checkGameStatus();
        switch (gameStatus) {
            case NOTSTARTED -> System.out.println("Jogo não foi iniciado ainda");
            case INCOMPLETE -> System.out.println("Jogo incompleto");
            case COMPLETE -> System.out.println("Jogo completo");
        }
    }
    public static void clear(Sudoku sudoku) {
        if(sudoku.isGameStarted()) {
            sudoku.clearGame();
        } else {
            System.out.println("Inicie o jogo primeiro.");
        }
    }
    public static void finishGame(Sudoku sudoku) {
        if(sudoku.isGameStarted()) {
            if(sudoku.isGameFinished()) {
                System.out.println("VOCÊ FINALIZOU O JOGO, PARABÉNS S2!");
            } else {
                System.out.println("Jogo incompleto.");
            }
        } else {
            System.out.println("Inicie o jogo primeiro.");
        }
    }
}