package ss2.bt.model.service;

import ss2.bt.model.entity.Feedback;
import ss2.bt.model.dto.FeedbackDto;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();
    Feedback findById(Long id);
    void save(FeedbackDto feedbackDto);
    void delete(Long id);
    void like(Long id);
}
