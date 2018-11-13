/**
 *  Created by: Maria and Gary Litvin
 *  Utilised by: Sean Kurian on April 26, 2017
 *  Purpose: To order an array using selection sort. 
 */

public class SelectionSort
{

  //Reads in a double array
  public static void sort(double[] a)
  {
    //Starts at the top of the array and decrements until n = 1
    for (int n = a.length; n > 1; n--)
    {
      
      //Searches every index up until the current max number. 
      //Locates largest element up to n.
      int iMax = 0;
      for (int i = 1; i < n; i++)
      {
        if (a[i] > a[iMax])
          iMax = i;
      }

      //Swaps the the largest element with the element at position n-1. 
      double aTemp = a[iMax];
      a[iMax] = a[n-1];
      a[n-1] = aTemp;

    }
  }
}
