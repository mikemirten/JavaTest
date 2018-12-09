package org.mikemirten.metrics.Controller;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.MetricValue;
import org.mikemirten.metrics.Exception.ActionException;
import org.mikemirten.metrics.Exception.NotFoundException;
import org.mikemirten.metrics.JsonDocument.JsonErrorResponse;
import org.mikemirten.metrics.JsonDocument.JsonRequest;
import org.mikemirten.metrics.JsonDocument.JsonResponse;
import org.mikemirten.metrics.Repository.MetricRepository;
import org.mikemirten.metrics.Service.MetricValueCreator.MetricValueCreator;
import org.mikemirten.metrics.Service.MetricValueCreator.MetricValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MetricValueController
{
    /**
     * Repository of metrics
     */
    private final MetricRepository metricRepository;

    /**
     * Values creator
     */
    private final MetricValueCreator metricValueCreator;

    @Autowired
    public MetricValueController(MetricRepository metricRepository, MetricValueCreator metricValueCreator)
    {
        this.metricRepository   = metricRepository;
        this.metricValueCreator = metricValueCreator;
    }

    /**
     * Get values of certain metric
     *
     * @param  id
     * @return JsonResponse
     */
    @GetMapping("/metrics/{id}/values")
    public JsonResponse list(@PathVariable Integer id)
    {
        Iterable<MetricValue> values = resolveMetric(id).getValues();

        return new JsonResponse(values);
    }

    /**
     * Create new value for certain metric
     *
     * @param id ID of metric
     * @param request
     * @return JsonResponse
     */
    @PostMapping("/metrics/{id}/values")
    public JsonResponse create(@PathVariable Integer id, @RequestBody JsonRequest<MetricValueDTO> request)
    {
        Metric metric = resolveMetric(id);
        MetricValueDTO dto = request.getData();

        MetricValue value;

        try {
            value = metricValueCreator.create(metric, dto);
        } catch (ActionException exception) {
            return new JsonErrorResponse(exception.getErrors());
        }

        return new JsonResponse(value);
    }

    /**
     * Find metric by ID if exists
     *
     * @param id
     * @return Metric
     * @throws NotFoundException
     */
    private Metric resolveMetric(Integer id) throws NotFoundException
    {
        Optional<Metric> result = metricRepository.findById(id);

        if (! result.isPresent()) {
            throw new NotFoundException("Metric not found by ID: " + id);
        }

        return result.get();
    }
}
