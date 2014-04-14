package strings;

public class RemovecharfromStr 
{
	public void swap(char[] array,int x, int y)
	{
		char temp=array[x];
		array[x]=array[y];
		array[y]=temp;
	}
	public String removeBandAC(char[] strarray)
	{	
		int i=0,j=0;
		while(i<strarray.length-1)
		{
			if(strarray[i]=='b')
			{
				i++;
			}
			else if(strarray[i]=='a' && strarray[i+1]=='c')
			{
				i+=2;
			}
			else
			{
				swap(strarray,i,j);
				i++;
				j++;
			}
		}
		if(strarray[strarray.length-1]!='b' && strarray[strarray.length-1]!='c')
		{
			swap(strarray,strarray.length-1,j);
			j++;
			i++;
		}
		strarray[j]='\0';
		return new String(strarray);
	}
	public static void main(String args[])
	{
		RemovecharfromStr rcfs = new RemovecharfromStr();
		String str="dcsabacfkjheeacsb";
		System.out.println(rcfs.removeBandAC(str.toCharArray()));
	}
}
