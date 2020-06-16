package ru.job4j.chess.ex;

public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
