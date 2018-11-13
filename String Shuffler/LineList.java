import java.util.*;
public class LineList 
{
	private ArrayList <String> text;
	
	public LineList()
	{
		text = new ArrayList <String>(); 
	}
	
	public int size()
	{
		return text.size(); 
	}
	
	public String get(int k)
	{
		return text.get(k);
	}
	
	public void add (String line)
	{
		text.add(line);
	}
	
	public String remove(int k)
	{
		return text.remove(k); 
	}
	
	public void move (int index, int newIndex)
	{
		String temp = text.remove(index); 
		if (index > newIndex)
		{
			text.remove(index); 
			text.add(newIndex, temp);
		}
		else
		{
			text.add(newIndex, temp); 
			text.remove(index); 
		}
	}
	
	public void shuffle()
	{

		for (int n = text.size() - 1; n >= 2; n--)
		{
			int index = (int) (Math.random() * n);
			String prevSwap = text.get(index);
			String swap = text.get(n);

			

			text.remove(index);
			text.add(index, swap);
			text.remove(n);
			text.add(n, prevSwap);
		}
	}
}
