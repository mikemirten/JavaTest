package org.mikemirten.metrics.Service.Utils;

import org.mikemirten.metrics.Exception.ActionException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ValidationHelper
{
    /**
     * Process validator's violations into a list of "action errors".
     *
     * @param violations
     * @return
     */
    public <T> List<ActionException.Error> processViolations(Set<ConstraintViolation<T>> violations)
    {
        ArrayList<ActionException.Error> list = new ArrayList<>(violations.size());

        for (ConstraintViolation<T> violation: violations) {
            list.add(new ActionException.Error(
                violation.getPropertyPath().toString(),
                violation.getMessage()
            ));
        }

        return list;
    }
}
