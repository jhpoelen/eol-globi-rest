package org.eol.globi.server;

import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PingController {

    @Autowired
    EmbeddedGraphDatabase graphDb;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public String ping() {
        return "pong";
    }

    public String getInfo() {
        return graphDb.getKernelData().version().toString();
    }

}