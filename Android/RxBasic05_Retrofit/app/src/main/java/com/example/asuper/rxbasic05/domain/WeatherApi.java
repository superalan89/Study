package com.example.asuper.rxbasic05.domain;

/**
 * Created by super on 2017-11-16.
 */

public class WeatherApi
{
    private RealtimeWeatherStation RealtimeWeatherStation;

    public RealtimeWeatherStation getRealtimeWeatherStation ()
    {
        return RealtimeWeatherStation;
    }

    public void setRealtimeWeatherStation (RealtimeWeatherStation RealtimeWeatherStation)
    {
        this.RealtimeWeatherStation = RealtimeWeatherStation;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RealtimeWeatherStation = "+RealtimeWeatherStation+"]";
    }
}
