package knapsack;

public class KnapSackTopDown {

    private static int[][] memory;

    private static final int W = 20;
    private static final int N = 11;
    private static final int[] VALUES = new int[]{10,11,3,4,59,59,6,92,39,94,4};
    private static final int[] WEIGHTS = new int[]{12,13,15,34,45,56,77,12,23,23,21};

    public static void main(String[] args){
        memory = new int[N+1][W+1];
        System.out.println(knapSackTopDown(VALUES, WEIGHTS));
    }

    public static int knapSackTopDown(int[] weights, int[] values){
        for(int i = 1 ; i < N+1; i++) {
            for(int j = 1; j< W+1 ; j++) {
                if(weights[i-1] > j) {
                    memory[i][j] = memory[i-1][j];
                } else {
                    memory[i][j] = Math.max(values[i - 1] + memory[i - 1][j - weights[i - 1]], memory[i - 1][j]);
                }
            }
        }
        return memory[N][W];
    }
}
