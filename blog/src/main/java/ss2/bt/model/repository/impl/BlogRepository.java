package ss2.bt.model.repository.impl;

import org.springframework.stereotype.Repository;
import ss2.bt.model.entity.Blog;
import ss2.bt.model.repository.IBlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b order by b.creationDate desc ", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b where  b.id=:id", Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId()==null){
            entityManager.persist(blog);
        } else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));

    }
}
