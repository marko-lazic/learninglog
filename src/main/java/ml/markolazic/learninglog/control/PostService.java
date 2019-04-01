package ml.markolazic.learninglog.control;

import ml.markolazic.learninglog.model.Post;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PostService {

    @Inject
    private PostRepository postRepository;

    private List<Post> posts;

    @PostConstruct
    private void init() {
        posts = new ArrayList<>();

        postRepository.create(new Post("Makro", "hello world."));
        postRepository.create(new Post("Makro", "Tea is getting ready!"));
        postRepository.create(new Post("Makro", "Microservices devoxx converence"));
        postRepository.create(new Post("Makro", "Works like heaven on java 11"));
        postRepository.create(new Post("Makro", "Adam Bien was here."));

    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post find(Long id) {
        return postRepository.find(id);
    }

    public void create(String author, String text) {
        postRepository.create(new Post(author, text));
    }

    public void create(Post post) {
        postRepository.create(post);
    }

    public Post delete(String id) {
        return postRepository.removeById(id);
    }
}
