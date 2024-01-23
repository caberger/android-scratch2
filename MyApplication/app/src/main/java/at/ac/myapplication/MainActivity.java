package at.ac.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import at.ac.myapplication.model.Model;
import at.ac.myapplication.model.Store;
import at.ac.myapplication.ui.layout.MainView;
import at.ac.myapplication.ui.layout.MainViewKt;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainView mainView;

    @Inject
    Store store;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        store.subject.subscribe(model -> Log.i(TAG, model.greeting));
        final var model = new Model();
        model.greeting = "juhu!";
        store.subject.onNext(model);

        mainView.compose(this);
    }
}
