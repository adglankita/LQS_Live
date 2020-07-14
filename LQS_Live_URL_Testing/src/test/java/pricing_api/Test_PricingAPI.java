package pricing_api;

//import java.io.BufferedInputStream;
import java.io.BufferedReader;
//import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.opencsv.CSVReader;


public class Test_PricingAPI {

	public static void main(String[] args) throws JSONException {
		String csvFile = "D:\\Desktop data\\JMeter\\LQS JMeter Script\\Pricing Engine\\July 7\\Data for pricing engine.csv";
		
		CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
            	
            	JSONObject object = getAllData(line[0], line[1], line[2], line[3],line[4], line[5], line[6], line[7],line[8], line[9], line[10], line[11],line[12], line[13], line[14], line[15],
            			line[16], line[17], line[18], line[19],line[20], line[21]);
                
            	          	
            	URL link = new URL("http://13.234.254.157:9006/carcre?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZ2wiOiJyYWdoYXYifQ.lDfmyVU27BgQbsgIZ3S1R94A2tjkB9b7N4eY7IEyJ8o");
    			HttpURLConnection httpconn = (HttpURLConnection)link.openConnection();
    			httpconn.setDoOutput(true);
    			httpconn.setRequestProperty("Content-Type","application/json");  
    			httpconn.setRequestMethod("POST");
    			String jsonData = object.toString();
    			//System.out.println(jsonData);
    			
    			OutputStream os = httpconn.getOutputStream();
    	        os.write(jsonData.getBytes());
    	        os.flush();
    			
    			httpconn.setConnectTimeout(10000);
 
    			httpconn.connect();
   			
    			 BufferedReader br = new BufferedReader(new InputStreamReader((httpconn.getInputStream())));

    		        String output;
    		        System.out.println("Output from Server .... \n");
    		        while ((output = br.readLine()) != null) {
    		            System.out.println(output);
    		        }
    			
    			
 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }	
		}
	
	public static JSONObject getAllData(String line0, String line1, 
			String line2, String line3, String line4, 
			String line5, String line6, 
			String line7, String line8, String line9, 
			String line10, String line11, String line12, 
			String line13, String line14, String line15, String line16, String line17, 
			String line18, String line19, String line20, String line21) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("region", line0.toString());
		object.put("vehicledetails_fueltype", line1.toString());
		object.put("vehicledetails_vehiclecartype", line2.toString());
		object.put("vehicledetails_transmission", line3.toString());
		object.put("vehicledetails_reasonforntv", line4.toString());	
		object.put("vehicledetails_colorcode", line5.toString());
		object.putOnce("vehicledetails_modelcode", line6.toString());
		object.put("vehicledetails_variantcode", line7.toString());
		object.put("vehicledetails_servicehistoryavl", line8.toString());
		object.put("vehicledetails_numberofowner", line9.toString());
		object.put("vehicledetails_externalcng_lpgfit", line10.toString());
		object.put("vehicledetails_enginecc", line11);
		object.put("vehicledetails_kmrun", line12);
		object.put("age", line13);
		object.put("systemrating_exterior", line14);
		object.put("systemrating_interior", line15);
		object.put("systemrating_srfunction", line16);
		object.put("systemrating_frame", line17);
		object.put("systemrating_vehiclerating", line18);
		object.put("evaluatorrating_evaluatorvehiclerating", line19);	
		object.put("evaluatorrating_evaluatedrfcost", line20);
		object.put("city", line21);
		
    	return object;
	}
	
	
}