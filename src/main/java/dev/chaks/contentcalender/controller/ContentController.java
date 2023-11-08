package dev.chaks.contentcalender.controller;

import dev.chaks.contentcalender.model.Content;
import dev.chaks.contentcalender.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    //We Inject the ContentCollectionRepository into this Class
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id)
    {
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found"));
    }
}
