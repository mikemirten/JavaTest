package org.mikemirten.metrics.Controller;

import org.mikemirten.metrics.Domain.Model.Metric;
import org.mikemirten.metrics.Domain.Model.User;
import org.mikemirten.metrics.Exception.NotFoundException;
import org.mikemirten.metrics.JsonDocument.JsonErrorResponse;
import org.mikemirten.metrics.JsonDocument.JsonRequest;
import org.mikemirten.metrics.JsonDocument.JsonResponse;
import org.mikemirten.metrics.Repository.UserRepository;
import org.mikemirten.metrics.Exception.ActionException;
import org.mikemirten.metrics.Service.MetricCreator.MetricDTO;
import org.mikemirten.metrics.Service.MetricCreator.MetricCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MetricController
{
    /**
     * Metric service
     */
    private final MetricCreator metricCreator;

    /**
     * Repository of users
     */
    private final UserRepository userRepository;

    @Autowired
    public MetricController(MetricCreator metricCreator, UserRepository userRepository) {
        this.metricCreator  = metricCreator;
        this.userRepository = userRepository;
    }

    /**
     * Find metrics of certain user
     */
    @GetMapping ("/users/{id}/metrics")
    public JsonResponse list(@PathVariable Integer id) throws NotFoundException
    {
        Iterable<Metric> metrics = resolveUser(id).getMetrics();

        return new JsonResponse(metrics);
    }

    /**
     * Create new metric for certain user
     *
     * @param id      ID of user going to own the metric
     * @param request JSON-Request
     * @return        JSON-Response
     */
    @PostMapping("/users/{id}/metrics")
    public JsonResponse create(@PathVariable Integer id, @RequestBody JsonRequest<MetricDTO> request)
    {
        User user = resolveUser(id);
        MetricDTO dto = request.getData();

        Metric metric;

        try {
            metric = metricCreator.create(user, dto);
        } catch (ActionException exception) {
            return new JsonErrorResponse(exception.getErrors());
        }

        return new JsonResponse(metric);
    }

    /**
     * Find user by ID if exists
     *
     * @param id
     * @return User
     * @throws NotFoundException
     */
    private User resolveUser(Integer id) throws NotFoundException
    {
        Optional<User> result = userRepository.findById(id);

        if (! result.isPresent()) {
            throw new NotFoundException("User not found by ID: " + id);
        }

        return result.get();
    }
}
