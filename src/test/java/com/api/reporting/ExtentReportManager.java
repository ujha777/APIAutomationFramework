package com.api.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports setupSparkReporter(String reportName) {
        if (extentReports == null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//" + reportName);
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("API Test Reports");
            extentSparkReporter.config().setReportName("REST API Test Result");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
        return extentReports;
    }

    public static void createExtentTest(String testName) {
        if (extentReports != null) {
            ExtentTest test = extentReports.createTest(testName);
            extentTest.set(test);
        } else {
            throw new IllegalStateException("ExtentReports is not initialized. Call setupSparkReporter() first.");
        }
    }

    public static void logRequest(FilterableRequestSpecification requestSpec) {
        StringBuilder requestDetails = new StringBuilder();
        requestDetails.append("<pre>");
        requestDetails.append("Request Method: ").append(requestSpec.getMethod()).append("\n");
        requestDetails.append("Request URL: ").append(requestSpec.getBaseUri()).append("\n");
        requestDetails.append("Request Header: ").append("\n");

        for (Header header : requestSpec.getHeaders()) {
            requestDetails.append(" ").append(header.getName()).append(": ").append(header.getValue()).append("\n");
        }

        if (requestSpec.getBody() != null) {
            requestDetails.append("Request Body: ").append("\n");
            requestDetails.append(requestSpec.getBody().toString());
        }
        requestDetails.append("</pre>");
        extentTest.get().log(Status.INFO, "Request Details: " + requestDetails.toString());
    }

    public static void logResponse(Response response) {
        StringBuilder responseDetails = new StringBuilder();
        responseDetails.append("<pre>");
        responseDetails.append("Request Status: ").append(response.getStatusCode()).append("\n");
        responseDetails.append("Request Header: ").append("\n");

        for (Header header : response.getHeaders()) {
            responseDetails.append(" ").append(header.getName()).append(": ").append(header.getValue()).append("\n");
        }

        responseDetails.append("Response Body: ").append("\n");
        responseDetails.append(response.getBody().prettyPrint());

        responseDetails.append("</pre>");
        extentTest.get().log(Status.INFO, "Response Details: " + responseDetails.toString());

        if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
            extentTest.get().pass("Request completed successfully");
        } else {
            extentTest.get().fail("Request failed with status code: " + response.getStatusCode());
        }
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
