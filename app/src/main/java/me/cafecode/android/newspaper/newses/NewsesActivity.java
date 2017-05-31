package me.cafecode.android.newspaper.newses;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.cafecode.android.newspaper.R;

public class NewsesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newses);

        if (savedInstanceState == null) {
            initFragment(NewsesFragment.newInstance());
        }
    }

    private void initFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.newses_content, fragment)
                .commit();
    }

}
