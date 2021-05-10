package it.euris.test.exercise.developerTestEuris.dao;

import it.euris.test.exercise.developerTestEuris.entities.Articles;
import it.euris.test.exercise.developerTestEuris.utils.BasicDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InventoryMySQL extends BasicDao implements IInventory {

    public InventoryMySQL(
            @Value("${db.address}") String dbAddress,
            @Value("${db.username}") String user,
            @Value("${db.password}") String password) {
        super(dbAddress, user, password);
    }

    /**
     * Get a full List of articles present into the database
     * @return the full list
     */
    @Override
    public List<Articles> listArticles() {
        List<Articles> list = new ArrayList<>();

        List<Map<String, String>> maps = getAll("SELECT * FROM articles");

        for (Map<String, String> map : maps) {
            Articles a = new Articles();
            a.fromMap(map);
            list.add(a);
        }
        return list;
    }

    /**
     * Get the single item with the full details
     * @param identificationcode single id of an item
     * @return
     */
    @Override
    public Articles singleArticle(int identificationcode) {
        Articles single = null;

        Map<String, String> map = getOne("SELECT * FROM articles WHERE identificationcode = ?", identificationcode);

        if (map != null){
            single = new Articles();
            single.fromMap(map);
        } else {
            System.out.println("Identification Code not Present");
        }
        return single;
    }

    /**
     * You can add a new item
     * @param article Object to let you add the item
     * @return True, if the item is successfully added, false if not
     */
    @Override
    public boolean addArticle(Articles article) {
        if (article != null){
            execute("INSERT INTO articles(name, price) VALUES (?, ?)",
                    article.getName(),
                    article.getPrice());
            return true;
        }
        return false;
    }

    /**
     * You can edit the current item
     * @param article Object edited
     * @return True if the object is not null, and process goes ok
     */
    @Override
    public boolean editArticle(Articles article) {
        if (article != null){
            execute("UPDATE articles SET name = ?, price = ? WHERE identificationcode = ?",
                    article.getName(),
                    article.getPrice(),
                    article.getIdentificationcode());
            return true;
        }
        return false;
    }

    /**
     * You can delete an item
     * @param identificationcode Id to let you find the correct one
     * @return True if the item was successfully deleted
     */
    @Override
    public boolean deleteArticles(int identificationcode) {
        if (identificationcode != 0){
            execute("DELETE FROM articles WHERE identificationcode = ?", identificationcode);
            return true;
        }
        return false;
    }
}
