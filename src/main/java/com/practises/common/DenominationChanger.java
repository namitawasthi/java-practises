package pac.interviews;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DenominationChanger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(";");
		Double a = Double.valueOf(str[0]);
		Double b = Double.valueOf(str[1]);
		Double c = b - a;

		BigDecimal bigDecimal = new BigDecimal(Double.toString(c));
		bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
		c = bigDecimal.doubleValue();
		System.out.println(c);
		ArrayList<String> lis = new ArrayList<>();
		do {
			if (c >= 10.00) {
				lis.add("TEN");
				c = new BigDecimal(Double.toString(c - 10.00)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 5.00) {
				lis.add("FIVE");
				c = new BigDecimal(Double.toString(c - 5.00)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 2.00) {
				lis.add("TWO");
				c = new BigDecimal(Double.toString(c - 2.00)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 1.00) {
				lis.add("ONE");
				c = new BigDecimal(Double.toString(c - 1.00)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 0.50) {
				lis.add("HALF DOLLAR");
				c = new BigDecimal(Double.toString(c - 0.50)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 0.25) {
				lis.add("QUARTER");
				c = new BigDecimal(Double.toString(c - 0.25)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 0.10) {
				lis.add("NICKEL");
				c = new BigDecimal(Double.toString(c - 0.10)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			if (c >= 0.05) {
				lis.add("PENNY");
				c = new BigDecimal(Double.toString(c - 0.05)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}

		} while (c != 0);

		Collections.sort(lis);
		lis.stream().forEach(System.out::print);
	}

}
