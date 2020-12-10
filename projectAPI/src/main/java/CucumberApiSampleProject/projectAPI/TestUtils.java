package CucumberApiSampleProject.projectAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import io.restassured.internal.http.HttpResponseContentTypeFinder;
import io.restassured.response.Response;

public class TestUtils {

	// public boolean validurl(String url) {
	//
	// return url != null && !url.isEmpty();
	//
	// }
	// static HttpResponse result = "";
	public static HttpResponse sendPOST(String url) throws IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient httpclient = null;

		HttpPost post = new HttpPost(url);

		// List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		// urlParameters.add(new BasicNameValuePair("email", "eve.holt@reqres.in"));
		// urlParameters.add(new BasicNameValuePair("password", "cityslicka"));

		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"email\":\"eve.holt@reqres.in\",");
		json.append("\"password\":\"cityslicka\"");
		json.append("}");

		post.setEntity(new StringEntity(json.toString()));

		try {
			httpclient = HttpClients.createDefault();
			CloseableHttpResponse response = httpclient.execute(post);
			return response;

		} finally {
			httpclient.close();
		}
	}

}