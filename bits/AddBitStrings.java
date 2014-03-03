package bits;

public class AddBitStrings 
{
	public String addBitStrings(String x,String y)
	{
		int xlen=x.length();
		int ylen=y.length();
		String extra="";
		int extarlen=Math.abs(xlen-ylen);
		while(extarlen!=0)
		{
			extra+="0";
			extarlen--;

		}
		if(xlen<ylen)
		{
			x=extra+x;
		}
		else if(xlen>ylen)
		{
			y=extra+y;
		}
		System.out.println(x);
		System.out.println(y);
		int i=x.length()-1;
		int carry=0;
		char[] sumvalue=new char[x.length()+1];
		while(i>=0)
		{
			int tempx=x.charAt(i)-'0';
			int tempy=y.charAt(i)-'0';
			char startasci='0';
			sumvalue[i]=(char)(((tempx^tempy)^carry)+(int)startasci);
			carry=(tempx&tempy)|(tempx&carry)|(tempy&carry);
			i--;
		}
		String sumValueString=new String(sumvalue);
		return sumValueString;
	}
	public static void main(String args[])
	{
		String x="10000001101";
		String y="11101101";
        AddBitStrings abs=new AddBitStrings();
		String value=abs.addBitStrings(x, y);
		System.out.println(value);
	}
}
