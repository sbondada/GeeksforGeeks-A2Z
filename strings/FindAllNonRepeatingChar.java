package strings;

import java.util.LinkedHashSet;

public class FindAllNonRepeatingChar 
{
	public char getNonRepeatingCharacters(String str)
	{
		LinkedHashSet<Character> Set= new LinkedHashSet<>();
		LinkedHashSet<Character> nonrepeatingSet= new LinkedHashSet<Character>();
		char[] strarray=str.toCharArray();
		for(char tempchar:strarray)
		{
			if(!Set.contains(tempchar) && !nonrepeatingSet.contains(tempchar))
			{
				nonrepeatingSet.add(tempchar);
			}
			else if(nonrepeatingSet.contains(tempchar))
			{
				nonrepeatingSet.remove(tempchar);
				Set.add(tempchar);
			}
		}
		return nonrepeatingSet.iterator().next();
	}
	public static void main(String args[])
	{
		FindAllNonRepeatingChar fanrc = new  FindAllNonRepeatingChar();
		String str="abaacdbaa";
		char nonrep=fanrc.getNonRepeatingCharacters(str);
		System.out.println(nonrep);
	}
}
