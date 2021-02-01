package BoundedKnapsack;

public class EqualSumPartition {

    private static boolean [][] memory;

    private static int[] INPUT = new int[]{10,20,10};

    public static void main(String[] args){
        System.out.println(equalSumPartition(INPUT));
    }

    public static boolean equalSumPartition(int[] array){
        int sum = 0;
        for(int i : array) {
            sum += i;
        }
        if(sum%2 != 0) {
            return false;
        }

        memory = new boolean[array.length+1][(sum/2)+1];

        for(int i=0; i < (array.length+1); i++) {
            for(int j=0; j < ((sum/2)+1); j++ ) {
                if(i == 0) {
                    memory[i][j] = false;
                }
                if(j == 0) {
                    memory[i][j] = true;
                }
            }
        }

        for(int i = 1 ; i < (array.length + 1) ; i++ ) {
            for(int j = 1; j < ((sum/2)+1) ; j++) {

                if(array[i-1] > j) {
                    memory[i][j] = memory[i-1][j];
                } else {
                    memory[i][j] = memory[i-1][j-array[i-1]] || memory[i-1][j];
                }
            }
        }

        return memory[array.length][sum/2];
    }

}
