package org.mikemirten.metrics.Exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ActionException extends RuntimeException
{
    /**
     * A list of errors could cause the exception
     */
    private final List<Error> errors;

    public ActionException()
    {
        super("Unknown problem occurred while action");

        errors = new ArrayList<>(0);
    }

    public ActionException(List<Error> errors)
    {
        this.errors = errors;
    }

    /**
     * Get errors
     *
     * @return A list of errors
     */
    public List<Error> getErrors()
    {
        return errors;
    }

    /**
     * An error caused the exception
     */
    public static class Error
    {
        /**
         * Path of the property caused the exception
         */
        @JsonProperty
        private final String path;

        /**
         * Error's message
         */
        @JsonProperty
        private final String message;

        public Error(String path, String message)
        {
            this.path    = path;
            this.message = message;
        }
    }
}
