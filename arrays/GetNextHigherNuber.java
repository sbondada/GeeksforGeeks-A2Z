package arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GetNextHigherNuber 
{
	public int getHigherNextNumber(int num)
	{
		char[] digits=String.valueOf(num).toCharArray();
		ArrayList<Character> subarray= new ArrayList<>();
		int i=0;
		subarray.add(digits[digits.length-1]);
		for(i=digits.length-2;i>=0;i--)
		{
			if((digits[i])>(digits[i+1]))
			{
				subarray.add(digits[i]);
			}
			else
			{
				break;
			}
		}
		Collections.sort(subarray);
		int temp=0;
		int flag=0;
		for (int j=0;j<subarray.size();j++)
		{
			digits[i+1+j]=subarray.get(j);
			if(subarray.get(j)>digits[i] && flag==0)
			{
				flag=1;
				temp=i+1+j;
			}
		}
		char tem=digits[temp];
		digits[temp]=digits[i];
		digits[i]=tem;
		String a="";
		for(char p : digits)
		{
			a+=p;
		}
		return Integer.parseInt(a);
	}
	public static void main(String args[])
	{
		GetNextHigherNuber gnh = new GetNextHigherNuber();
		int num=1287432;
		System.out.println(gnh.getHigherNextNumber(num));
	}
}
