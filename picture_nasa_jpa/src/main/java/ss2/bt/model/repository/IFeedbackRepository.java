package ss2.bt.model.repository;


import ss2.bt.model.entity.Feedback;


import java.util.List;

public interface IFeedbackRepository {
    List<Feedback> findAll();
    Feedback findById(Long id);
    void save(Feedback feedback);
    void delete(Long id);
}
