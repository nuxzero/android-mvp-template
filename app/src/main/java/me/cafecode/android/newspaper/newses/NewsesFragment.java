package me.cafecode.android.newspaper.newses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import me.cafecode.android.newspaper.NewspaperApplication;
import me.cafecode.android.newspaper.R;
import me.cafecode.android.newspaper.data.models.News;

public class NewsesFragment extends Fragment implements NewsesContract.View {

    private static final String TAG = NewsesFragment.class.getSimpleName();
    @Inject
    NewsesPresenter presenter;

    public NewsesFragment() {
        // Required empty public constructor
    }

    public static NewsesFragment newInstance() {
        return new NewsesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inject this fragment
        DaggerNewsesComponent.builder()
                .newsRepositoryComponent(((NewspaperApplication) getActivity().getApplication()).getRepositoryComponent())
                .newsesPresenterModule(new NewsesPresenterModule(this))
                .build()
                .inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newses, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.onStart();
    }

    @Override
    public void showProgressView(boolean isShow) {
        Log.i(TAG, "showProgressView()");
    }

    @Override
    public void showNewses(List<News> newses) {
        Log.i(TAG, "showNewses()");
    }

}
