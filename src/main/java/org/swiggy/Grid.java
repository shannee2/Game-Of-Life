package org.swiggy;

import java.util.List;

public class Grid {
    public Grid(int rows, int cols) {
        if (rows <= 0 ||cols <= 0) {
            throw new org.swiggy.exceptions.InvalidGridSizeException();
        }
    }
}
