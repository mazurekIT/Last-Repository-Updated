package pl.mazurekit.restfulwebservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class GithubService {
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${github.url}")
    private String url;
    private String allegroRepositories = "/users/allegro/repos?per_page=100";


    public String getLastRepository() {
        ResponseEntity<List<Repository>> repositoryResponse =
                restTemplate.exchange(this.url + this.allegroRepositories, HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
                });

        List<Repository> repositoryList = repositoryResponse.getBody();

        Optional<Repository> sorted = repositoryList.stream().sorted(new DateComper()).findFirst();
        return sorted.get().getName();

    }


}
