package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals 
{
	//initial use of comparable method so that these can be directly used by collections and arrays methods
	//the main difference is that comparator can also be used as individually without implementing it with the class
	// as an addon parameter to the collections and arrays methods
	private class interval implements Comparable<interval> 
        {
                int start;
                int end;
                public interval(int start,int end)
                {
                	this.start=start;
                	this.end=end;
                }
                public int compareTo(interval o) 
                {
                        return this.start-o.start;
                }
        }

	public ArrayList<interval> mergeIntervals(ArrayList<interval> intervalList)
	{
		Collections.sort(intervalList);
		ArrayList<Integer> remList= new ArrayList<>();
		int i=0;
        int size = intervalList.size();
        while(i<size-1)
        {
                if(intervalList.get(i).end >= intervalList.get(i+1).start)
                {
                		//replacing the start of the next element with the start of the current element so that 
                		// we could remove the inclusive intervals
                        intervalList.get(i+1).start=intervalList.get(i).start;
                        //this list keeps the list of all the intervals which has to be deleted
                        remList.add(i);
                }
                i++;
        }
        for(int j=0;j<remList.size();j++)
        {
        	int s=remList.get(j);
        	s=s-j; //this is to overcome the deletions which are happenning
        	intervalList.remove(s);
        }
		return intervalList;
	}
	public static void main(String[] args)
	{
		ArrayList<interval> intervalList=new ArrayList<>();
		MergeIntervals mi = new  MergeIntervals();
		intervalList.add(mi.new interval(1,4));
		intervalList.add(mi.new interval(7,8));
		intervalList.add(mi.new interval(3,5));
		intervalList.add(mi.new interval(6,7));
        intervalList.add(mi.new interval(8,9));
        ArrayList<interval> mergedList=mi.mergeIntervals(intervalList);
        for(int i=0;i<mergedList.size();i++)
        {
        	System.out.print("{"+mergedList.get(i).start+" , "+mergedList.get(i).end+"} ");
        }
        System.out.println();
		
	}
}
