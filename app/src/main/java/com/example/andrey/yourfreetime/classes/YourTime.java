package com.example.andrey.yourfreetime.classes;


import java.sql.Time;
import java.util.Date;

public class YourTime {
    private static long timeofbegin;
    private static long durationofnow;
    private static long durationofday;
    private static long durationofweek;
    private static long durationofmonth;
    private static long durationofall;

    public YourTime(long begin, long now, long day,long week,long month, long all )
    {
        this.timeofbegin=begin;
        this.durationofnow=now;
        this.durationofday=day;
        this.durationofweek=week;
        this.durationofmonth=month;
        this.durationofall=all;
    }

    public YourTime()
    {
        this.timeofbegin= System.currentTimeMillis();
    }

    public YourTime ActionClose()
    {
        long tmp=System.currentTimeMillis();
        tmp=tmp-this.timeofbegin;
        this.timeofbegin=0;
        this.durationofnow+=tmp;
        this.durationofday+=tmp;
        this.durationofweek+=tmp;
        this.durationofmonth+=tmp;
        this.durationofall+=tmp;
        return this;
    }

    public YourTime Update()
    {
        long tmp=System.currentTimeMillis();
        tmp=tmp-this.timeofbegin;
        this.timeofbegin+=tmp;
        this.durationofnow+=tmp;
        this.durationofday+=tmp;
        this.durationofweek+=tmp;
        this.durationofmonth+=tmp;
        this.durationofall+=tmp;
        return this;
    }

}
