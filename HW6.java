/**
 * Created by ChrisYang on 5/5/15.
 */
public abstract class HW6 {
    public static void main(String[] args) {

        int[] s = {0, 1, 2, 4, 1, 5, 8, 9, 11, 13};
        int[] f = {0, 3, 5, 7, 8, 9, 10, 11, 14, 16};

        int[] table = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            if (i == 0)
                table[i] = 0;
            else
                table[i] = -1;
        }

        activitySelection(s, f, table);


        for(int element: table){
            System.out.print(element + " ");
        }
    }

    public static void activitySelection(int[] s, int[] f, int[] table){


        for(int i = 1; i < table.length; i++){
            if(table[i] == -1) {
                int j = i;

                while(f[j-1] > s[i])
                    --j;

                int nonOverlap = j-1;
                table[i] = max(table[i-1], table[nonOverlap] + 1);
            }


        }



    }


    public static int max(int a, int b){
        if(a > b)
            return a;
        else
            return b;
    }

}

