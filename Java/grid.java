import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 
 * https://www.hackerrank.com/contests/zenhacks/challenges/strange-grid
 * 
 * @Author:Raghuveer Sagar
 */

public class grid {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp[] = br.readLine().split(" ");
		long r = Long.parseLong(inp[0]);
		boolean even = true;
		long c = Integer.parseInt(inp[1]);
		long x = r;
		if (r % 2 == 1) {
			x = r + 1;
			even = false;
		}
		x = x / 2;
		long ans = ((x * 5) * 2 - 2) - (2 * (5 - c));
		if (even)
			ans += 1;
		System.out.println(ans);

	}

}
