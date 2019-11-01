import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfTestCases = scanner.nextInt();

    while (numberOfTestCases-- > 0) {
      long initialValue = scanner.nextLong();
      String winnerName = calculateWhoWins(initialValue);
      System.out.println(winnerName);
    }
    scanner.close();
  }
 
/**
 * There are three possibilities for each participant: 
 *  1. Reduce the integer by dividing it by 2, if the interger is a power of 2.
 *  2. Subtract from the integer the next lower number that is a power of two, 
 *     if the interger is not a power of 2.
 *  3. A move is not possible, if the initial integer is 1.
 *
 * Moves No1 and No2 are the equivalent of removing the leading "1" from 
 * the binary representation of the integer. 
 *
 * Therefore, all three possibilties allow us to determine the person 
 * who reduces the integer to one, thus the winner, by counting 
 * the total number of "1s" and the number of trailing "0s" 
 * after the last "1" in the binary representation of the initial integer.
 *
 * @return A string, representing the name of the winner.
 */ 
  private static String calculateWhoWins(long initialValue) {

    String[] participants = {"Louise", "Richard"};

    String binary = Long.toBinaryString(initialValue);
    int totalTrailing_0s_afterLast_1 = binary.length() - (binary.lastIndexOf("1") + 1);
    int total_1s = binary.replaceAll("0", "").length();

    if (total_1s % 2 != 0) {
      if (totalTrailing_0s_afterLast_1 % 2 != 0) {
        return participants[0];
      }
      return participants[1];
    }

    if (total_1s % 2 == 0) {
      if (totalTrailing_0s_afterLast_1 % 2 != 0) {
        return participants[1];
      }
    }
    return participants[0];
  }
}
