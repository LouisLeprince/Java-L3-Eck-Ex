/**
 * This program counts the number of divisors for integers in the range
 * 1 to 10000.  It finds the maximum divisor count.  It outputs the
 * maximum divisor count and a list of all integers in the range that 
 * have the maximum number of divisors.
 */

public class EE36MostDivisorsWithArray {

   public static void main(String[] args) {
   
	   rollDice(10);
   
   } // end main()
   
   public static int rollDice(int target) {
	   
	   int dice1;
	   int dice2;
	   int diceSum;
	   
	   do {
		   
		   System.out.println(target);
		   dice1 = (int)(6*Math.random());
		   System.out.println(dice1);
		   dice2 = (int)(6*Math.random());
		   System.out.println(dice2);
		   System.out.println();
		   target = target - 1;
	   }
	   while(target > 0);
	   
	   diceSum = dice1+dice2;
	
	   return diceSum;
   }

}
