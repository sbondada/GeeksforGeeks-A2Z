package strings;

public class CountWordsInString 
{
    public int countWords(String array)
    {
    	int count=0;
    	int i;
    	for(i=0;i<array.length();i++)
    	{
    		if(i!=0 &(array.charAt(i)==' ' || array.charAt(i)=='\n' || array.charAt(i)=='\t'))
    		{
    			count++;
    		}
    	}
    	System.out.println(i);
        if(i==array.length() && (array.charAt(i-1)!=' ' || array.charAt(i-1)!='\n' || array.charAt(i-1)!='\t'))
        {
                count++;
        }
        return count;
    }
	public static void main(String args[])
	{
		CountWordsInString cwis=new CountWordsInString();
		String abc="Hi this is kaushal\nwhat about\tyou";
		System.out.println(cwis.countWords(abc));
	}
}
