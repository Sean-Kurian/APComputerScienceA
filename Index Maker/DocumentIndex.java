/**
 *  Purpose: To document and return the location of the lines that each word occurs on.  
 *  Created by: Sean Kurian, as designed by Maria & Gary Litvin. 
 *  Last modified on April 10, 2017.
 */

import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
  //No args constructor referring to ArrayList's constructor
  public DocumentIndex()
  {
    super();
  }
  
  //Constructor with one int parameter referring to ArrayList's constructor with one int parameter.
  public DocumentIndex(int cap)
  {
    super(cap);
  }
  
  //Helper method to check whether a word has already been placed in the array list.
  //If it is, the line of the word's occurrence is returned. 
  //If it is not, a new IndexEntry with the word is added to the list alphabetically 
  //and the index of its occurrence is returned. 

  private int foundOrInserted(String word)
  {
    word = word.toUpperCase(); 
	  for (int i = 0; i < this.size(); i++)
	  {
		  String checkWord = this.get(i).getWord().toUpperCase(); 
	 
		  if (word.equals(checkWord))
		  {
			  return i; 
		  }
		  else if (word.compareTo(checkWord) < 0)
		  {
			  this.add(i, new IndexEntry(word));
			  return i; 
		  }
	  }
	  
	  this.add(new IndexEntry(word));
	  return this.size() - 1; 
  }
  
  //Simply adds the line number of a word. 
  public void addWord(String word, int num)
  {
	  this.get(foundOrInserted(word)).add(num);
  }
  
  //Adds all line numbers to the index entry for a given word.
  public void addAllWords(String str, int num)
  {
    //Breaks a given string down into individual words using a Regular Expression. 
    String[] temp = str.split("\\W+");
    
    //Calls addWord for each string in the array, as long as it is not blank.
    for(String i : temp)
    {
    if (!i.equals(""))
      {
        addWord(i, num);
      }
    }
  }
  
}
