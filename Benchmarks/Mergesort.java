/**
 *  Created by: Maria and Gary Litvin
 *  Utilised by: Sean Kurian on April 26, 2017
 *  Purpose: To order an array using Merge sort. 
 */
public class Mergesort
{
  private static double[] temp;

//Recursively sorts an array using the private helper method recursiveSort
  public static void sort(double[] a)
  {
    int n = a.length;
    temp = new double[n];
    recursiveSort(a, 0, n-1);
  }

  //Private helper method to sort an array from a given number to a given number
  private static void recursiveSort(double[] a, int from, int to)
  {
    //Base case, called if there are only one or two elements left
    if (to - from < 2)       
    {
      //Swaps the start and end point if the end point is greater than the start point but
      //the element at the end point is less than the element at the start point
      if (to > from && a[to] < a[from])
      {
        double aTemp = a[to]; a[to] = a[from]; a[from] = aTemp;
      }
    }
    //Else, calls itself recursively for each half of the array. 
    else
    {
      int middle = (from + to) / 2;
      recursiveSort(a, from, middle);
      recursiveSort(a, middle + 1, to);
      merge(a, from, middle, to);
    }
  }

  //Merges the two halves of the array together.
  private static void merge(double[] a, int from, int middle, int to)
  {
    int i = from, j = middle + 1, k = from;


    while (i <= middle && j <= to)
    {
      //If an element at  is less than an element at j, the temp array at k
      //is set to the input array at i, and i is incremented by 1.  
      if (a[i] < a[j])
      {
        temp[k] = a[i]; 
        i++;
      }
      //Else the temp array at k is set to the input array at j, and j is incremented
      //by one. 
      else
      {
        temp[k] = a[j];
        j++;
      }
      k++;
    }

    //Fills temp with the first half of the input array. 
    while (i <= middle)
    {
      temp[k] = a[i];     
      i++;
      k++;
    }

    //Fills temp with the second half of the input array. 
    while (j <= to)
    {
      temp[k] = a[j];     
      j++;
      k++;
    }

    //Fills the input array with the temp array.
    for (k = from; k <= to; k++)
      a[k] = temp[k];
  }
}
