package com.example.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_STATE = "currentText";

    //pour le commit
    private ProgressBar progressBar;
    private TextView mTextView;
    private SimpleAsyncTask asyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);


        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
        progressBar = findViewById(R.id.progressBar);
    }

    public void startTask(View view) {

        mTextView.setText(R.string.napping);

        new SimpleAsyncTask(mTextView, progressBar).execute();
        asyncTask = new SimpleAsyncTask(mTextView, progressBar);

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}