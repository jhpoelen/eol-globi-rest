package org.eol.globi.server;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

@Controller
public class PredatorController {

    @RequestMapping(value = "/predator/{scientificName}/listPrey", method = RequestMethod.GET)
    @ResponseBody
    public String listPreyForPredator(@PathVariable("scientificName") String scientificName) throws IOException, URISyntaxException {
        org.apache.http.client.HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://46.4.36.142:7474/db/data/cypher");
        HttpClient.addJsonHeaders(httpPost);
        httpPost.setEntity(new StringEntity("{\"query\":\"START predatorTaxon = node:taxons(name={predatorName}) " +
                "MATCH predatorTaxon<-[:CLASSIFIED_AS]-predator-[:ATE]->prey-[:CLASSIFIED_AS]->preyTaxon " +
                "RETURN distinct(preyTaxon.name) as preyName\", \"params\": { \"predatorName\" : \"" + scientificName + "\" } }"));
        BasicResponseHandler responseHandler = new BasicResponseHandler();
        return httpclient.execute(httpPost, responseHandler);
    }

}