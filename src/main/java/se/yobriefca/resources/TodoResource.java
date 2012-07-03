package se.yobriefca.resources;

import com.google.common.collect.Lists;
import com.yammer.dropwizard.jersey.params.LongParam;
import se.yobriefca.core.Todo;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {
    private static final ArrayList<Todo> todos = Lists.newArrayList();

    @GET
    public Collection<Todo> list() {
        return todos;
    }

    @GET
    @Path("/{id}")
    public Todo single(@PathParam("id") final LongParam id){
        for (Todo element: todos) {
            if(element.getId() == id.get()){
                return element;
            }
        }

        return null;
    }

    @POST
    public Todo add(@Valid Todo todo){
        todos.add(todo);
        return todo;
    }

    @DELETE
    @Path("/{id}")
    public Todo delete(@PathParam("id") final LongParam id){
        Todo todo = null;
        List<Todo> todoCopy = Lists.newArrayList(todos);

        todos.clear();

        // loop past all items in the list and replace the changed one
        for (Todo element: todoCopy) {
            if(element.getId() != id.get()){
                todos.add(element);
            }else{
                todo = element;
            }
        }

        return todo;
    }
}