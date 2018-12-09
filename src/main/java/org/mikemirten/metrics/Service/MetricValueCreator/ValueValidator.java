package org.mikemirten.metrics.Service.MetricValueCreator;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.mikemirten.metrics.Exception.ActionException;
import org.mikemirten.metrics.Service.Utils.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@Primary
@Qualifier("metricValueCreator.validation")
public class ValueValidator implements MetricValueCreator
{
    /**
     * Next metric creator
     */
    private final MetricValueCreator valueCreator;

    /**
     * Validator
     */
    private final Validator validator;

    /**
     * Validation helper
     */
    private final ValidationHelper validationHelper;

    @Autowired
    public ValueValidator(MetricValueCreator valueCreator, Validator validator, ValidationHelper validationHelper)
    {
        this.valueCreator     = valueCreator;
        this.validator        = validator;
        this.validationHelper = validationHelper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetricValue create(Metric metric, MetricValueDTO dto) throws ActionException
    {
        Set<ConstraintViolation<MetricValueDTO>> violations = validator.validate(dto);

        if (! violations.isEmpty()) {
            List<ActionException.Error> errors = validationHelper.processViolations(violations);

            throw new ActionException(errors);
        }

        return valueCreator.create(metric, dto);
    }
}
