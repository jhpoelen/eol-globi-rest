package org.eol.globi.server;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class CypherProxyControllerIT {

    @Test
    public void ping() throws IOException {
        String uri = getURLPrefix() + "ping";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is(not(nullValue())));
    }

    @Test
    public void listPreyForPredator() throws IOException {
        String uri = getURLPrefix() + "predator/Homo%20sapiens/listPrey";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is(not(nullValue())));
    }

    @Test
    public void findTaxonUsingPartialString() throws IOException {
        String uri = getURLPrefix() + "findTaxon/Homo%20sap";
        String response = HttpClient.httpGet(uri);
        assertThat(response, containsString("Homo sapiens"));
    }

    @Test
    public void findExternalUrl() throws IOException {
        String uri = getURLPrefix() + "findExternalUrlForTaxon/Homo%20sapiens";
        String response = HttpClient.httpGet(uri);
        assertThat(response, containsString("url"));
    }

    @Test
    public void listContributors() throws IOException {
        String uri = getURLPrefix() + "contributors";
        String response = HttpClient.httpGet(uri);
        assertThat(response, containsString("Roopnarine"));
    }

    protected String getURLPrefix() {
        return "http://localhost:8080/";
    }

}
