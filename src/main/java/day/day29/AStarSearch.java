package day.day29;

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

        Grid start = new Grid(1, 2);
        Grid end = new Grid(5, 2);
        Grid grid = getGridPath(start, end);
        List<Grid> grids = findAllParent(grid);

        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[0].length; j++) {
                if (containGrid(grids, j, i)) {
                    System.out.print("*,");
                } else {
                    System.out.print(MAZE[i][j] + ",");
                }
            }
            System.out.println();
        }
    }

    private static boolean containGrid(List<Grid> grids, int x, int y) {
        for (Grid grid : grids) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;
    }

    private static List<Grid> findAllParent(Grid grid) {
        List<Grid> grids = new ArrayList<>();
        while (grid != null) {
            grids.add(grid);
            grid = grid.parent;
        }
        return grids;
    }

    private static Grid getGridPath(Grid start, Grid end) {
        List<Grid> closeList = new ArrayList<>();
        List<Grid> openList = new ArrayList<>();

        start.init(end, null);
        openList.add(start);

        while (!openList.isEmpty()) {

            Grid minfGrid = findMinFGrid(openList);
            openList.remove(minfGrid);
            closeList.add(minfGrid);

            List<Grid> grids = findGrids(minfGrid, openList, closeList);

            for (Grid grid : grids) {
                grid.init(end, minfGrid);
            }

            openList.addAll(grids);

            for (Grid grid : closeList) {
                if (grid.x == end.x && grid.y == end.y) {
                    return grid;
                }
            }
        }

        return null;
    }

    private static List<Grid> findGrids(Grid grid, List<Grid> openList, List<Grid> closeList) {
        List<Grid> grids = new ArrayList<>();
        if (validGrid(grid.x - 1, grid.y, openList, closeList)) {
            grids.add(new Grid(grid.x - 1, grid.y));
        }

        if (validGrid(grid.x + 1, grid.y, openList, closeList)) {
            grids.add(new Grid(grid.x + 1, grid.y));
        }

        if (validGrid(grid.x, grid.y - 1, openList, closeList)) {
            grids.add(new Grid(grid.x, grid.y - 1));
        }

        if (validGrid(grid.x, grid.y + 1, openList, closeList)) {
            grids.add(new Grid(grid.x, grid.y + 1));
        }
        return grids;
    }

    private static boolean validGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {

        if (x >= 0 && x < MAZE[0].length && y >= 0 && y < MAZE.length && MAZE[y][x] != 1) {

            for (Grid grid : openList) {
                if (grid.x == x && grid.y == y) {
                    return false;
                }
            }

            for (Grid grid : closeList) {
                if (grid.x == x && grid.y == y) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    private static Grid findMinFGrid(List<Grid> openList) {
        Grid temp = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f <= temp.f) {
                temp = grid;
            }
        }
        return temp;
    }

    private static class Grid {
        int f;
        int g;
        int h;
        int x;
        int y;
        Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
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

        public void init(Grid end, Grid parent) {
            if (parent == null) {
                this.g = 0;
            } else {
                this.g = parent.g + 1;
                this.parent = parent;
            }

            this.h = Math.abs(end.x - this.x) + Math.abs(end.y - this.y);

            this.f = this.h + this.g;
        }

        @Override
        public String toString() {
            return "Grid{" + "x=" + x + ", y=" + y + ", parent=" + parent + '}';
        }
    }
}
