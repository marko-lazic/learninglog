package ml.markolazic.learninglog.boundary;

import ml.markolazic.learninglog.control.PostService;
import ml.markolazic.learninglog.model.Post;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.*;
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
                .add("text", post.getPostText());

        return Response.ok(builder.build().toString()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@FormParam("author") String author, @FormParam("text") String text) {
        postService.create(author, text);
        return Response.ok(author + " " + text).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") String id) {
        postService.delete(id);
        return Response.ok().build();
    }
}
