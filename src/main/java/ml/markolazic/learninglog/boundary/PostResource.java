package ml.markolazic.learninglog.boundary;

import ml.markolazic.learninglog.control.PostService;
import ml.markolazic.learninglog.model.Post;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("post")
public class PostResource {

    @Inject
    PostService postService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPosts() {
        List<Post> posts = postService.findAll();
        return Response.ok(posts.toString()).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") final Long id){
        final Post post = postService.find(id);

        final JsonObjectBuilder builder =
                Json.createObjectBuilder()
                .add("id", post.getId())
                .add("author", post.getAuthor())
                .add("text", post.getText());

        return Response.ok(builder.build().toString()).build();
    }

    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@FormParam("author") String author, @FormParam("text") String text) {
        postService.create(author, text);
        return Response.ok(author + " " + text).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") String id) {
        Post post = postService.delete(id);
        return Response.ok(post).build();
    }


}
