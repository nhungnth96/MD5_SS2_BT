package ss2.bt.model.service;

import ss2.bt.model.dto.BlogDto;
import ss2.bt.model.entity.Blog;

import java.util.List;

public interface IBlogService {
        List<Blog> findAll();
        Blog findById (Long id);
        void save(Blog blog);

        void save(BlogDto blogDto);

        void delete(Long id);
}
