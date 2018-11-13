/**
 *  Created by: Maria and Gary Litvin
 *  Modified by: Sean Kurian on April 26, 2017
 *  Purpose: To allow users to test and average the time it takes each sorting algorithm
 *  to sort random arrays with a chosen number of elements.  
 */


//Import statements, mostly for GUI
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.Random;

public class Benchmarks extends JFrame
{
  //Hard coded to be the number of times the algorithm runs, and then averages the value.
  private static int numberOfRuns = 20;

  private JTextField arraySizeInput, display;
  private String sortMethodNames[] =
     {"Selection Sort", "Insertion Sort", "Mergesort", "Quicksort"};
  private JComboBox<String> chooseSortMethod;

  //Seed for choosing the array numbers "randomly"
  private final long seed;
  private int arraySize;

  //Constructor for Benchmarks, sets up the GUI window and panel as 
  //well as the random seed (current system time in milliseconds)
  public Benchmarks()
  {
    super("Benchmarks");

    Container c = getContentPane();
    c.setLayout(new GridLayout(6, 1));

    //Sets default "suggested" array size to 1000, but can be easily changed in the combo box. 
    c.add(new JLabel(" Array size: "));
    arraySizeInput = new JTextField(4);
    arraySizeInput.setText("1000");
    arraySizeInput.selectAll();
    c.add(arraySizeInput);

    chooseSortMethod = new JComboBox<String>(sortMethodNames);
    
    c.add(chooseSortMethod);

    //Creates a button to run the program and adds actionListener to it
    //To capture click events. 
    JButton run = new JButton("Run");
    run.addActionListener(new RunButtonListener());
    c.add(run);

    c.add(new JLabel(" Avg Time (milliseconds): "));

    display = new JTextField("   Ready");
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display);

    seed = System.currentTimeMillis();
  }

  private long runSort(double[] a, int sortMethod, int numberOfRuns)
  {
    Random generator = new Random(seed);
    long totalTime = 0; 
    
    //Note 1: Runs each algorithm based on the user choice. 
    //Returns the average total time taken to run the sort.
    if (sortMethod == 1)
    {
      long startTime = System.currentTimeMillis(); 

      for (int j = 0; j <= numberOfRuns; j++)
      {      
        for (int i = 0; i < a.length; i++)
        {
          a[i] = generator.nextDouble(); 
        }
        SelectionSort.sort(a); 
      }
      totalTime = Math.abs(startTime - System.currentTimeMillis()); 
    }
    
    //See note 1. 
    else if (sortMethod == 2)
    {
      long startTime = System.currentTimeMillis(); 
      for (int j = 0; j <= numberOfRuns; j++)
      {
        for (int i = 0; i < a.length; i++)
        {
          a[i] = generator.nextDouble(); 
        }
        InsertionSort.sort(a); 
      }
      totalTime = Math.abs(startTime - System.currentTimeMillis()); 
    }
    
    //See note 1. 
    else if (sortMethod == 3)
    {
      long startTime = System.currentTimeMillis(); 
      for (int j = 0; j <= numberOfRuns; j++)
      {
        for (int i = 0; i < a.length; i++)
        {
          a[i] = generator.nextDouble(); 
        }
        Mergesort.sort(a); 
      }
      totalTime = Math.abs(startTime - System.currentTimeMillis());  
    }
    
    //See note 1. 
    else if (sortMethod == 4)
    {
      long startTime = System.currentTimeMillis(); 

      for (int j = 0; j <= numberOfRuns; j++)
      {
        for (int i = 0; i < a.length; i++)
        {
          a[i] = generator.nextDouble(); 
        }
        Quicksort.sort(a); 
      }
      totalTime = Math.abs(startTime - System.currentTimeMillis()); 
    }
    //Returns the total time taken to sort a different randoma array 20 
    //times using each algorithm. 
    return totalTime;
  }

  private class RunButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      //If there are non number characters input for the array size, an error will be printed
      //to the user. 
      String inputStr = arraySizeInput.getText().trim();
      try
      {
        arraySize = Integer.parseInt(inputStr);
      }
      catch (NumberFormatException ex)
      {
        display.setText(" Invalid array size");
        arraySize = 0;
        return;
      }
      
      //If the arraysize is less than or equal to 0, an error will be printed to the user.
      if (arraySize <= 0)
      {
        display.setText(" Invalid array size");
        return;
      }

      if (arraySize <= 0)
        return;

      //Chooses which method to use, and returns the average time taken to run the algorithm 20 times.
      int sortMethod = chooseSortMethod.getSelectedIndex() + 1;
      double a[] = new double[arraySize];
      double avgTime = (double)runSort(a, sortMethod, numberOfRuns)
                                                          / numberOfRuns;
      display.setText(String.format("  %.2f", avgTime));

      arraySizeInput.selectAll();
      arraySizeInput.requestFocus();
      System.out.println("Array size = " + arraySize +
            " Runs = " + numberOfRuns + " " +
            sortMethodNames[sortMethod - 1] + " avg time: " + avgTime);

    }
  }

  
  //Main method for the program. 
  public static void main(String[] args)
  {
    numberOfRuns = 20;
    if (args.length > 0)
    {
      int n = -1;
      try
      {
        n = Integer.parseInt(args[0].trim());
      }
      catch (NumberFormatException ex)
      {
        System.out.println("Invalid command-line parameter");
        System.exit(1);
      }
      if (n > 0)
        numberOfRuns = n;
    }

    //Creates a window and sets the dimensions. 
    Benchmarks window = new Benchmarks();
    window.setBounds(300, 300, 180, 200);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
