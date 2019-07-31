package pl.mazurekit.restfulwebservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    private Long id;
    private String name;
    @JsonProperty("updeted_at")
    private Instant updatedAt;
    @JsonProperty("pushed_at")
    private Instant pushedAt;


    public Repository() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(Instant pushedAt) {
        this.pushedAt = pushedAt;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedAt=" + updatedAt +
                ", pushedAt=" + pushedAt +
                '}';
    }
}
