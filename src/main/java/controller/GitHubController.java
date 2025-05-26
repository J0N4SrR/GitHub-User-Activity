package controller;

import client.GitHubClient;
import com.organizacao.GitHubUserActivity.GitHubUserActivityApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GitHubController {
    private GitHubClient gitHubClient;
    public GitHubController(GitHubClient gitHubClient){
        this.gitHubClient = gitHubClient;
    }

    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponse>> listRepos(){
        var repos = gitHubClient.listRepos(
                token: "",
                apiVersion: null,
                visibility: "public"
        )
        return ResponseEntity.ok(repos);
    }


}
