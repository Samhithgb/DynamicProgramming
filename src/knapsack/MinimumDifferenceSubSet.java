package knapsack;

public class MinimumDifferenceSubSet {

    private final static int[] INPUT = new int[]{10,10,10,10,4,5,7};
    private static boolean[][] memory;

    public static void main(String[] args){
        int sumRange = 0;
        for (int j : INPUT) {
            sumRange += j;
        }
        memory = new boolean[INPUT.length+1][sumRange+1];
        System.out.println(minimumSubsetDifference(INPUT,sumRange));
    }

    public static int minimumSubsetDifference(int[] array, int sum){
        for(int i=0; i<array.length+1 ; i++) {
            for(int j=0; j < sum+1; j++){
                if(i == 0) {
                    memory[i][j] = false;
                }
                if(j==0){
                    memory[i][j] = true;
                }
            }
        }

        for(int i=1; i < array.length+1 ; i++){
            for(int j=1; j < sum+1 ; j++) {
                if(array[i-1] > j) {
                    memory[i][j] = memory[i-1][j];
                } else {
                    memory[i][j] = memory[i-1][j-array[i-1]] || memory[i-1][j];
                }
            }
        }

        /*
        The last row of the previous memory matrix has information on whether a subset with particular sum is possible in the given array. Use this information for every possible
        sum in the range, and find which sum split results in the minimum difference. sum-2*i because (sum - i)-i
        */
        int minimum = Integer.MAX_VALUE;
        for(int i = 1; i <= ((sum+1)/2); i++) {
            if(memory[array.length][i]){
                minimum = Math.min(minimum, sum-2*i);
            }
        }

        return minimum;
    }
}
