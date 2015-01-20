/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package weather;

/**
 *
 * @author hansolo
 */
public enum WeatherCondition
{
    //Chance of Flurries
    CHANCE_FLURRIES("Chance of flurries"),
    //Chance of Rain
    CHANCE_RAIN("Chance of rain"),
    //Chance of Sleet
    CHANCE_SLEET("Chance of sleet"),
    //Chance of Snow
    CHANCE_SNOW("Chance of snow"),
    //Chance of Thunderstorms
    CHANCE_TSTORMS("Chance of thunderstorms"),
    //Clear
    CLEAR("Clear"),
    //Cloudy
    CLOUDY("Cloudy"),
    //Flurries
    FLURRIES("Flurries"),
    //Fog
    FOG("Fog"),
    //Haze
    HAZY("Hazy"),
    //Mostly Cloudy
    MOSTLY_CLOUDY("Mostly cloudy"),
    //Mostly Sunny
    MOSTLY_SUNNY("Mostly sunny"),
    //Partly Cloudy
    PARTLY_CLOUDY("Partly cloudy"),
    //Partly Sunny
    PARTLY_SUNNY("Partly sunny"),
    //Rain
    RAIN("Rain"),
    //Sleet
    SLEET("Sleet"),
    //Snow
    SNOW("Snow"),
    //Sunny
    SUNNY("Sunny"),
    //Thunderstorms
    TSTORMS("Thunderstorms"),
    //Unknown
    UNKNOWN("unknown");

    private String description;

    WeatherCondition(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }
}
