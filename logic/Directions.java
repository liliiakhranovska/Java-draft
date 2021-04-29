package Board.logic;

import java.util.ArrayList;

public class Directions {

    public ArrayList<Integer[]> north(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> northCells = new ArrayList<>();
        for (Integer y = currentY + 1; y < 8; y++) {
            northCells.add(new Integer[]{currentX, y});
        }
        return northCells;
    }

    public ArrayList<Integer[]> south(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> southCells = new ArrayList<>();
        for (Integer y = currentY - 1; y > -1; y = y - 1) {
            southCells.add(new Integer[]{currentX, y});
        }
        return southCells;
    }

    public ArrayList<Integer[]> east(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> eastCells = new ArrayList<>();
        for (Integer x = currentX + 1; x < 8; x++) {
            eastCells.add(new Integer[]{x, currentY});
        }
        return eastCells;
    }

    public ArrayList<Integer[]> west(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> westCells = new ArrayList<>();
        for (Integer x = currentX - 1; x > -1; x = x - 1) {
            westCells.add(new Integer[]{x, currentY});
        }
        return westCells;
    }

    public ArrayList<Integer[]> northEast(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> northEastCells = new ArrayList<>();
        for (Integer x = currentX + 1; x < 8; x++) {
            for (Integer y = currentY + 1; y < 8; y++) {
                if (currentX - currentY == x - y) {
                    northEastCells.add(new Integer[]{x, y});
                }
            }
        }
        return northEastCells;
    }

    public ArrayList<Integer[]> southEast(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> southEastCells = new ArrayList<>();
        for (Integer x = currentX + 1; x < 8; x++) {
            for (Integer y = currentY - 1; y > -1; y = y - 1) {
                if (currentX + currentY == x + y) {
                    southEastCells.add(new Integer[]{x, y});
                }
            }
        }
        return southEastCells;
    }

    public ArrayList<Integer[]> southWest(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> southWestCells = new ArrayList<>();
        for (Integer x = currentX - 1; x > -1; x = x - 1) {
            for (Integer y = currentY - 1; y > -1; y = y - 1) {
                if (currentX - currentY == x - y) {
                    southWestCells.add(new Integer[]{x, y});
                }
            }
        }
        return southWestCells;
    }

    public ArrayList<Integer[]> northWest(Integer currentX, Integer currentY) {
        ArrayList<Integer[]> northWestCells = new ArrayList<>();
        for (Integer x = currentX - 1; x > -1; x = x - 1) {
            for (Integer y = currentY + 1; y < 8; y++) {
                if (currentX + currentY == x + y) {
                    northWestCells.add(new Integer[]{x, y});
                }
            }
        }
        return northWestCells;
    }
}