package arrays;

public class ReverseWords 
{
	public void reverseString(char[] strarray,int start,int end)
	{
		int mid=(start+end)/2;
		int inc=0;
		for(int i=start;i<=mid;i++)
		{
			char temp=strarray[i];
			strarray[i]=strarray[end-inc];
			strarray[end-inc]=temp;
			inc++;
		}
	}
	public void printArray(char[] strarray)
	{
		for (int i=0;i<strarray.length;i++)
		{
			System.out.print(strarray[i]);
		}
	}
	public String reverseWords(String str)
	{
		char[] strarray=str.toCharArray();
		this.reverseString(strarray,0,strarray.length-1);
		int inc=0;
		int laststop=0;
		while(inc<strarray.length) //it loop the whole loop but calls the reverse string code very few times
		{
			if(strarray[inc]==' ')
			{
				reverseString(strarray,laststop,inc-1);// sum of all this step including the bottom step is o(n)
				laststop=inc+1;
			}
			inc++;
		}
		reverseString(strarray,laststop,strarray.length-1);
//		this.printArray(strarray);
		String newstr= new String(strarray);
		return newstr;
	}
	public static void main(String args[])
	{
		ReverseWords rw = new ReverseWords();
		String str="Hi This is Kaushal";
		System.out.println(str);
		System.out.print(rw.reverseWords(str));
	}
}
