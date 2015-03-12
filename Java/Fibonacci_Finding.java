import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * https://www.hackerrank.com/contests/infinitum10/challenges/fibonacci-finding-easy
 * 
 * @Author:Raghuveer Sagar
 * 
 */

public class Fibonacci_Finding {

	int[][][] mats = new int[32][][];

	void prepare_matrices() {

		mats[0] = new int[][] { { 1, 1 }, { 1, 0 } };
		for (int i = 1; i < 32; i++) {

			mats[i] = multiply(mats[i - 1], mats[i - 1]);

		}

	}

	public static void main(String[] args) throws Exception

	{

		// System.out.println(Integer.MAX_VALUE/100000000);
		Fibonacci_Finding x = new Fibonacci_Finding();
		String[] line_arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			line_arr = br.readLine().split(" ");
			int n = Integer.parseInt(line_arr[2]);
			int A = Integer.parseInt(line_arr[0]);
			int B = Integer.parseInt(line_arr[1]);

			if (n == 0)
				System.out.println(A);

			else if (n == 1)
				System.out.println(B);

			else if (n == 2)
				System.out.println(A + B);
			else {
				// fibs x = new fibs();
				// int n=6;
				// System.out.println(x.fib(7, 9, 1));
				x.prepare_matrices();
				System.out.println(x.fib((n - 1), A, B));

			}
			// System.out.println(x.fib(n,A,B));
		}

	}

	public int fib(int n, int A, int B) {
		// A=9;
		// B=1;
		int custom[][] = { { (A + B), B }, { B, A } };
		int start[][] = { { 1, 1 }, { 1, 0 } };

		/*
		 * if (n-1%2==1) { n=n-4; custom = multiply(custom, start);
		 * 
		 * }
		 */

		int ans[][] = null;
		if (n % 2 == 1) {
			ans = new int[][] { { (A + B), B }, { B, A } };
		} else {
			n = n - 1;
			ans = multiply(custom, start);
		}

		List<Integer> pows = powers(n - 1);

		// System.out.println(pows);
		for (int p : pows) {
			int temp[][] = mats[p];
			// print_matrix(temp);
			ans = multiply(ans, temp);
		}
		// ans = multiply(ans, custom);
		return ans[0][0];
	}

	void print_matrix(int[][] x) {
		for (int[] a : x) {
			for (int b : a)
				System.out.print(b + " ");
			System.out.println();
		}
	}

	/*
	 * int[][] multiply(int[][] x1,int[][] x2) {
	 * 
	 * int ans[][] = new int [2][2]; ans[0][0] =
	 * ((x1[0][0]*x2[0][0])%(1000000007))+ ((x1[0][1]*x2[1][0])%(1000000007));
	 * ans[0][1] = (x1[0][0]*x2[0][1]+ x1[0][1]*x2[1][1])%(1000000007);
	 * ans[1][0] = (x1[1][0]*x2[0][0]+ x1[1][1]*x2[1][0])%(1000000007);
	 * ans[1][1] = (x1[1][0]*x2[0][1]+ x1[1][1]*x2[1][1])%(1000000007);
	 * 
	 * return ans; }
	 */

	public BigInteger multmod(int a, int b) {
		BigInteger x = new BigInteger(String.valueOf(a))
				.multiply(new BigInteger(String.valueOf(b)));
		// System.out.println(x);
		return x.mod(new BigInteger(new String("1000000007")));

	}

	public int addMod(BigInteger x, BigInteger y) {
		return x.add(y).mod(new BigInteger(new String("1000000007")))
				.intValue();

	}

	int[][] multiply(int[][] x1, int[][] x2) {

		int ans[][] = new int[2][2];
		ans[0][0] = addMod(multmod(x1[0][0], x2[0][0]),
				multmod(x1[0][1], x2[1][0]));
		ans[0][1] = addMod(multmod(x1[0][0], x2[0][1]),
				multmod(x1[0][1], x2[1][1]));
		ans[1][0] = addMod(multmod(x1[1][0], x2[0][0]),
				multmod(x1[1][1], x2[1][0]));
		ans[1][1] = addMod(multmod(x1[1][0], x2[0][1]),
				multmod(x1[1][1], x2[1][1]));

		return ans;

	}

	public List<Integer> powers(int x) {
		List<Integer> pows = new ArrayList<Integer>();
		for (int i = 0; i < 32; i++) {

			if (((x >> i) & 1) == 1) {
				pows.add(i);
			}

		}

		return pows;
	}

}
