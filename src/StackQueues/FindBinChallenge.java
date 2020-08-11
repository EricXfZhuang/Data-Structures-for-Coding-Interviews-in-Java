package StackQueues;

public class FindBinChallenge {
    /*
    * Input #
      A positive integer n.

      Output #
      It returns binary numbers up to n.
      *
      * Sample Input #
        n = 3
        Sample Output #
        result = {"1","10","11"}
    *
    *
    * */

    public static String[] findBin(int number) {
        String[] result = new String[number];
        // Write -- Your -- Code
        for(int i = 1; i < number; i++){
            result[i-1] = Integer.toBinaryString(i);
        }
        return result; //For number = 3 , result = {"1","10","11"};
    }
}
