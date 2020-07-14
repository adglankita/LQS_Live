package pricing_api;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.opencsv.CSVReader;

public class Test_PricingAPI_part1 {

	public static void main(String[] args) throws JSONException {

		String csvFile = "C:\\Users\\AGL\\Desktop\\JMeter\\LQS JMeter Script\\Pricing API\\Pricing API for Automation\\Data_for_testing_api_500.csv";
		
		CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
            	
            	HttpClient client = HttpClientBuilder.create().build();
                HttpPost post = new HttpPost("http://35.154.217.180:9001/carcre?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZ2wiOiJhZ2wiLCJleHAiOjE1Nzg2NDM1OTN9.S_xaB3nJEglNw-jIIfcdvHxgCsYqb_Nv4QMAB-PXpAE");
            	
                JSONObject object = getAllData(line[0], line[1], line[2], line[3],line[4], line[5], line[6], line[7],line[8], line[9], line[10], line[11],line[12], line[13], line[14], line[15],
            			line[16], line[17], line[18], line[19],line[20], line[21], line[22], line[23],line[24], line[25], line[26], line[27]);
                
                                
                String jsonData = object.toString();
                post.setEntity(new StringEntity(jsonData));
               System.out.println(post.getEntity());
                
                HttpResponse response = client.execute(post);
                
                // Print out the response message
                System.out.println(EntityUtils.toString(response.getEntity()));
         
            }
        }catch (IOException e) {
            e.printStackTrace();
        }	
		
	}
	
	public static JSONObject getAllData(String line0, String line1, 
			String line2, String line3, String line4, 
			String line5, String line6, 
			String line7, String line8, String line9, 
			String line10, String line11, String line12, 
			String line13, String line14, String line15, String line16, String line17, 
			String line18, String line19, String line20, String line21, String line22, 
			String line23, String line24, String line25, String line26, String line27) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("city", line0.toString());
		object.put("region", line1.toString());
		object.put("vehicledetails_fueltype", line2.toString());
		object.put("vehicledetails_vehiclevariant", line3.toString());
		object.put("vehicledetails_vehiclemodel", line4.toString());
		object.put("vehicledetails_vehiclecartype", line5.toString());
		object.putOnce("vehicledetails_vehiclecolor", line6.toString());
		object.put("vehicledetails_transmission", line7.toString());
		object.put("vehicledetails_reasonforntv", line8.toString());
		object.put("vehicledetails_variant", line9.toString());
		object.put("citydesc", line10.toString());
		object.put("vehicledetails_servicehistoryavl", line11);
		object.put("vehicledetails_numberofowner", line12);
		object.put("vehicledetails_vehiclecategory", line13);
		object.put("vehicledetails_externalcng_lpgfit", line14);
		object.put("vehicledetails_enginecc", line15);
		object.put("insurancedetails_insurance", line16);
		object.put("systemrating_exterior", line17);
		object.put("systemrating_interior", line18);
		object.put("systemrating_srfunction", line19);
		object.put("systemrating_frame", line20);
		object.put("systemrating_vehiclerating", line21);
		object.put("evaluatorrating_evaluatorvehiclerating", line22);
		object.put("vehicledetails_age", line23);
		object.put("evaluatorrating_evaluatedrfcost", line24);
		object.put("evaluatorrating_quotedprice", line25);
		object.put("evaluatorrating_customerexpectedprice", line26);
		object.put("vehicledetails_kmrun", line27);
		
    	return object;
	}
	
	
	

}
