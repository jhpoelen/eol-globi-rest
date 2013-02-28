package org.eol.globi.server;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class PredatorControllerTest {

    @Test
    public void findPrey() throws IOException, URISyntaxException {
        String list = new PredatorController().listPreyForPredator("Homo sapiens");
        assertThat(list, Is.is(notNullValue()));
    }

    @Test
    public void findPredator() throws IOException, URISyntaxException {
        String list = new PredatorController().listPreyForPredator("Hemiramphus brasiliensis");
        assertThat(list, Is.is(notNullValue()));
    }

}
