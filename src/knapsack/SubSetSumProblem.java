package knapsack;

public class SubSetSumProblem {
    private static int N = 3;
    private static int SUM = 100;
    private static int[] ARRAY = new int[]{20,30,70};

    private static boolean [][] memory;

    public static void main(String[] args){
        memory = new boolean[N+1][SUM+1];
        for(int i=0; i < N+1; i++) {
            for(int j=0;j<SUM+1;j++) {
                if(i==0)  {
                    memory[i][j] = false;
                }
                if(j == 0) {
                    memory[i][j] = true;
                }
            }
        }
        System.out.println(subSetSum(ARRAY));
    }

    private static boolean subSetSum(int[] array){
        for(int i=1;i< N+1; i++) {
            for(int j=1; j < SUM+1; j++) {
                if(array[i-1] <= j) {
                    memory[i][j] = memory[i-1][j-array[i-1]] || memory[i-1][j];
                } else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
        return memory[N][SUM];
    }
}
