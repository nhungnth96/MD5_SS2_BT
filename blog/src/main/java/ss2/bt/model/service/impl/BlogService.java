package ss2.bt.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ss2.bt.model.dto.BlogDto;
import ss2.bt.model.entity.Blog;
import ss2.bt.model.repository.IBlogRepository;
import ss2.bt.model.service.IBlogService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {}

    private String uploadPath = "C:\\Users\\ADMIN\\Desktop\\blog\\src\\main\\webapp\\WEB-INF\\upload\\";
    @Override
    public void save(BlogDto blogDto) {
        String imageFile = null;
        if(!(blogDto.getImage().isEmpty())){
            imageFile = blogDto.getImage().getOriginalFilename();
            try {
                FileCopyUtils.copy(blogDto.getImage().getBytes(),new File(uploadPath+imageFile));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Blog blog = new Blog(blogDto.getId(),
                blogDto.getTitle(),blogDto.getContent(),
                imageFile,blogDto.getCreationDate());
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
