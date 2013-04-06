package org.eol.globi.server;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrophicControllerIT {

    @Test
    public void ping() throws IOException {
        String uri = getURLPrefix() + "ping";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is(not(nullValue())));
    }

    @Test
    public void listPreyForPredator() throws IOException {
        String uri = getURLPrefix() + "predator/Homo%20Sapiens/listPrey";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is(not(nullValue())));
    }

    @Test
    public void findTaxonUsingPartialString() throws IOException {
        String uri = getURLPrefix() + "findTaxon/Homo%20Sap";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is(not(nullValue())));
    }

    @Test
    public void findExternalUrl() throws IOException {
        String uri = getURLPrefix() + "findExternalUrlForTaxon/Homo%20Sapiens";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is(not(nullValue())));
    }

    protected String getURLPrefix() {
        return "http://localhost:8080/";
    }

}
