package ml.markolazic.learninglog.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.config.PropertyVisibilityStrategy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Entity
@NamedQueries({
        @NamedQuery(name = Post.FIND_ALL, query = "select p from Post p"),
        @NamedQuery(name = Post.REMOVE_BY_ID, query = "delete from Post p where p.id = :id")
})
public class Post {

    public static final String FIND_ALL = "findAll";
    public static final String REMOVE_BY_ID = "removeById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonbProperty("author")
    private String author;

    @JsonbProperty("text")
    private String postText;

    public Post() {
    }

    public Post(String author, String postText) {
        this.author = author;
        this.postText = postText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String text) {
        this.postText = text;
    }

    @Override
    public String toString() {
        return toJsonString();
    }

    public String toJsonString() {
        JsonbConfig config = new JsonbConfig().withPropertyVisibilityStrategy(new PropertyVisibilityStrategy() {
            @Override
            public boolean isVisible(Field field) {
                return true;
            }

            @Override
            public boolean isVisible(Method method) {
                return false;
            }
        });
        return JsonbBuilder.newBuilder().withConfig(config).build().toJson(this);
    }

    public JsonObject toJsonObject() {

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                .add("author", author)
                .add("text", postText);
        return objectBuilder.build();
    }
}
