package net.cafesilencio.demo.di;

import net.cafesilencio.demo.TestDemoApp;
import net.cafesilencio.demo.di.ApplicationModule;
import net.cafesilencio.demo.domain.GetGitRepos;
import net.cafesilencio.demo.model.GitRepoRecord;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Seth Bourget on 3/31/18.
 */

@Module
public class TestApplicationModule extends ApplicationModule {

    public TestApplicationModule(TestDemoApp app) {
        super(app);
    }

    @Provides
    public GetGitRepos provideGetGitRepos() {
        GetGitRepos getGitRepos = mock(GetGitRepos.class);

        GitRepoRecord gr1 = new GitRepoRecord();
        gr1.setName("repo ABC");
        gr1.setHtmlUrl("repo ABC url");

        GitRepoRecord gr2 = new GitRepoRecord();
        gr2.setName("repo LMNOP");
        gr2.setHtmlUrl("repo LMNOP url");

        GitRepoRecord gr3 = new GitRepoRecord();
        gr3.setName("repo XYZ");
        gr3.setHtmlUrl("repo XYZ url");

        List<GitRepoRecord> items = Arrays.asList(gr1, gr2, gr3);

        when(getGitRepos.call()).thenReturn(Single.just(items));

        return getGitRepos;
    }
}
