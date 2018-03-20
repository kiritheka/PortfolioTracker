package portfolio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchStockPrice {

	public static double sendRequest(String keySymbol) {
		String value = "";

		try {
			URL urlRequest = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + keySymbol
					+ "&interval=1min&apikey=GQ7GFRH3XJS6L2Q5");
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

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String stockDate = "";
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				cal.add(Calendar.DATE, -3);
				stockDate = dateFormat.format(cal.getTime());
			} else {
				cal.add(Calendar.DATE, -1);
				stockDate = dateFormat.format(cal.getTime());
			}

			JSONObject jsonObj2 = jsonObj1.getJSONObject(stockDate);
			value = jsonObj2.getString("4. close");

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		double Price = Double.parseDouble(value);
		return Price;

	}
}
