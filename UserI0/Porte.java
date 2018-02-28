package newe;
import java.util.List;

public interface Porte {
	long fileCounting() throws Exception;

	String[] stringArray() throws  Exception;

	List<String[]> fileReading() throws Exception;

	int[] portfolioCalculation() throws Exception;

	void portfolioSorting() throws Exception;

}
