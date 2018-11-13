/**
 *  Purpose of program: Creates a 2D array of numbers and finds all primes in that array. 
 *  Created by: Maria and Gary Litvin
 *  Modified by: Sean K. and N. Yhard
 *  Last modified on March 29th, 2017
 */

import java.util.Scanner;

//Extends NewArray and inherits the 2D int array newMatrix. 
public class Sieve extends NewArray
{
public static String numRows;
public static String numColumns;
private static int rows;
private static int columns;

  public static void startPrimes(int rows, int columns)
  {  

    int[] primeValue = new int[rows*columns];
    int numZeroes = 0; 
    int countPrimeVal = 0;
    int countAllPrimes = 0; 


    //Traverses the 2D array and fills the 1D array primeValue with 2, 3, 5, 7 and
    //all numbers that are indivisible by them. 
    for (int i = 0; i < newMatrix.length; i++)
    {
      for (int j = 0; j < newMatrix[0].length; j++)
      {
        if (newMatrix[i][j] == 2 || newMatrix[i][j] == 3 || newMatrix[i][j] == 5 || newMatrix[i][j] == 7)
        { 
          primeValue[countPrimeVal] = newMatrix[i][j];
          countPrimeVal++; 
        }
        if(newMatrix[i][j] % 2 != 0 && newMatrix[i][j] % 3 != 0 && newMatrix[i][j] % 5 != 0 && newMatrix[i][j] % 7 != 0 && newMatrix[i][j] != 1)
        {
          primeValue[countPrimeVal] = newMatrix[i][j];
          countPrimeVal++; 
        } 
      }
    }
    
    //Checks if each number in the 1D array is divisible by any other number in the array.
    //If it is divisible by a number that is not itself, its spot in the array is replaced with a 0. 
    //Technically, this alone would be able to find all primes but 2D array manipulation is required.
    for (int i = 0; i < primeValue.length; i++)
    {
    	if (primeValue[i] != 0)
    	{
    		for (int k = i; k < primeValue.length; k++)
    		{
    			if (primeValue[k] % primeValue[i] == 0 && primeValue[k] != primeValue[i])
    			{
    				primeValue[k] = 0; 
    			}
    		}
    	}
    }
   
   //Traverses the 1D array and counts the number of 0s.
   for (int j = 0; j < primeValue.length; j++)
   {
     if (primeValue[j] == 0)
     {
       numZeroes ++; 
     }
   }
   
   //Constructs a new 1D array that is the length of the original minus the number of zeroes.
   int[] allPrimes = new int[primeValue.length - numZeroes];
   
   //Traverses the original 1D array once more, and if a number at a given index is not 0, that number
   //is inserted into the new array. 
   for (int k = 0; k < primeValue.length; k++)
   {
	   if (primeValue[k] != 0)
	   {
		   allPrimes[countAllPrimes] = primeValue[k];
		   countAllPrimes++; 
	   }
   }
   
   //The new array is printed out, and every 10 numbers the loop starts printing on the next line. 
   for (int i = 0; i < allPrimes.length; i++)
   {
     System.out.print(allPrimes[i] + "\t");
     if ((i + 1) % 10 == 0 && i != 0)
     {
       System.out.print("\n");
     }
   }
  }
    
  public static void main(String[] args)
  {
    //Creates a scanner for user input to determine the number of rows and columns in the original
	//2D array. As the input type is string, the Integer class' method parseInt is used to 
	//convert the line into integers.
    Scanner kboard = new Scanner(System.in);
    
    System.out.print("Enter the number of rows you would like in the array: ");
    numRows = kboard.nextLine();
    
    System.out.print("Enter the number of columns you would like in the array: ");
    numColumns = kboard.nextLine();
    
    kboard.close();
      
    rows = Integer.parseInt(numRows);
    columns = Integer.parseInt(numColumns);

    //Instantiates and prints out the populated 2D array.
    System.out.println(); 
    System.out.print("2D Array");
    NewArray.matrix(rows, columns);

    //Instantiates and prints out the second 1D array containing only the prime numbers. 
    System.out.println("\n1D Array of Primes from 0 to " + (getElements() - 1));
    Sieve.startPrimes(rows, columns);
   
  }  
}
