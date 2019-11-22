package gateway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSgateway {
	public static void main(String[] args) {
	    StringBuilder content = new StringBuilder();
		try {

		
		String requestUrl  = "https://2factor.in/API/V1/be5b7f3f-ddbe-11e9-ade6-0200cd936042/SMS/+918727844990/AUTOGEN";
     
		URL url = new URL(requestUrl);

		HttpURLConnection uc = (HttpURLConnection)url.openConnection();

		System.out.println(uc.getResponseMessage());
        System.out.println(uc.getHeaderFields());
		uc.disconnect();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uc.getInputStream()));

	      String line;

	      // read from the urlconnection via the bufferedreader
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.append(line + "\n");
	      }
	      bufferedReader.close();
	    
	   System.out.println(content);
	    
		
		} catch(Exception ex) {

		System.out.println(ex.getMessage());

		}
	}
}
