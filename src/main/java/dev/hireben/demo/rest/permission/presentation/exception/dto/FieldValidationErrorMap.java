package dev.hireben.demo.rest.permission.presentation.exception.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonPropertyOrder({ "field", "message" })
public class FieldValidationErrorMap {

  // ---------------------------------------------------------------------------//
  // Fields
  // ---------------------------------------------------------------------------//

  private final String field;
  private final String message;

}
