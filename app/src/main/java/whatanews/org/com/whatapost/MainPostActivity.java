package whatanews.org.com.whatapost;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import whatanews.org.com.whatapost.Fragments.StatePagerFragment;

public class MainPostActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_post);
        ButterKnife.bind(this);

        this.getSupportFragmentManager().beginTransaction().add(R.id.container, new StatePagerFragment()).commit();


    }
}
