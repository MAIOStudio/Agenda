/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package weather;


/**
 *
 * @author hansolo
 */
public class WeatherIconPanel extends javax.swing.JComponent
{            
    private java.util.HashMap<WeatherCondition, java.awt.image.BufferedImage> dayImageMap = createImageMap(true);
    private java.util.HashMap<WeatherCondition, java.awt.image.BufferedImage> nightImageMap = createImageMap(false);

    private common.TimeOfDay timeOfDay = common.TimeOfDay.DAY;
    private WeatherCondition condition = WeatherCondition.CLEAR;    
    private java.awt.image.BufferedImage weatherImage = dayImageMap.get(WeatherCondition.UNKNOWN);


    public WeatherIconPanel()
    {
        super();
        setPreferredSize(new java.awt.Dimension(96, 48));
        setSize(getPreferredSize());
        setToolTipText(condition.getDescription());
    }

    @Override
    protected void paintComponent(java.awt.Graphics g)
    {
        super.paintComponent(g);
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;

        g2.drawImage(weatherImage, 0, 0, null);

    }

    public common.TimeOfDay getTimeOfDay()
    {
        return this.timeOfDay;
    }

    public void setTimeOfDay(common.TimeOfDay timeOfDay)
    {
        this.timeOfDay = timeOfDay;
        repaint();
    }

    public WeatherCondition getCondition()
    {
        return this.condition;
    }

    public void setCondition(WeatherCondition condition)
    {
        this.condition = condition;
        
        // Replace weatherimage with image of new condition
        this.weatherImage.flush();
        switch(this.timeOfDay)
        {
            case DAY:
                weatherImage = dayImageMap.get(condition);
                break;
            case NIGHT:
                weatherImage = nightImageMap.get(condition);
        }
        setToolTipText(condition.getDescription());
        repaint();
    }

    private java.util.HashMap<WeatherCondition, java.awt.image.BufferedImage> createImageMap(boolean isDay)
    {
        java.util.HashMap<WeatherCondition, java.awt.image.BufferedImage> tmpMap = new java.util.HashMap<WeatherCondition, java.awt.image.BufferedImage>();
        
        for (WeatherCondition currentCondition : WeatherCondition.values())
        {
            tmpMap.put(currentCondition, createWeatherImage(currentCondition, isDay));
        }
        
        return (java.util.HashMap<WeatherCondition, java.awt.image.BufferedImage>) tmpMap.clone();
    }

    private java.awt.image.BufferedImage createWeatherImage(WeatherCondition condition, boolean isDay)
    {
        java.awt.GraphicsConfiguration gfxConf = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        final java.awt.image.BufferedImage IMAGE = gfxConf.createCompatibleImage(96, 48, java.awt.Transparency.TRANSLUCENT);
        java.awt.Graphics2D g2 = IMAGE.createGraphics();

        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ALPHA_INTERPOLATION, java.awt.RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING, java.awt.RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(java.awt.RenderingHints.KEY_STROKE_CONTROL, java.awt.RenderingHints.VALUE_STROKE_PURE);

        switch(condition)
        {
            // Windböen möglich
            case CHANCE_FLURRIES:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 7, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 19, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 29, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 41, 35, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 54, 30, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 64, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 76, 29, null);
                g2.drawImage(WeatherSymbols.INSTANCE.QUESTION_MARK, 76, 28, null);
                break;

            // Regen möglich
            case CHANCE_RAIN:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 10, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 18, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 21, 40, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 31, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 36, 40, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 43, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 48, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 56, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 57, 41, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 66, 35, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 78, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.QUESTION_MARK, 76, 28, null);
                break;

            // Schneeregen möglich
            case CHANCE_SLEET:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 2, 37, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 19, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 29, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 47, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 54, 30, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 71, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 76, 29, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 10, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 18, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 36, 40, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 43, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 57, 41, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 66, 35, null);
                g2.drawImage(WeatherSymbols.INSTANCE.QUESTION_MARK, 76, 28, null);
                break;

            // Schnee möglich
            case CHANCE_SNOW:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 7, 32, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 30, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 58, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 76, 28, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 2, 37, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 19, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 29, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 47, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 54, 30, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 71, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 76, 29, null);
                g2.drawImage(WeatherSymbols.INSTANCE.QUESTION_MARK, 76, 28, null);
                break;

            // Gewitter möglich
            case CHANCE_TSTORMS:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_DARK_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLASH, 29, 32, null);
                g2.drawImage(WeatherSymbols.INSTANCE.QUESTION_MARK, 76, 28, null);
                break;

            // Klar
            case CLEAR:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.BRIGHT_SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                break;

            // Bewölkt
            case CLOUDY:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SMALLER_CLOUD, 2, 23, null);
                break;

            // Böeig
            case FLURRIES:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 7, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 19, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 29, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 41, 35, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 54, 30, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 64, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 76, 29, null);
                break;

            // Nebelig
            case FOG:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.FOG_SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                g2.drawImage(WeatherSymbols.INSTANCE.FOG, 0, 0, null);
                break;

            // Dunstig
            case HAZY:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.FOG_SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                g2.drawImage(WeatherSymbols.INSTANCE.SMALLER_CLOUD, 2, 23, null);
                g2.drawImage(WeatherSymbols.INSTANCE.HAZY, 0, 0, null);
                break;

            // Überwiegend bewölkt
            case MOSTLY_CLOUDY:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                break;

            // Überwiegend sonnig
            case MOSTLY_SUNNY:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.BRIGHT_SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                g2.drawImage(WeatherSymbols.INSTANCE.SMALL_CLOUD, 28, 23, null);
                break;

            // Teilweise wolkig
            case PARTLY_CLOUDY:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                g2.drawImage(WeatherSymbols.INSTANCE.SMALLER_CLOUD2, 3, 13, null);
                break;

            // Teilweise sonnig
            case PARTLY_SUNNY:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                g2.drawImage(WeatherSymbols.INSTANCE.SMALLER_CLOUD, 2, 23, null);
                break;

            // Regen
            case RAIN:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 10, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 18, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 21, 40, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 31, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 36, 40, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 43, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 48, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 56, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 57, 41, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 66, 35, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 78, 31, null);
                break;

            // Schneeregen
            case SLEET:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 2, 37, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 19, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 29, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 47, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 54, 30, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 71, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 76, 29, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 10, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 18, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 36, 40, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 43, 34, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 57, 41, null);
                g2.drawImage(WeatherSymbols.INSTANCE.RAIN_DROP, 66, 35, null);
                break;

            // Schnee
            case SNOW:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_BRIGHT_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 7, 32, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 30, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 58, 33, null);
                g2.drawImage(WeatherSymbols.INSTANCE.SNOW_FLAKE, 76, 28, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 2, 37, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 19, 39, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 29, 31, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 47, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 54, 30, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 71, 38, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLURRY, 76, 29, null);
                break;

            // Sonne
            case SUNNY:
                if (isDay)
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.SUN, 0, 0, null);
                }
                else
                {
                    g2.drawImage(WeatherSymbols.INSTANCE.MOON, 2, 2, null);
                }
                break;

            // Gewitter
            case TSTORMS:
                g2.drawImage(WeatherSymbols.INSTANCE.BIG_DARK_CLOUD, 7, 1, null);
                g2.drawImage(WeatherSymbols.INSTANCE.FLASH, 29, 32, null);
                break;

            case UNKNOWN:

                break;
        }

        g2.dispose();

        return IMAGE;
    }
}
