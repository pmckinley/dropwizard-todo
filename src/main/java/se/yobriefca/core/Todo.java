package se.yobriefca.core;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.concurrent.atomic.AtomicLong;

public class Todo {

    // Not So Universally Unique!
    private static final AtomicLong NSUUID = new AtomicLong();

    @JsonProperty
    private final Long id;

    @NotEmpty
    @JsonProperty
    private final String content;

    @JsonCreator
    public Todo(@JsonProperty("content") String content) {
        this.id = NSUUID.incrementAndGet();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Long getId(){
        return id;
    }

}