package org.mikemirten.metrics.Service.MetricCreator;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.User;
import org.mikemirten.metrics.Exception.ActionException;

public interface MetricCreator
{
    /**
     * Create new metric
     *
     * @param user owner of new metric
     * @param dto
     * @return just created metric
     * @throws ActionException
     */
    Metric create(User user, MetricDTO dto) throws ActionException;
}
