package it.euris.test.exercise.developerTestEuris.dao;

import it.euris.test.exercise.developerTestEuris.entities.Articles;

import java.util.List;

public interface IInventory {

    /**
     * Get a full List of articles present into the database
     * @return the full list
     */
    List<Articles> listArticles();

    /**
     * Get the single item with the full details
     * @param identificationcode single id of an item
     * @return
     */
    Articles singleArticle(int identificationcode);

    /**
     * You can add a new item
     * @param article Object to let you add the item
     * @return True, if the item is successfully added, false if not
     */
    boolean addArticle(Articles article);

    /**
     * You can edit the current item
     * @param article Object edited
     * @return True if the object is not null, and process goes ok
     */
    boolean editArticle(Articles article);

    /**
     * You can delete an item
     * @param identificationcode Id to let you find the correct one
     * @return True if the item was successfully deleted
     */
    boolean deleteArticles(int identificationcode);
}
