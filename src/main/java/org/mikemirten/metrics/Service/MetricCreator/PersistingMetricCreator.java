package org.mikemirten.metrics.Service.MetricCreator;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.User;
import org.mikemirten.metrics.Repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("metricCreator.persisting")
public class PersistingMetricCreator implements MetricCreator
{
    /**
     * Repository of metrics
     */
    private final MetricRepository metricRepository;

    @Autowired
    public PersistingMetricCreator(MetricRepository metricRepository)
    {
        this.metricRepository = metricRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Metric create(User user, MetricDTO dto)
    {
        Metric metric = new Metric(user, dto.getTitle());

        metricRepository.save(metric);

        return metric;
    }
}
