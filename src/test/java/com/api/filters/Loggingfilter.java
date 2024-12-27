package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.reporting.ExtentReportManager;
import com.aventstack.extentreports.Status;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class Loggingfilter implements Filter {

    private static final Logger logger = LogManager.getLogger(Loggingfilter.class);

    public Loggingfilter() {
        ExtentReportManager.setupSparkReporter("report.html");
        ExtentReportManager.createExtentTest("API Test");
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec); // Request is going to be executed
        logResponse(response);
        ExtentReportManager.flushReport();
        return response; // Test for assertion
    }

    public void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("BASE URI: " + requestSpec.getBaseUri());
        logger.info("Request Header: " + requestSpec.getHeaders());
        logger.info("Request Payload: " + requestSpec.getBody());

        if (requestSpec != null) {
            ExtentReportManager.logRequest(requestSpec);
            ExtentReportManager.getTest().log(Status.INFO, "BASE URI: " + requestSpec.getBaseUri());
            ExtentReportManager.getTest().log(Status.INFO, "Request Header: " + requestSpec.getHeaders());
            ExtentReportManager.getTest().log(Status.INFO, "Request Payload: " + requestSpec.getBody());
        }
    }

    public void logResponse(Response response) {
        logger.info("STATUS CODE: " + response.getStatusCode());
        logger.info("Response Header: " + response.headers());
        logger.info("Response Body: " + response.getBody().prettyPrint());

        if (response != null) {
            ExtentReportManager.logResponse(response);
            ExtentReportManager.getTest().log(Status.INFO, "STATUS CODE: " + response.getStatusCode());
            ExtentReportManager.getTest().log(Status.INFO, "Response Header: " + response.headers());
            ExtentReportManager.getTest().log(Status.INFO, "Response Body: " + response.getBody().prettyPrint());
        }
    }
}
