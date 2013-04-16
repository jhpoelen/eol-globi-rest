package org.eol.globi.server;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class SearchServiceIT extends ITBase {

    @Test
    public void findCloseMatches() throws IOException {
        String uri = getURLPrefix() + "findCloseMatchesForTaxon/Homo%20SApient";
        String response = HttpClient.httpGet(uri);
        assertThat(response, is("{\"columns\":[\"(taxon.name)\"],\"data\":[[\"Homo sapiens\"]]}"));
    }

    @Test
    public void findCloseMatchesPath() throws IOException {
        String uri = getURLPrefix() + "findCloseMatchesForTaxon/Pomatomidae";
        String response = HttpClient.httpGet(uri);
        assertThat(response, containsString("Pomatomus saltatrix"));
    }
}
