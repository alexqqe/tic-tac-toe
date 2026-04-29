package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testIsMoveAvailable() {
        Main game = new Main(); // Create an instance of Main

        game.field = new Cell[][]{
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
        };

        assertTrue(game.isMoveAvailable(), "Expected move to be available");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.field[i][j] = Cell.X;
            }
        }

        assertFalse(game.isMoveAvailable(), "Expected no moves to be available");
    }

    @Test
    void testCheckWin() {
        Main game = new Main();

        game.field = new Cell[][]{
                {Cell.X, Cell.X, Cell.X},
                {Cell.EMPTY, Cell.O, Cell.EMPTY},
                {Cell.O, Cell.EMPTY, Cell.O}
        };

        assertEquals(Cell.X, game.checkWin(), "Player X should have won");

        game.field[0][0] = Cell.O;
        game.field[0][1] = Cell.O;
        game.field[0][2] = Cell.O;

        assertEquals(Cell.O, game.checkWin(), "Player O should have won");

        game.field[0][0] = Cell.EMPTY;
        game.field[0][1] = Cell.EMPTY;
        game.field[0][2] = Cell.EMPTY;

        assertEquals(Cell.EMPTY, game.checkWin(), "No player should have won");
    }

    @Test
    void testMove() {
        Main game = new Main();

        game.field = new Cell[][]{
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
        };

        assertDoesNotThrow(() -> game.move(0, 0), "Move should be successful");
        assertThrows(IllegalArgumentException.class, () -> game.move(0, 0), "Move should fail because the cell is occupied");
    }
}
