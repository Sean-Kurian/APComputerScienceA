/**
 *  Purpose of program: Creates a 2D array of numbers and finds all primes in that array. 
 *  Created by: N. Yhard
 *  Modified by: Sean K.
 *  Last modified on March 29th, 2017
 */

public class NewArray
{ 

  private static int elements;
  public static int newMatrix[][];

  public static void matrix(int rows, int columns)
  {

    //Creates an empty 2D array using the parameters rows and columns, and then calculates the number
	//of elements it has. 
    newMatrix = new int[rows][columns];
    elements = rows * columns; 
    System.out.println (" with " + elements + " elements in the matrix.");
    

    int count = 0; 
    
    //Traverses the 2D array index by index and fills it with numbers from 0 to the max number of elements - 1. 
    for (int i = 0; i < newMatrix.length; i++)
    {
      for (int j = 0; j < newMatrix[0].length; j++)
      {
        newMatrix[i][j] = count;
        System.out.print(newMatrix[i][j] + "\t");
        
        //After 10 numbers are printed out, the loop starts printing on the next line. 
        if ((count + 1) % 10 == 0)
        {
        System.out.print("\n");
        }
        count++; 
      }
    }
 
  }
  
  //Accessor for the field elements. 
  public static int getElements()
  {
    return elements; 
  }

}
