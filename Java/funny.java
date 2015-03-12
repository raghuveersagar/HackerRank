import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.hackerrank.com/contests/zenhacks/challenges/funny-string
 * 
 * 
 * @Author:Raghuveer Sagar
 */

public class funny {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		abc: while (cases-- > 0) {
			char s[] = br.readLine().toCharArray();
			int length = s.length;
			for (int i = 1; i < length - 1; i++) {
				if (Math.abs(s[i] - s[i - 1]) != Math.abs(s[length - i]
						- s[length - i - 1])) {
					System.out.println("Not funny");
					continue abc;
				}

			}
			System.out.println("Funny");

		}
	}

}
