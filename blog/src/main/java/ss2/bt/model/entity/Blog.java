package ss2.bt.model.entity;

import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "blogs")
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String image;
    private Date creationDate;

    public Blog() {
    }

    public Blog(Long id, String title, String content, String image, Date creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
