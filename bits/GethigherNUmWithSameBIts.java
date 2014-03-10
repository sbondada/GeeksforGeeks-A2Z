package bits;

public class GethigherNUmWithSameBIts 
{
	public int getGreaterNumberWithSameBits(int num)
	{
		int mask=0x00000001;
		int flag=0;
		int bit=mask&num;
		int setbitcount=0;
		while(!(flag==1 && bit==0))
		{
			if(bit==1 && flag==0)
			{
				flag=1;
			}
			mask=mask<<1;
			if((mask&num)>0)
			{
				bit=1;
				setbitcount++;
			}
			else
			{
				bit=0;
			}
		}
		int newnum=num^mask;
		int newmask=0;
		while(mask!=0)
		{
			mask=mask>>1;
			newmask=newmask|mask;
		}
		newmask=newmask^0xffffffff;
		newnum=newnum&newmask;
		mask=0x00000001;
		while(setbitcount!=0)
		{
			newnum=newnum|mask;
			mask=mask<<1;
			setbitcount--;
		}
		return newnum;
	}
	public static void main(String args[])
	{
		int num = 0x00000bf0;
		System.out.println(Integer.toBinaryString(num));
		GethigherNUmWithSameBIts ghnws = new GethigherNUmWithSameBIts();
		int newnum=ghnws.getGreaterNumberWithSameBits(num);
		System.out.println(Integer.toBinaryString(newnum));
	}
		
}
