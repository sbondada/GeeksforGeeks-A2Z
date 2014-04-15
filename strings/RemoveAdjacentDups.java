package strings;

public class RemoveAdjacentDups 
{
	public String removeAdjacents(char[] array,int i,int flag) 
	{
		if(i<array.length)
		{
            if(array[i]==array[i-1] && flag==0)
            {
                array[i-1]='\0';
                flag=1;
            }
            else if(array[i]==array[i-1] && flag==1)
            {
                array[i-1]='\0';
            }
            else if(array[i]!=array[i-1] && flag==1)
            {
                array[i-1]='\0';
            	flag=0;
            }
            String str=removeAdjacents(array, i+1,flag);
            return str;
		}
		else
		{
			return new String(array).replace("\0","");
		}
	}
	public String repeatAdjacency(String str)
	{
		char[] strarray=str.toCharArray();
		String temp="";
		String returnstr=str;
		while (temp.compareTo(returnstr)!=0)
		{
			temp=returnstr;
			returnstr=removeAdjacents(returnstr.toCharArray(),1,0);
			System.out.println("inside "+returnstr);
		}
		return returnstr;
	}
	public static void main(String args[])
	{
		RemoveAdjacentDups rad = new RemoveAdjacentDups();
		String str="abcccbad";
		String temp=rad.repeatAdjacency(str);
		System.out.println(temp);
	}
}