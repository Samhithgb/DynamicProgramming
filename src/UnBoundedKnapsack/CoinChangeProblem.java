package UnBoundedKnapsack;

//return the maximum possible combination of coins
public class CoinChangeProblem {

    private static int[][] memory;
    private static int[] INPUT_COINS = new int[]{2,3,4,6,7,8};
    private static int AMOUNT = 7;

    public static void main(String[] args){
        memory = new int[INPUT_COINS.length+1][AMOUNT+1];
        System.out.println(coinChange());
    }

    public static int coinChange(){
        for(int i=0; i< INPUT_COINS.length+1; i++) {
            for(int j=0; j< AMOUNT+1; j++) {
                if(i == 0) {
                    memory[i][j] = 0;
                }
                if(j==0) {
                    memory[i][j] = 1;
                }
            }
        }

        for(int i=1; i< INPUT_COINS.length+1; i++) {
            for(int j=1; j< AMOUNT+1; j++) {
               if(INPUT_COINS[i-1] > j) {
                    memory[i][j] = memory[i-1][j];
               } else {
                    memory[i][j] = memory[i][j-INPUT_COINS[i-1]] + memory[i-1][j];
               }
            }
        }

        return memory[INPUT_COINS.length][AMOUNT];
    }
}
