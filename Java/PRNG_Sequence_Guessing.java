import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Input
{
	
public List<Integer> firstnums = new ArrayList<Integer>();
public long start ;
public long end;

	
	
}

public class PRNG_Sequence_Guessing {

	
	public List<Input> inputs = new ArrayList<Input>();
	
	public static void main(String[] args) {
		
		PRNG_Sequence_Guessing test  = new PRNG_Sequence_Guessing();
		test.input();
		
		for (Input x : test.inputs)
		{
			long start = x.start;
			long end  = x.end;
			
			for (long i = start;i<=end;i++)
			{
				
				Random rand  = new Random(i);
				if (rand.nextInt(1000)==x.firstnums.get(0) && rand.nextInt(1000)==x.firstnums.get(1) && rand.nextInt(1000) == x.firstnums.get(2) &&
					rand.nextInt(1000)==x.firstnums.get(3) && rand.nextInt(1000)==x.firstnums.get(4) && rand.nextInt(1000) == x.firstnums.get(5) &&
					rand.nextInt(1000)==x.firstnums.get(6) && rand.nextInt(1000)==x.firstnums.get(7) && rand.nextInt(1000) == x.firstnums.get(8) && rand.nextInt(1000) == x.firstnums.get(9))
				{
					StringBuffer sb = new StringBuffer(String.valueOf(i));
					sb.append(" ");
					for(int j=0;j<10;j++)
					{
						sb.append(rand.nextInt(1000));
						sb.append(" ");
					}
					
					System.out.println(sb.toString());
				}
			}
				
			
		}
		
		/*long start = 1374037299;
		long end  = 1374143600;
		
		for (long i = start;i<=end;i++)
		{
			
			Random rand  = new Random(i);
			if (rand.nextInt(1000)==877 && rand.nextInt(1000)==654 && rand.nextInt(1000) == 2)
			{
				System.out.println(i);
				//break;
			}
		}*/
		
		
		
		/*for(int i=0;i<10;i++)
		rand.nextInt(1000);
		for(int i=0;i<10;i++)
			System.out.println(rand.nextInt(1000));
		int firstnums[] = {643,953,522,277,464,366,321,409,227,702};
		*/
		
		
	}
	
	
	public  void input()
	{
		
		
		try{
		BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		//System.out.println("Number of cases"+cases);
		
		for(int i=0;i<cases;i++)
		{
			Input temp_input = new Input();
			String temp = br.readLine();
			temp_input.start = Long.parseLong(temp.split(" ")[0]);
			temp_input.end = Long.parseLong(temp.split(" ")[1]);
			for(int j=0;j<10;j++)
			{
				temp_input.firstnums.add(Integer.parseInt(br.readLine()));
				
			}
			
			inputs.add(temp_input);
			
		}
		

	
}
		
		catch(IOException io){
	io.printStackTrace();
}
		
		
		
	}

}