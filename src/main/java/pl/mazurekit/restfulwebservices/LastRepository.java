package pl.mazurekit.restfulwebservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LastRepository {
    @Autowired
    GithubService githubService;


    @GetMapping("/lastrepo")
    public String lastRepo() {
        return githubService.getLastRepository();
    }
}
