package ss2.bt.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class BlogDto {
    private Long id;
    private String title;
    private String content;
    private MultipartFile image;
    private Date creationDate;

    public BlogDto() {
    }

    public BlogDto(Long id, String title, String content, MultipartFile image, Date creationDate) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
