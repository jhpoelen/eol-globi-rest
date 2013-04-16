package org.eol.globi.server;

import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class PingControllerTest extends SpringTestBase {

    @Autowired
    private PingController controller;

    @Test
    public void checkConfig() throws IOException {
        assertThat(controller, Is.is(notNullValue()));
    }

    @Test
    public void checkVersion() throws IOException {
        assertThat(controller.getInfo(), containsString("Neo4j"));
    }
}
