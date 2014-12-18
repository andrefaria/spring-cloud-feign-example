import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClientScan;
import org.springframework.cloud.netflix.feign.FeignConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@FeignClientScan
@RestController
public class App {

    @Autowired
    private GitHubClient gitHub;

    @RequestMapping("/")
    public String home() {
        return "Please provide repository owner and repository name - ex: http://localhost:8080/netflix/feign";
    }

    @RequestMapping("/{owner}/{repo}")
    public List<Contributor> contributors(@PathVariable String owner, @PathVariable String repo) {
        return gitHub.contributors(owner, repo);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}

