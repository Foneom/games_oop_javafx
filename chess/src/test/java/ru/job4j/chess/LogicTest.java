package ru.job4j.chess;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.ex.FigureNotFoundException;
import ru.job4j.chess.ex.ImpossibleMoveException;
import ru.job4j.chess.ex.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    /**
     * Тест на правильность движения слона по диагонали
     * Возвращает true при правильном движении
     *
     * @throws OccupiedWayException
     */
    @Test
    public void whenValidMoveBishop() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }
    /**
     * Тест возвращает false при попытке неправильного движения фигуры.
     *
     * @throws ImpossibleMoveException
     */
    @Test
    public void whenElephantInValidMoveThenFalse() throws OccupiedWayException, FigureNotFoundException {
        try {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.E6));
            logic.move(Cell.E6, Cell.D4);
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Невозможный ход"));
        }
    }
    /**
     * Тест на наличие фигуры в ячейке
     * Возвращает true при наличии
     *
     * @throws FigureNotFoundException
     */
    @Test
    public void whenFigureFoundThenTrue() throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1, Cell.H6), is(true));
    }
    /**
     * Тест на наличие фигуры в ячейке
     * @throws FigureNotFoundException кидает исключение при отсутствии
     */
    @Test
    public void whenFigureNotFoundThenTrue() throws OccupiedWayException, ImpossibleMoveException {
        try {
            Logic logic = new Logic();
            logic.add(new BishopBlack(Cell.E6));
            logic.move(Cell.D7, Cell.D4);
        } catch (FigureNotFoundException e) {
            assertThat(e.getMessage(), is("Фигура не найдена"));
        }
    }
    /**
     * Tecт проверки наличия другой фигуры на пути слона
     * кидает исключение при наличии
     * @throws OccupiedWayException
     * @throws ImpossibleMoveException
     * @throws FigureNotFoundException
     */
    @Test
    public void whenOccupiedWay() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
       try {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E6));
        logic.add(new PawnWhite(Cell.D5));
        logic.move(Cell.E6, Cell.B3);
       } catch (OccupiedWayException e) {
           assertThat(e.getMessage(), is("На пути другая фигура"));
       }
    }
}