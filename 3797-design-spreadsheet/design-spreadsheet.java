class Spreadsheet {
    int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
        for(int i = 0;i<rows;i++){
            Arrays.fill(sheet[i],0);
        }
    }
    public boolean isNumber(char c){
        return c>='0' && c<='9';
    }
    
    public void setCell(String cell, int value) {
        char r = cell.charAt(0);
        int col = Integer.valueOf(cell.substring(1));
        int row = (int) r-'A';
        sheet[col-1][row] = value;
    }
    
    public void resetCell(String cell) {
        char r = cell.charAt(0);
        int col = Integer.valueOf(cell.substring(1));
        int row = (int) r-'A';
        sheet[col-1][row] = 0;
    }
    
    public int getValue(String formula) {
        String expr = formula.substring(1);
        int index = expr.indexOf('+');
        String left = expr.substring(0,index);
        String right = expr.substring(index+1);

        int val1,val2;

        if(isNumber(left.charAt(0))){
            val1 = Integer.valueOf(left);
        }
        else{
            char a = left.charAt(0);
            int number = Integer.valueOf(left.substring(1));
            val1 = sheet[number-1][a-'A'];
        }

        if(isNumber(right.charAt(0))){
            val2 = Integer.valueOf(right);
        }
        else{
            char a = right.charAt(0);
            int number = Integer.valueOf(right.substring(1));
            val2 = sheet[number-1][a-'A'];
        }
        return val1+val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */