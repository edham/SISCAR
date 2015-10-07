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

package com.mimp.fragment.supervision;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mimp.activity.R;

public class Slide extends Fragment{
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    TextView title;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_screen_slide, container, false);
            title=(TextView) view.findViewById(R.id.title);
            mPager = (ViewPager) view.findViewById(R.id.pager);
            mPagerAdapter = new ScreenSlidePagerAdapter(this.getChildFragmentManager());
            mPager.setAdapter(mPagerAdapter);
            mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    switch (position) {
                        case 0: // Fragment # 0 - This will show FirstFragment
                            title.setText("ANEXO 1");
                            break;
                        case 1: // Fragment # 0 - This will show FirstFragment different title
                            title.setText("ANEXO 2");
                            break;
                        case 2: // Fragment # 1 - This will show SecondFragment
                            title.setText("ANEXO 3");
                            break;
                        case 3: // Fragment # 1 - This will show SecondFragment
                            title.setText("ANEXO 4");
                            break;
                    }
                }


            });

            title.setText("FORMATO 1");
            return view;

    }




    /**
     * A simple pager adapter that represents 5 {@link Anexo1Page} objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return Anexo1Page.create(position);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return Anexo2Page.create(position);
                case 2: // Fragment # 1 - This will show SecondFragment
                    return Anexo3Page.create(position);
                case 3: // Fragment # 1 - This will show SecondFragment
                    return Anexo4Page.create(position);
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
