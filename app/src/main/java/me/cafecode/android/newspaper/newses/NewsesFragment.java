package me.cafecode.android.newspaper.newses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.cafecode.android.newspaper.data.models.News;
import me.cafecode.android.newspaper.R;
import me.cafecode.android.newspaper.data.NewsRepository;

public class NewsesFragment extends Fragment implements NewsesContract.View {

    private NewsesPresenter mPresenter;

    public NewsesFragment() {
        // Required empty public constructor
    }

    public static NewsesFragment newInstance() {
        return new NewsesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new NewsesPresenter(new NewsRepository(), this);
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

        mPresenter.onStart();
    }

    @Override
    public void showProgressView(boolean isShow) {

    }

    @Override
    public void showNewses(List<News> newses) {

    }

}
