/**
 *  Purpose: To document and return the location of the lines that a single word occurs on.  
 *  Created by: Sean Kurian, as designed by Maria & Gary Litvin. 
 *  Last modified on April 10, 2017.
 */
import java.util.*;

public class IndexEntry
{
  private String word; 
  private ArrayList<Integer> numsList; 
  
  //Initialises word to an input and numsList to default capacity. 
  public IndexEntry(String inputWord)
  {
    word = inputWord.toUpperCase(); 
    numsList = new ArrayList<Integer>(); 
  }
  
  //If the list doesn't already contain the number, the number is added to it.
  public void add(int num)
  {
    if (!numsList.contains(num))
    {
        numsList.add(num);
    }
  }
  
  public String getWord()
  {
    return word; 
  }
  
  public String toString()
  {
	  String info = word + " "; 
	  
	  //Each integer in numsList is concatenated into the string info. 
	  for (int i : numsList)
	  {
		  info += i + ", "; 
	  }
	  //Ensures that an extra comma is not printed at the end
	  return info.substring(0, info.length() - 2); 
  }
}
