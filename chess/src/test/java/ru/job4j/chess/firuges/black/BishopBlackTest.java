package ru.job4j.chess.firuges.black;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BishopBlackTest {
    /**
     * Тест занятия объектом ячейки при создании
     */
    @Test
    public void whenPosition() {
        BishopBlack input = new BishopBlack(Cell.A1);
        Cell cell = input.position();
        assertThat(cell, is(Cell.A1));
    }
    /**
     * Тест правильной позиции копируемого объекта
     */
    @Test
    public void whenCopy() {
        BishopBlack input = new BishopBlack(Cell.C1);
        Figure result = input.copy(Cell.C1);
        assertThat(result.position(), is(Cell.C1));
    }
    /**
     * Тест движения по диагонали, при непральном движении кидает исключение
     * при правильном выдает крайнюю точку массива точек движения
     */
    @Test
    public void whenDiagonalWay() {
        try {
            BishopBlack input = new BishopBlack(Cell.G2);
            Cell []result = input.way(Cell.G2, Cell.E4);
            assertThat(result, is(new Cell[]{Cell.G2, Cell.F3, Cell.E4}));
        } catch (IllegalStateException e) {
            assertThat(e.getMessage(), CoreMatchers.is(String.format("Could not move by diagonal from %s to %s", Cell.G2, Cell.E4)));
        }
    }
}
