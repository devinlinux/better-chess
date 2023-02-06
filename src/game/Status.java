package game;

public enum Status {

    IN_PROGRESS("", ContinueStatus.CONTINUE),
    CHECK("inCheck", ContinueStatus.WARN),
    WHITE_WIN("whiteWins", ContinueStatus.END),
    BLACK_WIN("blackWin", ContinueStatus.END),
    STALEMATE("stalemate", ContinueStatus.END),
    UNPRODUCTIVE_MOVES("unproductiveMoves", ContinueStatus.END),
    REPETITION("repetition", ContinueStatus.END),
    INSUFFICIENT_MATERIAL("insufficient", ContinueStatus.END);

    private enum ContinueStatus {
        CONTINUE,
        WARN,
        END
    }

    private final String TEXT;
    private final ContinueStatus STATUS;

    Status(final String TEXT, final ContinueStatus STATUS) {
        this.TEXT = TEXT;
        this.STATUS = STATUS;
    }

    public String getText() {
        return this.TEXT;
    }

    public boolean alertPlayer() {
        return this.STATUS != ContinueStatus.CONTINUE;
    }

    public boolean gameOver() {
        return this.STATUS == ContinueStatus.END;
    }
}