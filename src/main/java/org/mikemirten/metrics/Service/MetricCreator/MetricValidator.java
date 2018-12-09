package org.mikemirten.metrics.Service.MetricCreator;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.User;
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
@Qualifier("metricCreator.validation")
public class MetricValidator implements MetricCreator
{
    /**
     * Next metric creator
     */
    private final MetricCreator metricCreator;

    /**
     * Validator
     */
    private final Validator validator;

    /**
     * Validation helper
     */
    private final ValidationHelper validationHelper;

    @Autowired
    public MetricValidator(MetricCreator metricCreator, Validator validator, ValidationHelper validationHelper)
    {
        this.metricCreator    = metricCreator;
        this.validator        = validator;
        this.validationHelper = validationHelper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Metric create(User user, MetricDTO dto) throws ActionException
    {
        Set<ConstraintViolation<MetricDTO>> violations = validator.validate(dto);

        if (! violations.isEmpty()) {
            List<ActionException.Error> errors = validationHelper.processViolations(violations);

            throw new ActionException(errors);
        }

        return metricCreator.create(user, dto);
    }
}
