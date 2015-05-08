/**
 * Created by ChrisYang on 5/5/15.
 */
public abstract class HW6 {
    public static void main(String[] args) {

        int[] s = {1, 2, 4, 1, 5, 8, 9, 11, 13};
        int[] f = {3, 5, 7, 8, 9, 10, 11, 14, 16};
    }

    public static int[][] getTable(int[] s, int[] f) {

        int n = s.length;

        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    table[i][j] = 1;
                else
                    table[i][j] = maxActivity(s, f, i, j);
            }
        }

        return table;
    }


    public static int maxActivity(int[] s, int[] f, int i, int j){
        if(s[])

    }
}

