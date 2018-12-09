package org.mikemirten.metrics.JsonDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Json response with errors
 *
 * {
 *     "errors": [
 *          { ... },
 *          { ... }
 *     ]
 * }
 */
@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JsonErrorResponse extends JsonResponse
{
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<?> errors;

    public JsonErrorResponse(List<?> errors)
    {
        this.errors = errors;
    }
}
