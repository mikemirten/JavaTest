package org.mikemirten.metrics.JsonDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Json response document
 *
 * {
 *     "data": { ... }
 * }
 */
@ResponseBody
public class JsonResponse
{
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Object data;

    /**
     * No data case
     */
    public JsonResponse()
    {
        this.data = null;
    }

    /**
     * Any kind of data case
     *
     * @param data
     */
    public JsonResponse(Object data)
    {
        this.data = data;
    }
}
