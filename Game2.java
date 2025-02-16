public class Game2 {
    private enum Cell {
        X, O, EMPTY
    }
    private Cell[][] tabl;

    public Game2() {
        initializeGame();
    }

    private void initializeGame() {
        tabl = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabl[i][j] = Cell.EMPTY;
            }
        }
    }

    public String formatGame() {
        StringBuilder board = new StringBuilder();
        board.append("   1 2 3\n");
        board.append("  ------\n");
        char[] abc = {'a', 'b', 'c'};
        for (int i = 0; i < 3; i++) {
            board.append(abc[i]).append("| ");
            for (int j = 0; j < 3; j++) {
                board.append(tabl[i][j] == Cell.EMPTY ? "_" : tabl[i][j]).append(" ");
            }
            board.append("\n");
        }
        return board.toString();
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру крестики-нолики!");
        Game2 game = new Game2();
        System.out.println(game.formatGame());
    }
}
