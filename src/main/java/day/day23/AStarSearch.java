package day.day23;

import java.util.ArrayList;
import java.util.List;

public class AStarSearch {

    public static final int[][] MAZE = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}
    };

    public static void main(String[] args) {
        AStarSearch aStarSearch = new AStarSearch();
        Grid grid = aStarSearch.aStarSearch(new Grid(2, 1), new Grid(2, 5));
        System.out.println(grid.x);
    }

    public Grid aStarSearch(Grid start, Grid end) {
        List<Grid> openList = new ArrayList<>();
        List<Grid> closeList = new ArrayList<>();

        openList.add(start);
        while (openList.size() > 0) {

            Grid minGrid = findMinGridByOpenList(openList);

            findNearGrid(minGrid, openList, closeList, end);

            for (Grid grid : openList) {
                if (end.x == grid.x && end.y == grid.y) {
                    return grid;
                }
            }
        }

        return null;
    }

    private void findNearGrid(Grid minGrid, List<Grid> openList, List<Grid> closeList, Grid end) {
        openList.remove(minGrid);
        closeList.add(minGrid);
        List<Grid> result = searchNearGrid(minGrid, openList, closeList);
        for (Grid grid : result) {
            openList.add(grid.initGrid(minGrid, end));
        }
    }

    private List<Grid> searchNearGrid(Grid minGrid, List<Grid> openList, List<Grid> closeList) {

        List<Grid> result = new ArrayList<>();

        if (validGrid(minGrid.x + 1, minGrid.y, openList, closeList)) {
            result.add(new Grid(minGrid.x + 1, minGrid.y));
        }

        if (validGrid(minGrid.x - 1, minGrid.y, openList, closeList)) {
            result.add(new Grid(minGrid.x - 1, minGrid.y));
        }

        if (validGrid(minGrid.x, minGrid.y - 1, openList, closeList)) {
            result.add(new Grid(minGrid.x, minGrid.y - 1));
        }

        if (validGrid(minGrid.x, minGrid.y + 1, openList, closeList)) {
            result.add(new Grid(minGrid.x, minGrid.y + 1));
        }

        return result;
    }

    private boolean validGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {

        if (x < 0 || y < 0) {
            return false;
        }
        if (MAZE.length > y && MAZE[0].length > x) {
            if (MAZE[y][x] != 1 && !containGrid(openList, x, y) && !containGrid(closeList, x, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean containGrid(List<Grid> list, int x, int y) {
        for (Grid grid : list) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;
    }

    private Grid findMinGridByOpenList(List<Grid> openList) {
        Grid temp = openList.get(0);
        for (Grid grid : openList) {
            if (grid.getF() < temp.getF()) {
                temp = grid;
            }
        }
        return temp;
    }

    private static class Grid {
        int x;
        int y;
        int f;
        int g;
        int h;

        Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Grid getParent() {
            return parent;
        }

        public void setParent(Grid parent) {
            this.parent = parent;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public Grid initGrid(Grid minGrid, Grid end) {
            this.parent = minGrid;
            this.g = parent.g + 1;
            this.h = Math.abs(end.y - this.y) + Math.abs(end.x - this.x);
            this.f = g + h;

            return this;
        }
    }
}
