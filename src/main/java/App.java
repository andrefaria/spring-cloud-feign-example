import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.FeignClientScan;
import org.springframework.cloud.netflix.feign.FeignConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@FeignClientScan
@EnableWebMvc
@Controller
public class App extends SpringBootServletInitializer {

    @Autowired
    private GitHubClient gitHub;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/{owner}/{repo}")
    @ResponseBody
    public List<Contributor> contributors(@PathVariable String owner, @PathVariable String repo) {
        return gitHub.contributors(owner, repo);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}

