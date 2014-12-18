import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Named;
import java.util.List;

@Configuration
@EnableAutoConfiguration
public class GitHubExample extends FeignConfiguration {

    static class Contributor {
        String login;
        int contributions;
    }

    interface GitHub {
        @RequestMapping(method = RequestMethod.GET, value = "/repos/{owner}/{repo}/contributors")
        List<Contributor> contributors(@PathVariable("owner") String owner, @PathVariable("repo") String repo);
    }

    @Bean
    public GitHub storeClient() {
        return loadBalance(GitHub.class, "https://api.github.com");
    }

    public static void main(String[] args) {
        SpringApplication.run(GitHubExample.class, args);
    }


}

