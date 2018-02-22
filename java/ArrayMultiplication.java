import java.util.ArrayList;
import java.util.List;

public class ArrayMultiplication {

	public List<Double> portfolioMultiplication() {
		int numberOfLines = 3;
		double value = 0.0;
		List<Double> myList = new ArrayList<Double>();
		double arr[] = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
		for (int j = 0; j < numberOfLines; j++) {
			for (int i = 0; i < arr.length; i += 2) {
				value = value + (arr[i] * arr[i + 1]);
			}
			// System.out.println(value);
			myList.add(value);
		}
		return myList;
	}

	public static void main(String args[]) {
		ArrayMultiplication arrayMultiplication = new ArrayMultiplication();
		System.out.println(arrayMultiplication.portfolioMultiplication());
	}

}
