package com.idealdevelopers.dzirecybercafe.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.idealdevelopers.dzirecybercafe.R;

/**
 * Created by Project I on 11/1/2015.
 */
public class HomeFragement extends Fragment {

    private View parentView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.main, container, false);

        WebView heroespage = (WebView) parentView.findViewById(R.id.webView);
        WebSettings webSettings = heroespage.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getJavaScriptCanOpenWindowsAutomatically();
        heroespage.loadUrl("file:///android_asset/scroll.html");
        return parentView;
    }
}