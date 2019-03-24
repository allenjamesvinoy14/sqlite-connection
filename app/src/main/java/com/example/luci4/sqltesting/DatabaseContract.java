package com.example.luci4.sqltesting;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {


    private DatabaseContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.luci4.sqltesting";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_GOALS = "goal";


    public static final class Entry implements BaseColumns {

        public static final Uri CONTENT_URI_PRODUCT = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_GOALS);

        public final static String TABLE_NAME_GOALS = "goals";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOALS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOALS;

    }
}

