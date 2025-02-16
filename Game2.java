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

    public boolean isMoveAvailable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabl[i][j] == Cell.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public Cell checkWin() {
        // проверка строк
        for (int i = 0; i < 3; i++) {
            if (tabl[i][0] != Cell.EMPTY && tabl[i][0] == tabl[i][1] && tabl[i][1] == tabl[i][2]) {
                return tabl[i][0];
            }
        }

        // столбцы
        for (int j = 0; j < 3; j++) {
            if (tabl[0][j] != Cell.EMPTY && tabl[0][j] == tabl[1][j] && tabl[1][j] == tabl[2][j]) {
                return tabl[0][j];
            }
        }

        //диагонали
        if (tabl[0][0] != Cell.EMPTY && tabl[0][0] == tabl[1][1] && tabl[1][1] == tabl[2][2]) {
            return tabl[0][0];
        }

        if (tabl[0][2] != Cell.EMPTY && tabl[0][2] == tabl[1][1] && tabl[1][1] == tabl[2][0]) {
            return tabl[0][2];
        }

        return Cell.EMPTY;
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру крестики-нолики!");
        Game2 game = new Game2();
        System.out.println(game.formatGame());
    }
}
