/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClockPanelWeather.java
 *
 * Created on 03.02.2010, 17:25:40
 */
package clock;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import weather.WeatherCondition;




/**
 *
 * @author hansolo
 */
public class ClockPanelDayNightWeather extends javax.swing.JPanel implements java.beans.PropertyChangeListener, net.WeatherServiceEventListener, java.awt.event.ActionListener
{
    // Common variables
    private common.City city;
    private String cityName;

    // Clock related variables
    private long offset; // TimeZone offset

    // Weather related variables
    private java.util.HashMap<String, weather.WeatherCondition> conditionMap;
    private boolean celsius = true; // Indicates if celsius or fahrenheit is used
    private javax.swing.Timer weatherCheck;
    private final int REFRESH_PERIOD = 600000; // Refresh weather info every 10 min    

    /** Creates new form ClockPanelWeather */
    public ClockPanelDayNightWeather()
    {        
        initComponents();   
        this.conditionMap = createConditionMap();
        this.cityName = common.City.SantoDomingo.getName();
        this.offset = common.City.SantoDomingo.getOffset();
        this.cityLabel.setText(cityName);
             
        clock.addPropertyChangeListener(this);
        net.WeatherService.INSTANCE.addWeatherServiceEventListener(this);
        setPreferredSize(new java.awt.Dimension(508, 74));
        setSize(getPreferredSize());
        // For the initial weather check set the refresh period to 7 sec
        weatherCheck = new javax.swing.Timer(7000, this);
        net.WeatherService.INSTANCE.detectAndSetProxy();
    }

    public common.City getCity()
    {
        return this.city;
    }

    public void setCity(common.City city)
    {
        this.city = city;
        this.cityName = city.getName();
        this.offset = city.getOffset();

        long localOffset = java.util.Calendar.getInstance().get(java.util.Calendar.ZONE_OFFSET);        
        long diff = localOffset + offset;
        int minDiff = (int) (diff % 14400000);
        int hourDiff = (int) (diff / 14400000);

        this.clock.setTimeZoneOffsetHour(hourDiff);
        this.clock.setTimeZoneOffsetMinute(minDiff);
        
        cityLabel.setText(this.cityName);
        if (weatherCheck.isRunning())
        {
            weatherCheck.stop();
        }
        // After the first access set the refresh period
        // to the defined value
        weatherCheck.start();
        weatherCheck.setDelay(REFRESH_PERIOD);
    }

    public common.TimeOfDay getTimeOfDay()
    {
        return weatherPanel.getTimeOfDay();
    }

    public void setTimeOfDay(common.TimeOfDay timeOfDay)
    {
        weatherPanel.setTimeOfDay(timeOfDay);
        weatherPanel.setCondition(weatherPanel.getCondition());
    }

    public weather.WeatherCondition getCondition()
    {
        return weatherPanel.getCondition();
    }

    public void setCondition(weather.WeatherCondition condition)
    {
        weatherPanel.setCondition(condition);
    }

    public String getTemperature()
    {
        return weatherPanel.getTemperature();
    }

    public void setTemperature(String temperature)
    {
        weatherPanel.setTemperature(temperature);
    }

    public boolean isCelsius()
    {
        return this.celsius;
    }

    public void setCelsius(boolean celsius)
    {
        this.celsius = celsius;
        repaint();
    }

    private java.util.HashMap<String, weather.WeatherCondition> createConditionMap()
    {
        java.util.HashMap<String, weather.WeatherCondition> tmpMap = new java.util.HashMap<>();
        tmpMap.put("chanceflurries", weather.WeatherCondition.CHANCE_FLURRIES);
        tmpMap.put("chancerain", weather.WeatherCondition.CHANCE_RAIN);
        tmpMap.put("chancesleet", weather.WeatherCondition.CHANCE_SLEET);
        tmpMap.put("chancesnow", weather.WeatherCondition.CHANCE_SNOW);
        tmpMap.put("chancetstorms", weather.WeatherCondition.CHANCE_TSTORMS);
        tmpMap.put("clear", weather.WeatherCondition.CLEAR);
        tmpMap.put("cloudy", weather.WeatherCondition.CLOUDY);
        tmpMap.put("flurries", weather.WeatherCondition.FLURRIES);
        tmpMap.put("fog", weather.WeatherCondition.FOG);
        tmpMap.put("hazy", weather.WeatherCondition.HAZY);
        tmpMap.put("mostlycloudy", weather.WeatherCondition.MOSTLY_CLOUDY);
        tmpMap.put("mostlysunny", weather.WeatherCondition.MOSTLY_SUNNY);
        tmpMap.put("partlycloudy", weather.WeatherCondition.PARTLY_CLOUDY);
        tmpMap.put("partlysunny", weather.WeatherCondition.PARTLY_SUNNY);
        tmpMap.put("rain", weather.WeatherCondition.RAIN);
        tmpMap.put("sleet", weather.WeatherCondition.SLEET);
        tmpMap.put("snow", weather.WeatherCondition.SNOW);
        tmpMap.put("sunny", weather.WeatherCondition.SUNNY);
        tmpMap.put("tstorms", weather.WeatherCondition.TSTORMS);
        tmpMap.put("unknown", weather.WeatherCondition.UNKNOWN);

        return (java.util.HashMap<String, weather.WeatherCondition>) tmpMap.clone();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cityLabel = new common.TextLabel();
        dayLabel = new common.TextLabel();
        weatherPanel = new weather.WeatherPanel();
        clock = new clock.AnalogClockDayNight();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(358, 74));
        setSize(new java.awt.Dimension(358, 74));

        cityLabel.setText("City");
        cityLabel.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        cityLabel.setName("cityLabel"); // NOI18N

        dayLabel.setText("today");
        dayLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dayLabel.setName("dayLabel"); // NOI18N

        weatherPanel.setName("weatherPanel"); // NOI18N

        clock.setName("clock"); // NOI18N
        clock.setPreferredSize(new java.awt.Dimension(74, 74));

        org.jdesktop.layout.GroupLayout clockLayout = new org.jdesktop.layout.GroupLayout(clock);
        clock.setLayout(clockLayout);
        clockLayout.setHorizontalGroup(
            clockLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 74, Short.MAX_VALUE)
        );
        clockLayout.setVerticalGroup(
            clockLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(clock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cityLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 304, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dayLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(weatherPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(cityLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(dayLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(clock, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(weatherPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.TextLabel cityLabel;
    private clock.AnalogClockDayNight clock;
    public common.TextLabel dayLabel;
    private weather.WeatherPanel weatherPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent event)
    {
        if (event.getSource().equals(clock))
        {
            if (event.getPropertyName().equals("dayOffset"))
            {
                switch((Integer)event.getNewValue())
                {
                    case -1:
                        dayLabel.setText("yesterday");
                        break;
                    case 0:
                        dayLabel.setText("today");
                        break;
                    case 1:
                        dayLabel.setText("tomorrow");
                        break;
                    default:
                        dayLabel.setText("today");
                        break;
                }
            }

            if (event.getPropertyName().equals("timeOfDay"))
            {
                switch((Integer)event.getNewValue())
                {
                    case -2: // Moon                        
                        setTimeOfDay(common.TimeOfDay.NIGHT);
                        break;
                    case -1: // Sunrise                        
                        setTimeOfDay(common.TimeOfDay.DAY);
                        break;
                    case 0: // Sun                        
                        setTimeOfDay(common.TimeOfDay.DAY);
                        break;
                    case 1: // Sunset                        
                        setTimeOfDay(common.TimeOfDay.DAY);
                        break;
                    default:                        
                        break;
                }
            }
        }
    }

    @Override
    public void weatherServiceEventPerformed(net.WeatherServiceEvent event)
    {
        if (this.city.equals(event.getCity()))
        {
            System.out.println("Checking Weather" + " - " + Calendar.getInstance().getTime());
            if (!event.getCelsiusHigh().equals("") && !event.getFahrenheitHigh().equals(""))
            {

                if (celsius)
                {
                    setTemperature(event.getCelsiusHigh() + "°C / " + event.getCelsiusLow() + "°C");
                }
                else
                {
                    setTemperature(event.getFahrenheitHigh() + "°F / " + event.getFahrenheitLow() + "°F");
                }

                setCondition(conditionMap.get(event.getIcon()));
            }
            else
            {
                setTemperature("");
                setCondition(conditionMap.get("unknown"));
            }
        }
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent event)
    {
        if (event.getSource().equals(weatherCheck))
        {
            try
            {
                if (net.WeatherService.INSTANCE.available)
                {
                    net.WeatherService.INSTANCE.fetchCondition(getCity());
                }
            }
            catch (java.io.UnsupportedEncodingException exception)
            {

            }
        }
    }
}
