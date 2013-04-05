package org.eol.globi.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class TrophicControllerTest {

    private static Log LOG = LogFactory.getLog(TrophicControllerTest.class);


    @Test
    public void findPrey() throws IOException, URISyntaxException {
        String list = new TrophicController().findPreyForPredator("Homo sapiens");
        assertThat(list, Is.is(notNullValue()));
    }

    @Test
    public void findPredator() throws IOException, URISyntaxException {
        String list = new TrophicController().findPredatorForPrey("Hemiramphus brasiliensis");
        assertThat(list, Is.is(notNullValue()));
    }


    @Test
    public void findPredatorObservations() throws IOException, URISyntaxException {
        String list = new TrophicController().findPredatorObservations("Ariopsis felis");
        assertThat(list, Is.is(notNullValue()));

        list = new TrophicController().findPredatorObservations("Rattus rattus");
        assertThat(list, Is.is(notNullValue()));
    }

    @Test
    public void findPreyObservations() throws IOException, URISyntaxException {
        String list = new TrophicController().findPreyObservations("Rattus rattus");
        assertThat(list, Is.is(notNullValue()));

        list = new TrophicController().findPreyObservations("Ariopsis felis");
        LOG.info(list);
        assertThat(list, Is.is(notNullValue()));
    }

    @Test
    public void findTaxon() throws IOException, URISyntaxException {
        String list = new TrophicController().findTaxon("Homo sap");
        assertThat(list, Is.is(notNullValue()));
    }

}
