package org.adurlea;

public enum Coordinate {
    N("W", "E", true, true),
    E("N", "S", true, false),
    S("E", "W", false, true),
    W("S", "N", false, false);

    private final String leftCoord;
    private final String rightCoord;
    private final boolean add;
    private final boolean horiz;

    Coordinate(final String leftCoord,
               final String rightCoord,
               final boolean add,
               final boolean horiz) {
        this.leftCoord = leftCoord;
        this.rightCoord = rightCoord;
        this.add = add;
        this.horiz = horiz;
    }

    public String getLeftCoord() {
        return leftCoord;
    }

    public String getRightCoord() {
        return rightCoord;
    }

    public boolean isAdd() {
        return add;
    }

    public boolean isHoriz() {
        return horiz;
    }
}