import java.io.BufferedReader;
import java.io.InputStreamReader;


/*Challenge:https://www.hackerrank.com/challenges/palindrome-index
 * 
 * 
 * 
 * @Author:Raghuveer Sagar
 */



public class Palindrome_Index {

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		
		while(cases-->0){
		char[] x = br.readLine().toCharArray();
		Palindrome_Index p = new Palindrome_Index();
		
		System.out.println(p.calculate(x));
		}
		
	}
	
	
	public int calculate(char[] x)
	{
		int start =0;
		int end = x.length-1;
		//boolean isPalindrome=true;
		while(start<end)
		{
			
		boolean found=false;	
		if(x[start]!=x[end])
		{
			
			int i=1;
			int j=1;
			
			if(x[start+1]==x[end])
			{
				found=true;
				//return start;
			}
			if(x[start] == x[end-1])
			{
				if(found)
				{
					if(x[start+2]==x[end-1])
						return start;
					else
					return end;
				}
				
				return end;
			}
			
			if(found)
				return start;
			
			
		}
			
		start++;
		end--;
			
		}
		
		return -1;
	
		
	}
}
