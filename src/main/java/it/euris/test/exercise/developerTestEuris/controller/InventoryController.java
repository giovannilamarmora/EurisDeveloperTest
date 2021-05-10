package it.euris.test.exercise.developerTestEuris.controller;

import it.euris.test.exercise.developerTestEuris.dao.IInventory;
import it.euris.test.exercise.developerTestEuris.entities.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private IInventory invent;

    @GetMapping
    public List<Articles> get() {
        return invent.listArticles();
    }

    @GetMapping("/{identificationcode}")
    public Articles get(@PathVariable int identificationcode) {
        return invent.singleArticle(identificationcode);
    }

    @PostMapping
    public String post(@RequestBody Articles articles) {
        String message = "";
        if (invent.addArticle(articles)) {
            message = "{ \"message\" : \"Done It\" }";
        } else {
            message = "{ \"message\" : \"Error during Post Process\" }";
        }
        return message;
    }

    @PutMapping
    public String put(@RequestBody Articles articles){
        String message = "";
        if (invent.editArticle(articles)) {
            message = "{ \"message\" : \"Done It\" }";
        } else {
            message = "{ \"message\" : \"Error during Put Process\" }";
        }
        return message;
    }

    @DeleteMapping("/{identificationcode}")
    public String delete(@PathVariable int identificationcode) {
        String message = "";
        if (invent.deleteArticles(identificationcode)) {
            message = "{ \"message\" : \"Done It\" }";
        } else {
            message = "{ \"message\" : \"Error during Delete Process\" }";
        }
        return message;
    }
}
