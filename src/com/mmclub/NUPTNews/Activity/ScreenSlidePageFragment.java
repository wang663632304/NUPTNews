/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mmclub.NUPTNews.Activity;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.mmclub.NUPTNews.NewsApplication;
import com.mmclub.NUPTNews.R;


public class ScreenSlidePageFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "page";

    private int mPageNumber;

    private String contentDir;


    public static ScreenSlidePageFragment create(int pageNumber, String contentDir) {
        /**
         * @params  contentDir是本期内容绝对路径,如 file:///sdcard/news/1-南邮手机报第1s期/
         */
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment(contentDir);
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment(String contentDir) {
        this.contentDir = contentDir;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide_page, container, false);



       // String url = "file:///" + contentDir + String.valueOf(mPageNumber) + ".html";
        String url = "file://" + contentDir + String.valueOf(mPageNumber + 1) + ".html";
        Log.d("TAG", "Load URL " +  url);
        ((WebView)(rootView.findViewById(R.id.webview))).loadUrl(url);

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
