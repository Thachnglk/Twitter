package com.iuh.thachnglk.coderschool.OTHER_USEFUL_CLASS;

import android.app.Activity;
import android.util.DisplayMetrics;


public class GlobalVariable {
    public static int getScreenWidth(Activity activity)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    public static final String CURRENT_USER_ID = "currentUserId";
    public static final String TWEET_TRANSFER = "tweetTransfer";
    public static final String COMMENT_TWEET_TRANSFER = "commentTweetTransfer";
}

