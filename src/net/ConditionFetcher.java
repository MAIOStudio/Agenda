/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net;



/**
 *
 * @author hansolo
 */
public class ConditionFetcher implements java.lang.Runnable
{
    private final java.util.concurrent.BlockingQueue<common.City> EVENT_BUFFER;
    private static final String WEB_SERVICE_URL = "http://api.wunderground.com/auto/wui/geo/ForecastXML/index.xml";
    private final boolean FIRE_EVENT;

    public ConditionFetcher(java.util.concurrent.BlockingQueue<common.City> eventBuffer, boolean fireEvent)
    {
        this.EVENT_BUFFER = eventBuffer;
        this.FIRE_EVENT = fireEvent;
    }

    @Override
    public void run()
    {
        try
        {
            fetchCondition(EVENT_BUFFER.take(), FIRE_EVENT);
        }
        catch (java.lang.InterruptedException exception)
        {

        }
        catch (java.io.UnsupportedEncodingException exception)
        {

        }
    }

    private void fetchCondition(common.City city, boolean fireEvent) throws java.io.UnsupportedEncodingException
    {
        String location = java.net.URLEncoder.encode(city.getName() + "," + city.getCountry(), "UTF-8");
        String fahrenheitHigh = "";
        String celsiusHigh = "";
        String fahrenheitLow = "";
        String celsiusLow = "";
        String icon = "";

        // Read response from the input stream.
        try
        {
            java.net.URL url = new java.net.URL(WEB_SERVICE_URL + "?query=" + location);
            java.io.InputStream in = null;

            try
            {
                //in = new java.io.BufferedReader(new java.io.InputStreamReader(url.openStream()));
                in = url.openStream();
                javax.xml.stream.XMLInputFactory factory = javax.xml.stream.XMLInputFactory.newInstance();
                javax.xml.stream.XMLEventReader eventReader = factory.createXMLEventReader(in);
                String period = "0";

                while (eventReader.hasNext())
                {
                    javax.xml.stream.events.XMLEvent event = eventReader.nextEvent();
                    javax.xml.stream.events.XMLEvent tag;

                    if (event.isStartElement())
                    {
                        if (event.asStartElement().getName().getLocalPart().equals("period"))
                        {
                            event = eventReader.nextEvent();
                            //System.out.print(event.asCharacters().getData() + "  ");
                            period = event.asCharacters().getData().toString();
                            continue;
                        }

                        if (event.asStartElement().getName().getLocalPart().equals("high") && period.equals("1"))
                        {
                            tag = eventReader.nextTag();
                            if (tag.asStartElement().getName().getLocalPart().equals("fahrenheit"))
                            {
                                event = eventReader.nextEvent();
                                //System.out.print("high F°: " + event.asCharacters().getData() + "   ");
                                fahrenheitHigh = event.asCharacters().getData();
                            }

                            eventReader.nextTag();

                            tag = eventReader.nextTag();
                            if (tag.asStartElement().getName().getLocalPart().equals("celsius"))
                            {
                                event = eventReader.nextEvent();
                                //System.out.print("high C°: " + event.asCharacters().getData() + "   ");
                                celsiusHigh = event.asCharacters().getData();
                            }
                            continue;
                        }

                        if (event.asStartElement().getName().getLocalPart().equals("low") && period.equals("1"))
                        {
                            tag = eventReader.nextTag();
                            if (tag.asStartElement().getName().getLocalPart().equals("fahrenheit"))
                            {
                                event = eventReader.nextEvent();
                                //System.out.print("low F°: " + event.asCharacters().getData() + "   ");
                                fahrenheitLow = event.asCharacters().getData();
                            }

                            eventReader.nextTag();

                            tag = eventReader.nextTag();
                            if (tag.asStartElement().getName().getLocalPart().equals("celsius"))
                            {
                                event = eventReader.nextEvent();
                                //System.out.print("low C°: " + event.asCharacters().getData() + "   ");
                                celsiusLow = event.asCharacters().getData();
                            }
                            continue;
                        }

                        if (event.asStartElement().getName().getLocalPart().equals("icon") && period.equals("1"))
                        {
                            event = eventReader.nextEvent();
                            //System.out.println(event.asCharacters().getData() + "   ");
                            icon = event.asCharacters().getData();
                            continue;
                        }
                    }
                }
                in.close();
            }
            catch (javax.xml.stream.XMLStreamException exception)
            {
            }
            finally
            {
                if (null != in)
                {
                    in.close();
                }
            }
        }
        catch (java.net.MalformedURLException exception)
        {
            
        }
        catch (java.io.IOException exception)
        {
            
        }

        if (fireEvent)
        {
            WeatherService.INSTANCE.fireWeatherServiceEvent(new WeatherServiceEvent(this, city, fahrenheitHigh, celsiusHigh, fahrenheitLow, celsiusLow, icon));
        }
        else
        {
            if (!icon.equals(""))
            {
                WeatherService.INSTANCE.available = true;
                //System.out.println("WeatherService available");
            }
            else
            {
                WeatherService.INSTANCE.available = false;
                //System.out.println("WeatherService not available");
            }
        }
    }

}
