/**
 * @author      Christopher Yang <cyang001@citymail.cuny.edu>
 * @version     1.0
 * @since       2015-05-11
 */

public abstract class HW6 {
    public static void main(String[] args) {
        testCase();
    }

    public static void testCase(){
//        // Start times of each activity
//        int[] s = {0, 1, 2, 4, 1, 5, 8, 9, 11, 13};
//
//        //Finish times of each activity
//        int[] f = {0, 3, 5, 7, 8, 9, 10, 11, 14, 16};

        int[] s = {0, 1, 2, 3, 4, 5};
        int[] f = {0, 3, 5, 5, 6, 7};
        int[] w = {0, 10, 20, 5, 20, 15};

        // Save the maximum weights in each index (indicating the number of activities)
        int[] table = activitySelection(s, f, w);


        // Print the results
        for(int element: table)
            System.out.print(element + " ");



    }


    public static int[] activitySelection(int[] s, int[] f, int[] w){
        // Create the table
        int[] table = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            // With size 0 there are 0 activities
            if (i == 0)
                table[i] = 0;
            // Initialize the rest of the table as empty with -1
            else
                table[i] = -1;
        }

        // Find the maximum weight of the activities for each size of activities
        for(int i = 1; i < table.length; i++)
            table[i] = getNonOverlap(s, f, w, table, i);

        return table;
    }


    public static int getNonOverlap(int[] s, int[] f, int[] w, int[] table, int i){

        // If it is empty
        if(table[i] == -1) {
            int compatibleIndex = i-1;

            // Find a compatible index by comparing the finishing time of the smaller left-side
            // subproblem with the starting time of the current index
            while(f[compatibleIndex] > s[i]) {
                --compatibleIndex;
            }

            // Compare and return the max weight between the previous size versus choosing the current activity
            table[i] = max(getNonOverlap(s, f, w, table, i-1), getNonOverlap(s, f, w, table, compatibleIndex)+w[i]);
        }
        return table[i];
    }


    public static int max(int a, int b){
        if(a > b)
            return a;
        else
            return b;
    }
}

