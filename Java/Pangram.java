import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/*Challenge:https://www.hackerrank.com/challenges/pangrams
 * 
 * 
 * 
 * 
 *@Author:Raghuveer Sagar 
 */

public class Pangram {

	
	String x = new String();

	
	public static void main(String[] args) throws Exception {
				
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] sentence = br.readLine().toCharArray();
		boolean[] seen = new boolean[26];
		Arrays.fill(seen,false);
		int count = 0;
		for (char c : sentence)
		{
			if (c==' ')
				continue;
			int index = (Character.toUpperCase(c))-'A';
			if(!seen[index])
			{
				seen[index] = true;
				count++;
				
			}
			
			if(count ==26)
			{
				System.out.println("pangram");
				return;
				
			}
			
			
			
		}
		
		
		System.out.println("not pangram");
	}

}
