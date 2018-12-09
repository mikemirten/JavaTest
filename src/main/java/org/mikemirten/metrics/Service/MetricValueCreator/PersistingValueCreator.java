package org.mikemirten.metrics.Service.MetricValueCreator;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.mikemirten.metrics.Exception.ActionException;
import org.mikemirten.metrics.Repository.MetricValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("metricValueCreator.persisting")
public class PersistingValueCreator implements MetricValueCreator
{
    /**
     * Repository of metric-values
     */
    private final MetricValueRepository valueRepository;

    @Autowired
    public PersistingValueCreator(MetricValueRepository valueRepository)
    {
        this.valueRepository = valueRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MetricValue create(Metric metric, MetricValueDTO dto) throws ActionException
    {
        MetricValue value = new MetricValue(metric, dto.getValue());

        valueRepository.save(value);

        return value;
    }
}
