/**
 *  Created by: Maria and Gary Litvin
 *  Utilised by: Sean Kurian on April 26, 2017
 *  Purpose: To order an array using insertion sort. 
 */
public class InsertionSort
{
  //Sorts an input double array using the insertion sort algorithm
  public static void sort(double[] a)
  {
    //Checks each element starting from the second element of the array
    for (int n = 1; n < a.length; n++)
    {
      double aTemp = a[n];

      //Shifts elements to the right to create a space, and when an element
      // that is less than or equal to aTemp is found, inserts it into the proper
      //location. 
      int i = n;
      while (i > 0 && aTemp < a[i-1])
      {
        a[i] = a[i-1];
        i--;
      }

      a[i] = aTemp;

    }
  }
}

