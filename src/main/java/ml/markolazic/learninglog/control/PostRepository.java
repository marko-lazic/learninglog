package ml.markolazic.learninglog.control;

import ml.markolazic.learninglog.model.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Stateless
public class PostRepository extends AbstractRepository<Post>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public PostRepository() {
        super(Post.class);
    }

    public void createPost(String author, String text) {
        Post post  = new Post(author, text);
        this.create(post);
    }

    protected PostRepository(Class<Post> entityClass) {
        super(entityClass);
    }

    @Transactional
    public void removeById(Integer id) {
        final Query namedQuery = entityManager.createNamedQuery(Post.REMOVE_BY_ID);
        namedQuery.setParameter("id", id);
        namedQuery.executeUpdate();
    }
}
