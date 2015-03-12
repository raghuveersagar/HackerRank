import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/*
 * 
 * https://www.hackerrank.com/contests/infinitum10/challenges/sherlock-and-moving-tiles
 * 
 * 
 * @Author:Raghuveer Sagar
 * 
 */

public class Sherlock {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Sherlock st = new Sherlock();
		String[] line_arr = line.split(" ");
		double l = Double.valueOf(line_arr[0]);
		double s1 = Double.valueOf(line_arr[1]);
		double s2 = Double.valueOf(line_arr[2]);

		// System.out.println(s1);
		// System.out.println(s1);
		int cases = Integer.valueOf(br.readLine());
		for (int i = 0; i < cases; i++) {

			double area = Double.valueOf(br.readLine());
			if (Math.abs(l * l - area) <= Math.pow(10, -4)) {
				System.out.println(0.0);
				continue;
			}

			if (s1 > s2) {
				double temp = s1;
				s1 = s2;
				s2 = temp;

			}
			if ((s2 - s1) <= Math.pow(10, -4)) {
				System.out.println(0.0);
				return;
			}

			st.calculate(l, area, s1, s2);

		}

	}

	public void calculate(double L, double area, double s1, double s2) {

		// System.out.println("So far so good");
		/*
		 * double L=10.0; double s1=1.0; double s2 = 2.0; double area = 50.0;
		 */
		double s1_s2 = s1 - s2;
		// System.out.println("So far so good"+s1_s2);
		double b = 2 * Math.sqrt(2) * L * s1_s2;
		// BigDecimal _b = new BigDecimal(String.valueOf(b)).multiply(new
		// BigDecimal(L));

		double a = Math.pow(s1_s2, 2);
		// BigDecimal _a = new BigDecimal(String.valueOf(s1_s2)).multiply(new
		// BigDecimal(String.valueOf(s1_s2)));
		double c = 2 * (Math.pow(L, 2) - area);

		// BigDecimal temp_c = new BigDecimal(String.valueOf(L)).multiply(new
		// BigDecimal(String.valueOf(L)));

		// BigDecimal _c = new BigDecimal(String.valueOf(temp_c)).subtract(new
		// BigDecimal(area));
		// _c = _c.multiply(new BigDecimal(String.valueOf(2)));
		// System.out.println(temp_c);
		// System.out.println(b);
		// System.out.println(a);
		// System.out.println(c);

		// BigDecimal b_2 = _b.multiply(_b);

		// BigDecimal _4ac = _a.multiply(_c).multiply(new BigDecimal("4"));
		// BigDecimal _b_2_4ac = b_2.subtract(_4ac);

		double b_2_4ac = Math.pow(b, 2) - (4 * a * c);

		// Math.pow(b, 2)-(4*a*c);
		// BigDecimal _b_2_4ac = new BigDecimal(String.valueOf(c));
		double sq_b2_4ac = Math.sqrt(b_2_4ac);

		double root1 = ((-1 * b) - (sq_b2_4ac)) / (2 * a);
		double root2 = ((-1 * b) - (sq_b2_4ac)) / (2 * a);

		if (root1 > 0 && root1 < L)
			System.out.println(root1);
		else
			System.out.println(root2);

	}

}
