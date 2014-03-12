package bits;

import java.util.ArrayList;

import javax.xml.ws.handler.MessageContext.Scope;

public class FindTwoNonRepeatingElements 
{
	public void displayTwoNonRepeatingNumbers(int[] array)
	{
		int totxor=0;
		for(int temp:array)
		{
			totxor=totxor^temp;
		}
		int mask=1;
		while((totxor&mask)==0)
		{
			mask=mask<<1;
		}
		ArrayList<Integer> firstlist= new ArrayList<>();
		ArrayList<Integer> secondlist= new ArrayList<>();
		for(int temp:array)
		{
			if((temp&mask)>0)
			{
				firstlist.add(temp);
			}
			else
			{
				secondlist.add(temp);
			}
		}
		int firstelement=0;
		for(int temp:firstlist)
		{
			firstelement=firstelement^temp;
		}
		System.out.println(firstelement);
		int secondelement=0;
		for(int temp:secondlist)
		{
			secondelement=secondelement^temp;
		}
		System.out.println(secondelement);
	}
	public static void main(String args[])
	{
		FindTwoNonRepeatingElements ftnr = new FindTwoNonRepeatingElements();
		int[] array={1,2,3,1,3,4,2,4,7,2,2,7,3,9};
		ftnr.displayTwoNonRepeatingNumbers(array);
	}
}
