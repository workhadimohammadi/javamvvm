package com.example.root.testlivedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel{ // Create a LiveData with a String
        private MutableLiveData<String> mCurrentName;

        public MutableLiveData<String> getCurrentName() {
            if (mCurrentName == null) {
                mCurrentName = new MutableLiveData<String>();
            }
            return mCurrentName;
        }

// Rest of the ViewModel...
}