package core.dailyproblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Pricing {
	
	
	public static Map<String, String> getMap(String url, String date,boolean isHoldings) {
		Map<String,String> map = new HashMap<>();
		try {
			URL uri = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output = "";
			while ((output =  br.readLine())!=null) {
				if(output.contains(date)){
					String[] s = output.split(",");
						String key = s[1].split(":")[1].trim();
						String val = s[2].split(":")[1].trim();
						if(s[2].split(":")[1].trim().contains("}")){
							val = val.substring(0, val.length()-1);
						}
						
						if(isHoldings){
							if(map.containsKey(key)){
								String value = map.get(key);
								Integer temp = Integer.valueOf(value)+Integer.valueOf(val);
								map.put(key, String.valueOf(temp));
							}
							else{
								map.put(key, val);
							}
						}
						else{
							map.put(s[1].split(":")[1].trim(),val);
						}
				}
			}
		} catch (Exception e) {

		}
		return map;
	}
	
	
	public static void getResults1() {
		//Http
	}
	public static void main(String[] args) {
		
		Map<String,String> holdings = getMap("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding", 
				"20191111",true);
		Map<String,String> pricings = getMap("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing", 
				"20191111",false);
		double output = 0.0;
		for(Entry<String, String> s:holdings.entrySet()){
			if(pricings.containsKey(s.getKey())){
				output = output+(Integer.valueOf(s.getValue()) * (Double.valueOf(pricings.get(s.getKey()))));
			}
		}
		System.out.println(output);
	}
}
