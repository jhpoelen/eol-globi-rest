package org.eol.globi.server;

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

@Controller
public class TrophicController {

    @RequestMapping(value = "/predator/{scientificName}/listPrey", method = RequestMethod.GET)
    @ResponseBody
    public String listPreyForPredator(@PathVariable("scientificName") String scientificName) throws IOException {
        String query = "{\"query\":\"START predatorTaxon = node:taxons(name={predatorName}) " +
                "MATCH predatorTaxon<-[:CLASSIFIED_AS]-predator-[:ATE]->prey-[:CLASSIFIED_AS]->preyTaxon " +
                "RETURN distinct(preyTaxon.name) as preyName\", \"params\": { \"predatorName\" : \"" + scientificName + "\" } }";
        return execute(query);
    }

    @RequestMapping(value = "/prey/{scientificName}/listPredators", method = RequestMethod.GET)
    @ResponseBody
    public String listPredatorForPrey(@PathVariable("scientificName") String scientificName) throws IOException {
        String query = "{\"query\":\"START preyTaxon = node:taxons(name={preyName}) " +
                "MATCH predatorTaxon<-[:CLASSIFIED_AS]-predator-[:ATE]->prey-[:CLASSIFIED_AS]->preyTaxon " +
                "RETURN distinct(predatorTaxon.name) as predatorName\", \"params\": { \"preyName\" : \"" + scientificName + "\" } }";
        return execute(query);
    }

    @RequestMapping(value = "/findTaxon/{taxonName}", method = RequestMethod.GET)
    @ResponseBody
    public String findTaxon(@PathVariable("taxonName") String taxonName) throws IOException {
        String query = "{\"query\":\"START taxon = node:taxons('*:*') " +
                "WHERE taxon.name =~ '" + taxonName + ".*'" +
                "RETURN distinct(taxon.name)\"}";
        return execute(query);
    }

    private String execute(String query) throws IOException {
        org.apache.http.client.HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://46.4.36.142:7474/db/data/cypher");
        HttpClient.addJsonHeaders(httpPost);
        httpPost.setEntity(new StringEntity(query));
        BasicResponseHandler responseHandler = new BasicResponseHandler();
        return httpclient.execute(httpPost, responseHandler);
    }

}