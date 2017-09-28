package com.example.uberv.dagger2demo.di.modules;

import com.example.uberv.dagger2demo.di.annotations.UserScope;
import com.example.uberv.dagger2demo.models.Repository;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import timber.log.Timber;

@Module
public class GithubModule {

    public interface GitHubApiInterface {
        @GET("/org/{orgName}/repos")
        Call<ArrayList<Repository>> getRepository(@Path("orgName") String orgName);
    }

    @Provides
    @UserScope // needs to be consistent with the component scope
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        Timber.d("Providing GitHubApiInterface");
        return retrofit.create(GitHubApiInterface.class);
    }
}
