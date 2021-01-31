package knapsack;

public class KnapSack {

    private static int[][] memory;

    private static final int W = 20;
    private static final int N = 11;
    private static final int[] VALUES = new int[]{10,11,3,4,59,59,6,92,39,94,4};
    private static final int[] WEIGHTS = new int[]{12,13,15,34,45,56,77,12,23,23,21};

    public static void main(String[] args) {
        memory = new int[21][12];
        System.out.println(knapsack(WEIGHTS, VALUES, W, N-1));
    }

    public static int knapsack(int[] weights, int[] values, int W, int n){
        if(n == 0 || W == 0) {
            return 0;
        }
        if(memory[W][n] != 0) {
            return memory[W][n];
        }

        else if(weights[n] <= W) {
            memory[W][n] = Math.max(values[n] + knapsack(weights,values,W-weights[n],n-1),
                    knapsack(weights,values,W, n-1));
            return memory[W][n];
        } else {
            memory[W][n] = knapsack(weights,values,W, n-1);
            return memory[W][n];
        }
    }
}
