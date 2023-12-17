package com.example.increment.tools;

public enum ActivitiesRequestCodes {
    START,
    SETTING,
    ABOUT,
    NONE;

    public static ActivitiesRequestCodes getValue(int value){
        switch(value){
            case 0:return START;
            case 1:return SETTING;
            case 2:return ABOUT;
            default:return NONE;
        }
    }

}
