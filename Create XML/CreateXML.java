import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import nu.xom.*; 
  
public class CreateXML
{
  static Element people = new Element ("people");
  static Document doc;
 
  
  public static void addPerson(String user, String real)
  {  
   Element userName = new Element ("userName"); 
   Element realName = new Element ("realName"); 
   Element person = new Element ("person");
   userName.appendChild(user);
   realName.appendChild(real);    
   person.appendChild(userName); 
   person.appendChild(realName);   
   people.appendChild(person);
  }
  
  public static void searchUser(String user)
  {     
    Elements friends = people.getChildElements();
    for (int i=0; i < friends.size(); i++)
    {
      if(friends.get(i).getFirstChildElement("userName").getValue().equals(user))
      {
        System.out.println(friends.get(i).toXML());
        return; 
      }
    }
    System.out.println("This person does not exist.");
  }
  
  public static void searchName(String user)
  {     
    Elements friends = people.getChildElements();
    for (int i=0; i < friends.size(); i++)
    {
      if(friends.get(i).getFirstChildElement("realName").getValue().equals(user))
      {
        System.out.println(friends.get(i).toXML());
        return; 
      }
    }
    System.out.println("This person does not exist.");
  }
  
  public static void displayData()
  {
	  System.out.print(doc.toXML());
  }
  
  public static void main(String[] args)
  {
    File file = new File("intList.xml");
    Builder builder = new Builder();
    Scanner kb = new Scanner(System.in); 
    int option = 0; 
    boolean repeat = true; 
    String yesOrNo; 
    
    try
    {
     doc = builder.build(file);
     people = doc.getRootElement();
    }
    catch(IOException e)
    {
      doc = new Document(people); 
    }

  catch(ParsingException e)
    {

    }

    System.out.println("Welcome to your int list.");
    System.out.println("Your options are as follows");
    System.out.println("1. You may display all the people currently on your int list");
    System.out.println("2. You may search by username to check whether a person appears on your int list.");
    System.out.println("3. You may search by real name to check whether a person appears on your int list.");
    System.out.println("4. You may add a new person to your int list");
    
    try 
    {
    	while (option != 1 && option != 2 && option != 3 && option != 4)
    	{
    	System.out.println("Please enter an option (1-4) now:");
    	System.out.print(">");
    	option = kb.nextInt(); 
    	}
    }
    catch (InputMismatchException e1)
    {
    	option = 0; 
    	System.out.println("Invalid option, now closing your int list.");
    }
   
    if (option == 1)
    {    	
    	kb.nextLine(); 
    	while (repeat)
    	{
    	displayData(); 
    	System.out.println("Do you want to redisplay the information? ('Yes' or 'No')");
    	System.out.print(">");

    	yesOrNo = kb.nextLine(); 
    	if (yesOrNo.equalsIgnoreCase("No"))
    	{
    		repeat = false; 
    	}
    	}
    }
    else if (option == 2)
    {    	
    	kb.nextLine();
    	while (repeat)
    	{
    	String user; 
    	System.out.println("Enter the username of the person you wish to find: ");
    	System.out.print(">");
    	user = kb.nextLine(); 
    	searchUser(user); 
    	System.out.println("Do you want to search for a user again? ('Yes' or 'No') ");
    	System.out.print(">");

    	yesOrNo = kb.nextLine(); 
    	if (yesOrNo.equalsIgnoreCase("No"))
    	{
    		repeat = false; 
    	}
    	}
    }
    else if (option == 3)
    {
    	kb.nextLine();
    	while (repeat)
    	{
    	String name; 
    	System.out.println("Enter the name of the person you wish to find: ");
    	System.out.print(">");
    	name = kb.nextLine();
    	searchName(name); 
    	System.out.println("Do you want to search for a name again? ('Yes' or 'No') ");
    	System.out.print(">");
    	
    	yesOrNo = kb.nextLine(); 
    	if (yesOrNo.equalsIgnoreCase("No"))
    	{
    		repeat = false; 
    	}
    	else if (!yesOrNo.equalsIgnoreCase("Yes"))
    	{
    		System.out.print("Invalid option, now closing your int list.");
    		repeat = false; 
    	}
    	}
    	
    }
    else if (option == 4)
    {  		
    	kb.nextLine();
    	while (repeat)
    	{
    		String user, name; 
    		System.out.println("Enter the player's username: ");
        	System.out.print(">");
    		user = kb.nextLine(); 
    		System.out.println("Enter the player's real name: "); 
        	System.out.print(">");
    		name = kb.nextLine(); 
    		 
    		
    		addPerson(user,name); 
    		
        	System.out.println("Do you want to add another person to your int list? ('Yes' or 'No') ");
        	System.out.print(">");
        	
        	yesOrNo = kb.nextLine(); 
        	if (yesOrNo.equalsIgnoreCase("No"))
        	{
        		repeat = false; 
        	}
    	}
    }
    
    
    try 
    {
      FileWriter fileWrite = new FileWriter("intList.xml");
      BufferedWriter writer =  new BufferedWriter(fileWrite);
      writer.write(doc.toXML());
      writer.close();
    }

    catch (IOException e) 
    {

    }
 
    
  }
}
