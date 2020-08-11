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
        Queue<String> q = new Queue<String>(number + 1);
        q.enqueue("1");
        for(int i = 0; i < number; i++){
            result[i] = q.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            q.enqueue(s1);
            q.enqueue(s2);
        }
        return result;
    }

    public static void main(String args[]) {

        String[] output = findBin(3);
        for(int i = 0; i < 3; i++)
            System.out.print(output[i] + " ");
    }
}
