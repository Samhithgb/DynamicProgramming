package knapsack;

public class CountSubsetsWithGivenSum {
    public static int[][] memory;
    private static final int[] INPUT = new int[]{10,10,20,30,20,10};
    private static final int SUM = 20;

    public static void main(String[] args){
        memory = new int[INPUT.length+1][SUM+1];
        System.out.println(countSubSetWithSum(SUM,INPUT));
    }

    public static int countSubSetWithSum(int sum, int[] array) {
        for(int i = 0; i < array.length+ 1 ; i++) {
            for(int j = 0; j< sum+1; j ++ ) {
                if(i==0) {
                    memory[i][j] = 0;
                }
                if(j == 0) {
                    memory[i][j] = 1;
                }
            }
        }

        for(int i = 1; i < array.length+ 1 ; i++) {
            for(int j = 1; j< sum+1; j ++ ) {
                if(array[i-1]  > j){
                    memory[i][j] = memory[i-1][j];
                }else {
                    memory[i][j] = memory[i-1][j-array[i-1]] + memory[i-1][j];
                }
            }
        }

        return memory[array.length][sum];
    }


}
