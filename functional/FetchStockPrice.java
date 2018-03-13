package functional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;


public class FetchStockPrice {

	public static String sendRequest(String url) {
		String value = "";

		try {
			URL urlRequest = new URL(url);
			URLConnection connection = urlRequest.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseBuilder = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				responseBuilder.append(line);
			}
			br.close();
			String result = responseBuilder.toString();

			JSONObject myjson = new JSONObject(result);
			JSONObject jsonObj1 = myjson.getJSONObject("Time Series (Daily)");
			/*
			 * SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
			 * Date now = new Date(); String strDate = sdfDate.format(now); JSONObject
			 * jsonObj2 = jsonObj1.getJSONObject(strDate);
			 */
			JSONObject jsonObj2 = jsonObj1.getJSONObject("2018-03-12");
			value = jsonObj2.getString("4. close");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	/*public static void main(String[] args) {
		String stockValue = JsonNew.sendRequest(
				"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=GOOG&interval=1min&apikey=GQ7GFRH3XJS6L2Q5");
		System.out.println(stockValue);
	}*/

}
