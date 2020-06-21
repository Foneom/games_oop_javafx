package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.ex.FigureNotFoundException;
import ru.job4j.chess.ex.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    /**
     * Тест на наличие фигуры в ячейке
     * Возвращает true при наличии
     *
     * @throws FigureNotFoundException
     */
    @Test
    public void whenFigureFoundThenTrue() throws FigureNotFoundException, OccupiedWayException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1, Cell.D2), is(true));
    }
    /**
     * Тест на наличие фигуры в ячейке
     * @throws FigureNotFoundException кидает исключение при отсутствии
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundThenTrue() throws FigureNotFoundException, OccupiedWayException {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.E6));
            logic.move(Cell.D7, Cell.D4);
    }
    /**
     * Tecт проверки наличия другой фигуры на пути слона
     * кидает исключение при наличии
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedWay() throws OccupiedWayException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E6));
        logic.add(new PawnWhite(Cell.D5));
        logic.move(Cell.E6, Cell.B3);
    }
}