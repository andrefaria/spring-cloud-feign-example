import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientScan;
import org.springframework.cloud.netflix.feign.FeignConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@FeignClientScan
@RestController
public class GitHubExample extends FeignConfiguration {

    static class Contributor {

        private String login;
        private int contributions;


        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getContributions() {
            return contributions;
        }

        public void setContributions(int contributions) {
            this.contributions = contributions;
        }

    }

    @FeignClient(value = "https://api.github.com", loadbalance = false)
    interface GitHub {

        @RequestMapping(method = RequestMethod.GET, value = "/repos/{owner}/{repo}/contributors")
        List<Contributor> contributors(@RequestParam("owner") String owner, @RequestParam("repo") String repo);

    }

    @Autowired
    private GitHub gitHub;

    @RequestMapping("/")
    public List<Contributor> home() {
        return gitHub.contributors("netflix", "hystrix");
    }

    public static void main(String[] args) {
        SpringApplication.run(GitHubExample.class, args);
    }


}

