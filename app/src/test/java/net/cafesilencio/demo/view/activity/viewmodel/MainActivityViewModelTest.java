package net.cafesilencio.demo.view.activity.viewmodel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;

import net.cafesilencio.demo.BuildConfig;
import net.cafesilencio.demo.RxSchedulersOverrideRule;
import net.cafesilencio.demo.TestDemoApp;
import net.cafesilencio.demo.domain.GetGitRepos;
import net.cafesilencio.demo.model.GitRepoRecord;
import net.cafesilencio.demo.view.Response;
import net.cafesilencio.demo.view.Status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

/**
 * Created by Seth Bourget on 4/14/18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TestDemoApp.class)
public class MainActivityViewModelTest {


    @Rule
    public RxSchedulersOverrideRule rxSchedRule = new RxSchedulersOverrideRule();

    private GetGitRepos getGitRepos;
    private MainActivityViewModel mainActivityViewModel;

    @Before
    public void setUp() {
        getGitRepos = mock(GetGitRepos.class);
        mainActivityViewModel = new MainActivityViewModel(getGitRepos);
    }

    @Test
    public void loadRepos() {
        ArgumentCaptor<Response<List<GitRepoRecord>>> argumentCaptor = ArgumentCaptor.forClass(Response.class);
        Observer<Response<List<GitRepoRecord>>> observer = mock(Observer.class);
        mainActivityViewModel.getGitReposeLiveData().observeForever(observer);
        List<GitRepoRecord> items = Arrays.asList(new GitRepoRecord(), new GitRepoRecord());

        when(getGitRepos.call()).thenReturn(Single.just(items));

        mainActivityViewModel.disposables.clear();
        mainActivityViewModel.loadRepos();

        verify(getGitRepos).call();
        verify(observer).onChanged(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getStatus(), is(Status.SUCCESS));
        assertThat(argumentCaptor.getValue().getData(), is(items));
        assertThat(mainActivityViewModel.disposables.size(), is(1));
    }
}
