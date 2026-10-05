import java.util.*;

class Solution {
    
    class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    class Cell {
        String value;
        Point parent;
        Cell(String value) {
            this.value = value;
        }
        Cell(String value, Point parent) {
            this.value = value;
            this.parent = parent;
        }
    }
    
    int N = 51;
    Cell[][] chart = new Cell[N][N];
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        for(int i=1;i<N;i++) {
            for(int j=1;j<N;j++) {
                chart[i][j] = new Cell(null);
            }
        }
        
        for(String command: commands) {
            String[] com = command.split(" ");
            String op = com[0];
            switch(op) {
                case "UPDATE": {
                    if(com.length > 3) {
                        int r = Integer.parseInt(com[1]);
                        int c = Integer.parseInt(com[2]);
                        Point root = find(r,c);
                        chart[root.row][root.col].value = com[3];
                    } else {
                        for(int i=1;i<N;i++) {
                            for(int j=1;j<N;j++) {
                                if(com[1].equals(chart[i][j].value)) {
                                    chart[i][j].value = com[2];
                                }
                            }
                        }
                    }
                    break;
                }
                case "MERGE": {
                    int r1 = Integer.parseInt(com[1]);
                    int c1 = Integer.parseInt(com[2]);
                    int r2 = Integer.parseInt(com[3]);
                    int c2 = Integer.parseInt(com[4]);
                    if(r1==r2 && c1==c2) break;
                    
                    Point root1 = find(r1,c1);
                    Point root2 = find(r2,c2);
                    if (root1.row == root2.row && root1.col == root2.col) break;
                    String value1 = chart[root1.row][root1.col].value;
                    String value2 = chart[root2.row][root2.col].value;
                    
                    chart[root2.row][root2.col].parent = root1;
                    chart[root1.row][root1.col].value = value1 != null ? value1 : value2;
                    chart[root2.row][root2.col].value = null;
                
                    break;
                }
                case "UNMERGE": {
                    int r = Integer.parseInt(com[1]);
                    int c = Integer.parseInt(com[2]);
                    Point root = find(r,c);
                    String val = chart[root.row][root.col].value;
                    List<Cell> cells = new ArrayList<>();
                    for(int i=1;i<N;i++) {
                        for(int j=1;j<N;j++) {
                            Point p = find(i, j);
                            if (p.row == root.row && p.col == root.col) {
                                cells.add(chart[i][j]);
                            }
                        }
                    }
                    
                    for(Cell cell: cells) {
                        cell.parent = null;
                        cell.value = null;
                    }
                    
                    chart[r][c].value = val;
                    break;
                }
                case "PRINT": {
                    int r = Integer.parseInt(com[1]);
                    int c = Integer.parseInt(com[2]);
                    Point p = find(r,c);
                    if(chart[p.row][p.col].value == null) {
                        answer.add("EMPTY");
                    } else {
                        answer.add(chart[p.row][p.col].value);
                    }
                    break;
                }
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    Point find(int r, int c) {
        Cell cell = chart[r][c];
        if(cell.parent == null) {
            return new Point(r,c);
        }
        
        Point root = find(cell.parent.row, cell.parent.col);
        cell.parent = root;
        return root;
    }
}