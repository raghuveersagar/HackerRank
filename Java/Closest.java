import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 
 * 
 * https://www.hackerrank.com/challenges/closest-numbers
 * 
 * @Author:Raghuveer Sagar
 * 
 */

public class Closest {

	int[] sort(int start, int end, int[] arr) {

		if (start == end)
			return new int[] { arr[start] };

		int mid = (start + end) / 2;
		int m[] = sort(start, mid, arr);
		int n[] = sort(mid + 1, end, arr);

		return merge(m, n, mid - start + 1, end - mid);

	}

	int[] merge(int[] m, int[] n, int m_size, int n_size) {
		int[] ans = new int[m_size + n_size];
		int i = 0, j = 0, k = 0;

		while (i < m_size && j < n_size) {

			if (m[i] < n[j]) {
				ans[k++] = m[i++];

			}

			else {
				ans[k++] = n[j++];

			}
		}

		while (i < m_size) {
			ans[k++] = m[i++];

		}

		while (j < n_size) {
			ans[k++] = n[j++];
		}

		return ans;

	}

	public static void main(String[] args) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.valueOf(br.readLine());

		int[] input = new int[size];
		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < size; i++)
			input[i] = Integer.valueOf(temp[i]);
		input = new Closest().sort(0, size - 1, input);
		int diff = Integer.MAX_VALUE;
		String pairs = "";
		for (int i = 0; i < size - 1; i++) {
			if (Math.abs(input[i] - input[i + 1]) < diff) {
				diff = Math.abs(input[i] - input[i + 1]);
				// pairs="";
				pairs = input[i] + " " + input[i + 1];

			}

			else if (Math.abs(input[i] - input[i + 1]) == diff) {
				pairs = pairs + " " + input[i] + " " + input[i + 1];

			}

		}

		System.out.println(pairs);
	}

}
