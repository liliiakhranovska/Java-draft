package Board.fileManagement;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static javafx.application.Application.launch;

public class Test6 {
    public int[][] north;
    public int[][] south;
    public int[][] west;
    public int[][] east;
    public int[][] north_east;
    public int[][] south_east;
    public int[][] south_west;
    public int[][] north_west;


    public ArrayList<Integer[]> north(Integer currentX, Integer currentY){
        ArrayList<Integer[]> northCells = new ArrayList<Integer[]>();
        for (Integer y = currentY+1; y < 8; y++){
            northCells.add(new Integer[]{currentX, y});
        }
        return northCells;
    }

    public void printNorth (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> south(Integer currentX, Integer currentY){
        ArrayList<Integer[]> southCells = new ArrayList<>();
        for (Integer y = currentY-1; y > -1; y = y-1){
            southCells.add(new Integer[]{currentX, y});
        }
        return southCells;
    }

    public void printSouth (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> east(Integer currentX, Integer currentY){
        ArrayList<Integer[]> eastCells = new ArrayList<>();
        for (Integer x = currentX+1; x < 8; x++){
            eastCells.add(new Integer[]{x, currentY});
        }
        return eastCells;
    }

    public void printEast (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> west(Integer currentX, Integer currentY){
        ArrayList<Integer[]> westCells = new ArrayList<>();
        for (Integer x = currentX-1; x > -1; x = x-1){
            westCells.add(new Integer[]{x, currentY});
        }
        return westCells;
    }

    public void printWest (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> northEast(Integer currentX, Integer currentY){
        ArrayList<Integer[]> westCells = new ArrayList<>();
        for (Integer x = currentX+1; x < 8; x++) {
            for (Integer y = currentY + 1; y < 8; y++) {
                if (currentX-currentY == x-y) {
                    westCells.add(new Integer[]{x, y});
                }
            }
        }
        return westCells;
    }

    public void printNorthEast (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> southEast(Integer currentX, Integer currentY){
        ArrayList<Integer[]> southEastCells = new ArrayList<>();
        for (Integer x = currentX+1; x < 8; x++) {
            for (Integer y = currentY - 1; y > -1; y=y-1) {
                if (currentX+currentY == x+y) {
                    southEastCells.add(new Integer[]{x, y});
                }
            }
        }
        return southEastCells;
    }

    public void printSouthEast (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> southWest(Integer currentX, Integer currentY){
        ArrayList<Integer[]> southWestCells = new ArrayList<>();
        for (Integer x = currentX-1; x > -1; x=x-1) {
            for (Integer y = currentY - 1; y > -1; y=y-1) {
                if (currentX-currentY == x-y) {
                    southWestCells.add(new Integer[]{x, y});
                }
            }
        }
        return southWestCells;
    }

    public void printSouthWest (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public ArrayList<Integer[]> northWest(Integer currentX, Integer currentY){
        ArrayList<Integer[]> northWestCells = new ArrayList<>();
        for (Integer x = currentX-1; x > -1; x=x-1) {
            for (Integer y = currentY + 1; y < 8; y++) {
                if (currentX+currentY == x+y) {
                    northWestCells.add(new Integer[]{x, y});
                }
            }
        }
        return northWestCells;
    }

    public void printNorthWest (ArrayList<Integer[]> list){
//        System.out.println(Arrays.toString(list.get(0)));
        for (Integer[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }

    public static void main(String[] args){
        Test6 test = new Test6();
        ArrayList<Integer[]> arr = test.northWest(3,2);
        test.printNorthWest(arr);
    }

}
