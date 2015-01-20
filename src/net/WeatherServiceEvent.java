/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net;

/**
 *
 * @author hansolo
 */
public class WeatherServiceEvent extends java.util.EventObject
{    
    private common.City city;
    private String fahrenheitHigh;
    private String celsiusHigh;
    private String fahrenheitLow;
    private String celsiusLow;
    private String icon;

    public WeatherServiceEvent(Object source, common.City city, String fahrenheitHigh, String celsiusHigh, String fahrenheitLow, String celsiusLow, String icon)
    {
        super(source);        
        this.city = city;
        this.fahrenheitHigh = fahrenheitHigh;
        this.celsiusHigh = celsiusHigh;
        this.fahrenheitLow = fahrenheitLow;
        this.celsiusLow = celsiusLow;
        this.icon = icon;
    }

    public common.City getCity()
    {
        return this.city;
    }

    public String getFahrenheitHigh()
    {
        return this.fahrenheitHigh;
    }

    public String getCelsiusHigh()
    {
        return this.celsiusHigh;
    }

    public String getFahrenheitLow()
    {
        return this.fahrenheitLow;
    }

    public String getCelsiusLow()
    {
        return this.celsiusLow;
    }

    public String getIcon()
    {
        return this.icon;
    }
}
