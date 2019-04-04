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

    public void delete(String id) {
        postRepository.removeById(Integer.valueOf(id));
    }
}
