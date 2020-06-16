package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
                return new Cell[]{dest};
        }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
