package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@SpringBootApplication
@EnableWebMvc
@Controller
@EnableFeignClients
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

