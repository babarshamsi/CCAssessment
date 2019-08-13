package com.example.testsubmission.utils;

import java.io.IOException;


public class NoInternetConnectivityException extends IOException {
    @Override
    public String getMessage() {
        return "No internet connection";    }
}

