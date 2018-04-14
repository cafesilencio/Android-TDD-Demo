package net.cafesilencio.demo.view;

import android.support.v7.widget.RecyclerView;

import net.cafesilencio.demo.BuildConfig;
import net.cafesilencio.demo.R;
import net.cafesilencio.demo.TestDemoApp;
import net.cafesilencio.demo.model.GitRepoRecord;
import net.cafesilencio.demo.view.activity.MainActivity;
import net.cafesilencio.demo.view.adapter.GitRepoAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Seth Bourget on 4/14/18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, application = TestDemoApp.class)
public class MainActivityTest {

    @Test
    public void onResume_loadsDataIntoRecycleView() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();

        GitRepoAdapter adapter = (GitRepoAdapter)((RecyclerView)activity.findViewById(R.id.gitRepoList)).getAdapter();

        assertThat(adapter.getItemCount(), is(3));

        List<GitRepoRecord> repoList = adapter.getCloneOfValues();
        assertThat(repoList.get(0).getName(), is("repo ABC"));
        assertThat(repoList.get(0).getHtmlUrl(), is("repo ABC url"));

        assertThat(repoList.get(1).getName(), is("repo LMNOP"));
        assertThat(repoList.get(1).getHtmlUrl(), is("repo LMNOP url"));

        assertThat(repoList.get(2).getName(), is("repo XYZ"));
        assertThat(repoList.get(2).getName(), is("repo XYZ url"));
    }
}
