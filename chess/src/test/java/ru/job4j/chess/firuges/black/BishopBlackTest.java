package ru.job4j.chess.firuges.black;

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
     * Тест движения по диагонали, при правильном движении выдает массив точек движения
     */
    @Test
    public void whenDiagonalWay() {
            BishopBlack input = new BishopBlack(Cell.G2);
            Cell []result = input.way(Cell.G2, Cell.E4);
            assertThat(result, is(new Cell[]{Cell.F3, Cell.E4}));
    }
    /**
     * Тест движения по диагонали, при непральном движении кидает исключение
     */
    @Test(expected = IllegalStateException.class)
    public void whenWrongDiagonalWay() {
        BishopBlack input = new BishopBlack(Cell.G2);
        input.way(Cell.G2, Cell.F2);
    }
}
