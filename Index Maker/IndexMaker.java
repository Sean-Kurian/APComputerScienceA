/**
 *  Purpose: To break a text file into an alphabetical list of the words it contains
 *  and then record each line number a word occurs at. 
 *  Created by: Maria and Gary Litvin
 *  Utilised by: Sean Kurian
 *  Last modified on April 10, 2017.
 */


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    
    //Creates a scanner for user input
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    //Uses the BufferedReader class to open the correct text file. 
    if (args.length > 0)
      fileName = args[0];
    
    //Extraneous whitespace is removed with the trim method. 
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);

    //Allows the user to choose a file to output to by using the PrintReader class. 

    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile =
                 new PrintWriter(new FileWriter(fileName));

    //Creates an instance of the DocumentIndex class. 
    DocumentIndex index = new DocumentIndex();

    //Uses the addAllWords method from DocumentIndex on each line of the input text file. 
    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }


    //For each entry, prints out the corresponding words and numbers. 
    for (IndexEntry entry : index)
    {
      outputFile.println(entry);
    }


    //Closes all resources to prevent a resource leak. 
    inputFile.close();
    outputFile.close();

    keyboard.close();
    System.out.println("Done.");
  }
}
