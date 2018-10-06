package com.example.root.testlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnRun;
    TextView txtResult;
    EditText edtEntry;

    private MyViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setLiveData();
        setButtonAction();
    }

    private void initialize() {
        btnRun=findViewById(R.id.run);
        txtResult=findViewById(R.id.text_result);
        edtEntry=findViewById(R.id.entry);
    }

    private void setLiveData(){
        mModel = ViewModelProviders.of(this).get(MyViewModel.class);


        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                txtResult.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this, nameObserver);
    }

    private void setButtonAction(){
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entry=String.valueOf(edtEntry.getText());
                mModel.getCurrentName().setValue(entry);
            }
        });
    }
}
