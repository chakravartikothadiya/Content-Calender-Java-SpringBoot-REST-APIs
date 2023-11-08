package dev.chaks.contentcalender.repository;

import dev.chaks.contentcalender.model.Content;
import dev.chaks.contentcalender.model.Status;
import dev.chaks.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    //Constructor
    public ContentCollectionRepository()
    {

    }
    public List<Content> findAll()
    {
        return content;
    }

    public Optional<Content> findById(Integer id)
    {
        return content.stream().filter(c->c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content(2,
                "First Blog Post",
                "This is the first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        content.add(c);
    }
}
