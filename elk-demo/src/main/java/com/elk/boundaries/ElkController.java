package com.elk.boundaries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ElkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElkController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/elk")
    public String helloWorld() {
        final String response = "Welcome: " + new Date();
        LOGGER.info("elk endpoint :)");
        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured....");
        } catch (final Exception e) {
            e.printStackTrace();
            LOGGER.error("alv:", e);

            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            LOGGER.error("Exception - " + stackTrace);
            response = stackTrace;
        }
        return response;
    }

}
