package CucumberApiSampleProject.projectAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestUtils {

	// public boolean validurl(String url) {
	//
	// return url != null && !url.isEmpty();
	//
	// }
	// static HttpResponse result = "";
	public static Map<String,String> sendPOST(String url) throws IOException {
		// TODO Auto-generated method stub

		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json");

		// List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		// urlParameters.add(new BasicNameValuePair("email", "eve.holt@reqres.in"));
		// urlParameters.add(new BasicNameValuePair("password", "cityslicka"));

		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"email\":\"eve.holt@reqres.in\",");
		json.append("\"password\":\"cityslicka\"");
		json.append("}");
		System.out.println(json.toString());
		post.setEntity(new StringEntity(json.toString()));

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			String result = EntityUtils.toString(response.getEntity());
			Map<String,String> responseMap = new HashMap<>();
			responseMap.put("responseBody", result);
			responseMap.put("statusCode", Integer.toString(response.getStatusLine().getStatusCode()));
			return responseMap;
		}
	}

}