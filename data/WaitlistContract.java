package com.example.android.capstoneprojectr.data;

import android.provider.BaseColumns;

/**
 * Created by Dimas Ariadi on 2/20/2017.
 */

public class WaitlistContract implements BaseColumns{
    public static final String TABLE_NAME = "waitlist";
    public static final String COLUMN_GUEST_NAME = "guestName";
    public static final String COLUMN_PARTY_SIZE = "partySize";
    public static final String COLUMN_TIMESTAMP = "timestamp";

}
