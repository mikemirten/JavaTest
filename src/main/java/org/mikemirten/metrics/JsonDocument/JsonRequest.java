package org.mikemirten.metrics.JsonDocument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Json request document
 *
 * {
 *     "data": { ... }
 * }
 */
public class JsonRequest<T>
{
    private final T data;

    public JsonRequest(@JsonProperty("data") T data)
    {
        this.data = data;
    }

    /**
     * Get data
     */
    public T getData()
    {
        return data;
    }
}
