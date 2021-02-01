package knapsack;

public class CountSubSetsWithGivenDifference {
    private static int[] INPUT = new int[]{20,23,46,54,2,7,76};
    private static int DIFFERENCE = 13;

    public static void main(String[] args){
        System.out.println(countSubSetsWithDifference());
    }

    public static int countSubSetsWithDifference(){
        int sumRange = 0;
        for (int j : INPUT) {
            sumRange += j;
        }
        int range = (sumRange - DIFFERENCE)/2;

        CountSubsetsWithGivenSum.memory = new int[INPUT.length+1][range+1];
        return CountSubsetsWithGivenSum.countSubSetWithSum(range,INPUT);
    }
}
