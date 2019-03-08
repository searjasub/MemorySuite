package edu.neumont.csc150.model;

import java.io.Serializable;
import java.util.Objects;

public class Coordinate implements Serializable {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.setRow(row);
        this.setCol(col);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        if (row < 0 || row > 11) {
            System.out.println("invalid row " + row);
        }

        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        if (col < 0 || col > 11) {
            System.out.println("invalid column " + col);
        }

        this.col = col;
    }

    public String toString() {
        return "(" + this.row + "," + this.col + ")";
    }

    public boolean equals(Object o) {
        Coordinate other = (Coordinate)o;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }

    public int hashCode() {
        return Objects.hash(this.row, this.col);
    }
}
