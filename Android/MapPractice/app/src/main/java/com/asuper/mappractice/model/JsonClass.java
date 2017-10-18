package com.asuper.mappractice.model;

/**
 * Created by super on 2017-10-17.
 */

public class JsonClass
{
    private InfoTrdhlFlpop InfoTrdhlFlpop;

    public InfoTrdhlFlpop getInfoTrdhlFlpop ()
    {
        return InfoTrdhlFlpop;
    }

    public void setInfoTrdhlFlpop (InfoTrdhlFlpop InfoTrdhlFlpop)
    {
        this.InfoTrdhlFlpop = InfoTrdhlFlpop;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [InfoTrdhlFlpop = "+InfoTrdhlFlpop+"]";
    }
}

