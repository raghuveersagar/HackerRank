import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.List;

/*
 * 
 * https://www.hackerrank.com/challenges/even-tree
 * 
 * @Author:Raghuveer Sagar
 */

class EvenTree {
	public int broken = 0;
	String tree[] = null;

	public static void main(String[] args) throws Exception {

		EvenTree e = new EvenTree();
		e.build_tree();
		// System.out.println(e.childrenCount(1));
		e.childrenCount(1);
		System.out.println(e.broken);

	}

	public void build_tree() throws Exception

	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] temp = line.split(" ");
		int count = Integer.valueOf(temp[0]) + 1;
		tree = new String[count];

		for (int i = 0; i < count - 2; i++) {
			line = br.readLine();
			temp = line.split(" ");
			String val = tree[Integer.parseInt(temp[1])];
			if (val == null) {
				tree[Integer.valueOf(temp[1])] = new String(temp[0]);

			}

			else {
				tree[Integer.valueOf(temp[1])] = val + "-" + temp[0];

			}

		}

		/*
		 * int index =0; for(String x : tree) {
		 * System.out.println(index+"->"+x);
		 * 
		 * index++;
		 * 
		 * }
		 */

	}

	public int childrenCount(int x) {

		if (tree[x] == null)
			return 1;

		else {
			String _temp = tree[x];
			String[] _temp_arr = _temp.split("-");
			int count = 1;
			int temp_count = 0;
			for (String t : _temp_arr) {
				temp_count = childrenCount(Integer.valueOf(t));
				count += temp_count;
				if (temp_count % 2 == 0)
					broken++;

				// count=+temp_count;
			}

			return count;
		}

		// return 0;

	}

}
