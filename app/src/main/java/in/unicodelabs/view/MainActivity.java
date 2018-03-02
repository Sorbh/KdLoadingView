package in.unicodelabs.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    KdLoadingView kdLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kdLoadingView = (KdLoadingView)findViewById(R.id.kdLoadingView);
    }
}
