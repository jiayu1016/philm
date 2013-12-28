package app.philm.in;

import com.google.common.base.Preconditions;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;

import app.philm.in.controllers.MovieController;
import app.philm.in.fragments.LoginFragment;
import app.philm.in.fragments.MovieDetailFragment;
import app.philm.in.fragments.MovieGridFragment;
import app.philm.in.fragments.MovieListFragment;
import app.philm.in.fragments.SearchListFragment;

public class Display {

    private final Activity mActivity;

    public Display(Activity activity) {
        mActivity = Preconditions.checkNotNull(activity, "activity cannot be null");
    }

    public void showLibrary() {
        MovieGridFragment fragment = MovieGridFragment
                .create(MovieController.MovieQueryType.LIBRARY);

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

    public void showTrending() {
        MovieGridFragment fragment = MovieGridFragment
                .create(MovieController.MovieQueryType.TRENDING);

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

    public void showWatchlist() {
        MovieListFragment fragment = MovieListFragment
                .create(MovieController.MovieQueryType.WATCHLIST);

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

    public void showLogin() {
        LoginFragment fragment = LoginFragment.create();

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

    public void showMovieDetailFragment(String movieId) {
        MovieDetailFragment fragment = MovieDetailFragment.create(movieId);

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    public void showSearchFragment() {
        SearchListFragment fragment = new SearchListFragment();

        mActivity.getFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, fragment)
                .commit();
    }

    public void closeDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        if (drawerLayout != null) {
            drawerLayout.closeDrawers();
        }
    }

    public void setActionBarTitle(int titleResId) {
        setActionBarTitle(mActivity.getString(titleResId));
    }

    public void setActionBarTitle(String title) {
        ActionBar ab = mActivity.getActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }
    }

}
