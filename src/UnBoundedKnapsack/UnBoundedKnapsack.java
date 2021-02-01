package UnBoundedKnapsack;


// aka The Rod Cutting Problem.
public class UnBoundedKnapsack {

    private static int[][] memory;
    private static int[] VALUES = new int[]{1,4,3,2,3,4,7,6,8,8};
    private static int[] WEIGHTS = new int[]{1,2,1,2,3,1,2,3,1,5};

    private static int WEIGHT = 10;

    public static void main(String[] args) {
        memory = new int[VALUES.length + 1][WEIGHT + 1];
        System.out.println(unBoundedKnapSack());
    }

    public static int unBoundedKnapSack() {
        for (int i = 1; i < VALUES.length + 1; i++) {
            for (int j = 1; j < WEIGHT + 1; j++) {
                if(WEIGHTS[i-1] > j) {
                    memory[i][j] = memory[i-1][j];
                }
                else{
                    memory[i][j] = Math.max(VALUES[i-1] + memory[i][j-WEIGHTS[i-1]], memory[i-1][j]);
                }
            }
        }
        return memory[VALUES.length][WEIGHT];
    }
}
