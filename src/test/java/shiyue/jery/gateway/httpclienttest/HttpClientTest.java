package shiyue.jery.gateway.httpclienttest;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jery
 * @date 2019/8/5
 */
public class HttpClientTest {

    @Test
    public void test() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        try {
            response = httpClient.execute(httpGet);
            System.out.println(response.getAllHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
