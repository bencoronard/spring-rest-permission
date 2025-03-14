package dev.hireben.demo.rest.permission.infrastructure.configuration;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.hireben.demo.rest.permission.infrastructure.utility.EnvironmentUtil;
import dev.hireben.demo.rest.permission.infrastructure.utility.LogFormatUtil;
import dev.hireben.demo.rest.permission.infrastructure.utility.RequestUtil;
import dev.hireben.demo.rest.permission.infrastructure.utility.ErrorSeverityLevel;
import dev.hireben.demo.rest.permission.presentation.dto.ResponseErrorAttributes;
import dev.hireben.demo.rest.permission.presentation.utility.RequestAttributeKey;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorAttributesConfig extends DefaultErrorAttributes {

  // ---------------------------------------------------------------------------//
  // Dependencies
  // ---------------------------------------------------------------------------//

  private final ObjectMapper objectMapper;
  private final EnvironmentUtil environment;

  // ---------------------------------------------------------------------------//
  // Methods
  // ---------------------------------------------------------------------------//

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

    Throwable error = super.getError(webRequest);
    String errorMsg = super.getMessage(webRequest, error);
    String errorClassName = error == null ? "ServletException" : error.getClass().getName();

    String errorCode = RequestUtil.extractAttribute(webRequest, RequestAttributeKey.ERR_RESP_CODE, String.class)
        .orElse(error == null ? "1000" : "9999");
    String respMsg = RequestUtil.extractAttribute(webRequest, RequestAttributeKey.ERR_RESP_MSG, String.class)
        .orElse(error == null ? errorMsg : "Unhandled error at server side");
    Object respData = RequestUtil.extractAttribute(webRequest, RequestAttributeKey.ERR_RESP_DATA, Object.class)
        .orElse(null);

    ErrorSeverityLevel severity = RequestUtil
        .extractAttribute(webRequest, RequestAttributeKey.ERR_SEVERITY, ErrorSeverityLevel.class)
        .orElse(error == null ? ErrorSeverityLevel.LOW : ErrorSeverityLevel.HIGH);
    String traceId = RequestUtil.extractAttribute(webRequest, RequestAttributeKey.TRACE_ID, String.class)
        .orElse("null");

    String logString = LogFormatUtil.formatTraceLog(traceId,
        LogFormatUtil.formatErrorLog(errorClassName, errorCode, errorMsg));

    switch (severity) {
      case HIGH -> log.error(logString);
      case MEDIUM -> log.warn(logString);
      case LOW -> log.info(logString);
    }

    ResponseErrorAttributes<Object> errorAttributes = ResponseErrorAttributes.<Object>builder()
        .code(1000)
        .exception(environment.isDev() ? errorClassName : null)
        .message(respMsg)
        .data(respData != null ? respData : environment.isDev() ? errorMsg : null)
        .build();

    return objectMapper.convertValue(errorAttributes, new TypeReference<Map<String, Object>>() {
    });
  }

}
