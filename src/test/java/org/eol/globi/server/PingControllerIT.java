package org.eol.globi.server;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class PingControllerIT {
    protected static final String APPLICATION_JSON = "application/json";

    @Test
    public void ping() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(getURLPrefix() + "ping");
        addJsonHeaders(httpGet);
        BasicResponseHandler responseHandler = new BasicResponseHandler();
        assertThat(httpclient.execute(httpGet, responseHandler), is(not(nullValue())));
    }

    protected String getURLPrefix() {
        return "http://localhost:8080/";
    }

    protected void addJsonHeaders(HttpRequestBase httpGet) {
        httpGet.setHeader("Accept", APPLICATION_JSON);
        httpGet.setHeader("Content-Type", APPLICATION_JSON);
    }
}
