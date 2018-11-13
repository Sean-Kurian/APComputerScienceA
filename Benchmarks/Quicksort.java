/**
 *  Created by: Maria and Gary Litvin
 *  Utilised by: Sean Kurian on April 26, 2017
 *  Purpose: To order an array using selection sort. 
 */

public class Quicksort
{
  //Calls the private method recursiveSort with the parameters
  //a, the random array, 0 as the start position and the end of the array
  //a.length - 1 as the end position
  public static void sort(double[] a)
  {
    recursiveSort(a, 0, a.length - 1);
  }

  private static void recursiveSort(double[] a, int from, int to)
  {
    //Base case: If the one end is equal to the other end, or the beginning, quit the method
    if (from >= to)
      return;

    //Sets the pivot point to the middle of the array 
    int p = (from + to ) / 2;



    int i = from;
    int j = to;
    while (i <= j)
    {
      if (a[i] <= a[p])
        i++;
      else if (a[j] >= a[p])
        j--;
      else
      {
        swap (a, i, j);
        i++;
        j--;
      }
    }

    //Swaps the pivot point to its correct location
    if (p < j)
    {
      swap (a, j, p);
      p = j;
    }
    else if (p > i)
    {
      swap (a, i, p);
      p = i;
    }

    //Calls recursive sort for the two arrays on either wide of the pivot. 
    recursiveSort(a, from, p - 1);
    recursiveSort(a, p + 1, to);
  }

  //Private helper method to swap elements in the array. 
  private static void swap (double[] a, int i, int j)
  {
    double temp = a[i]; a[i] = a[j]; a[j] = temp;
  }
}
