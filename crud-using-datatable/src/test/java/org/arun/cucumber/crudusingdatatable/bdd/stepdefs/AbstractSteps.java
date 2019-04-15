package org.arun.cucumber.crudusingdatatable.bdd.stepdefs;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.arun.cucumber.crudusingdatatable.bdd.CucumberTestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * Class that abstract test context management and REST API invocation.
 *
 */
public class AbstractSteps {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractSteps.class);

  private CucumberTestContext CONTEXT = CucumberTestContext.CONTEXT;

  @LocalServerPort
  private int port;

  protected String baseUrl() {
    return "http://localhost:" + port;
  }

  protected CucumberTestContext testContext() {
    return CONTEXT;
  }

  protected void executePost(String apiPath) {
    executePost(apiPath, null, null);
  }

  protected void executePost(String apiPath, Map<String, String> pathParams) {
    executePost(apiPath, pathParams, null);
  }

  protected void executePost(String apiPath, Map<String, String> pathParams, Map<String, String> queryParamas) {
    final RequestSpecification request = CONTEXT.getRequest();
    final Object payload = CONTEXT.getPayload();
    final String url = baseUrl() + apiPath;

    setPayload(request, payload);
    setQueryParams(pathParams, request);
    setPathParams(queryParamas, request);

    Response response = request.accept(ContentType.JSON)
      .log()
      .all()
      .post(url);

    logResponse(response);

    CONTEXT.setResponse(response);
  }

  protected void executeMultiPartPost(String apiPath) {
    final RequestSpecification request = CONTEXT.getRequest();
    final Object payload = CONTEXT.getPayload();
    final String url = baseUrl() + apiPath;

    Response response = request.multiPart("fuelTransfer", payload, "application/json")
      .log()
      .all()
      .post(url);

    logResponse(response);
    CONTEXT.setResponse(response);
  }

  protected void executeDelete(String apiPath) {
    executeDelete(apiPath, null, null);
  }

  protected void executeDelete(String apiPath, Map<String, String> pathParams) {
    executeDelete(apiPath, pathParams, null);
  }

  protected void executeDelete(String apiPath, Map<String, String> pathParams, Map<String, String> queryParams) {
    final RequestSpecification request = CONTEXT.getRequest();
    final Object payload = CONTEXT.getPayload();
    final String url = baseUrl() + apiPath;

    setPayload(request, payload);
    setQueryParams(pathParams, request);
    setPathParams(queryParams, request);

    Response response = request.accept(ContentType.JSON)
      .log()
      .all()
      .delete(url);

    logResponse(response);
    CONTEXT.setResponse(response);
  }

  protected void executePut(String apiPath) {
    executePut(apiPath, null, null);
  }

  protected void executePut(String apiPath, Map<String, String> pathParams) {
    executePut(apiPath, pathParams, null);
  }

  protected void executePut(String apiPath, Map<String, String> pathParams, Map<String, String> queryParams) {
    final RequestSpecification request = CONTEXT.getRequest();
    final Object payload = CONTEXT.getPayload();
    final String url = baseUrl() + apiPath;

    setPayload(request, payload);
    setQueryParams(pathParams, request);
    setPathParams(queryParams, request);

    Response response = request.accept(ContentType.JSON)
      .log()
      .all()
      .put(url);

    logResponse(response);
    CONTEXT.setResponse(response);
  }

  protected void executePatch(String apiPath) {
    executePatch(apiPath, null, null);
  }

  protected void executePatch(String apiPath, Map<String, String> pathParams) {
    executePatch(apiPath, pathParams, null);
  }

  protected void executePatch(String apiPath, Map<String, String> pathParams, Map<String, String> queryParams) {
    final RequestSpecification request = CONTEXT.getRequest();
    final Object payload = CONTEXT.getPayload();
    final String url = baseUrl() + apiPath;

    setPayload(request, payload);
    setQueryParams(pathParams, request);
    setPathParams(queryParams, request);

    Response response = request.accept(ContentType.JSON)
      .log()
      .all()
      .patch(url);

    logResponse(response);
    CONTEXT.setResponse(response);
  }

  protected void executeGet(String apiPath) {
    executeGet(apiPath, null, null);
  }

  protected void executeGet(String apiPath, Map<String, String> pathParams) {
    executeGet(apiPath, pathParams, null);
  }

  protected void executeGet(String apiPath, Map<String, String> pathParams, Map<String, String> queryParams) {
    final RequestSpecification request = CONTEXT.getRequest();
    final String url = baseUrl() + apiPath;

    setQueryParams(pathParams, request);
    setPathParams(queryParams, request);

    Response response = request.accept(ContentType.JSON)
      .log()
      .all()
      .get(url);

    logResponse(response);
    CONTEXT.setResponse(response);
  }

  private void logResponse(Response response) {
    response.then()
      .log()
      .all();
  }

  private void setPathParams(Map<String, String> queryParamas, RequestSpecification request) {
    if (null != queryParamas) {
      request.queryParams(queryParamas);
    }
  }

  private void setQueryParams(Map<String, String> pathParams, RequestSpecification request) {
    if (null != pathParams) {
      request.pathParams(pathParams);
    }
  }

  private void setPayload(RequestSpecification request, Object payload) {
    if (null != payload) {
      request.contentType(ContentType.JSON)
        .body(payload);
    }
  }

}
