package se.yobriefca;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;
import se.yobriefca.resources.TodoResource;

public class TodoService extends Service<TodoConfiguration> {
    public static void main(String[] args) throws Exception {
        new TodoService().run(args);
    }

    private TodoService() {
        super("todo");

        addBundle(new AssetsBundle("/assets", "/"));
        addBundle(new AssetsBundle("/public", "/public/"));
    }

    @Override
    protected void initialize(TodoConfiguration configuration, Environment environment) {
        environment.addResource(new TodoResource());
    }
}
