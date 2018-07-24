import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonParser {

	private static String responseData;
	private static String url  = "https://openexchangerates.org/api/latest.json?app_id=decbfa521b494d56bcf25b139d4e7dee";
	private static String base_currency="INR";
	private static String convert_currency = "FJD";
	private static double value=1500.75;
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
			responseData = getUrlContents(url);

			JSONParser parse = new JSONParser();

			JSONObject jobj = (JSONObject)parse.parse(responseData);
			
			
			HashMap<String,Double> mapElements = (HashMap<String, Double>) jobj.get("rates");
			
			if(mapElements.containsKey(base_currency)&&(mapElements.containsKey(convert_currency)))
			{
				double base_value = mapElements.get(base_currency);
				double con_value = mapElements.get(convert_currency);
				System.out.println(base_value+ " "+con_value);
				double dollar_value = value/base_value;
				double result_value = dollar_value*con_value;
				System.out.println(result_value);
			}
			
			
			
			

	}

	 private static String getUrlContents(String theUrl)
	  {
	    StringBuilder content = new StringBuilder();

	    try
	    {
	     
	      URL url = new URL(theUrl);

	     
	      URLConnection urlConnection = url.openConnection();

	      
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String line;

	      
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.append(line + "\n");
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content.toString();
	  }
}
