package com.rock.andrew.fit.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rock.andrew.fit.fragments.login_first;

/**
 * Created by RockStar-0116 on 2016.07.14.
 */
public class Login_firstScreen_Adapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public Login_firstScreen_Adapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return login_first.newInstance("", "first strap");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return login_first.newInstance("", "second strap");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return login_first.newInstance("", "third strap");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }
}
