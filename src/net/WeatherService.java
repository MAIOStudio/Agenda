package net;



public enum WeatherService implements java.awt.event.ActionListener
{
    INSTANCE;
    public static boolean available = false;
    private javax.swing.event.EventListenerList listenerList = new javax.swing.event.EventListenerList();
    private final java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(5);
    private final java.util.concurrent.BlockingQueue<common.City> FETCHING_QUEUE = new java.util.concurrent.ArrayBlockingQueue<common.City>(10);
    private final javax.swing.Timer CHECK_CONNECTION_TIMER = new javax.swing.Timer(30000, this);


    WeatherService()
    {
        checkConnection();
        CHECK_CONNECTION_TIMER.start();
    }

    /**
     * Method that will try to detect the system wide used
     * proxy server and set it to the system properties.
     * It does this by calling http.//www.google.com
     * @return
     */
    public boolean detectAndSetProxy()
    {
        boolean proxySet = false;
        java.util.Properties sysProperties = System.getProperties();
        try
        {
            System.setProperty("java.net.useSystemProxies", "true");
            java.util.List<java.net.Proxy> proxyList = java.net.ProxySelector.getDefault().select(new java.net.URI("http://www.google.com"));
            for (java.net.Proxy proxy : proxyList)
            {
                java.net.InetSocketAddress addr = (java.net.InetSocketAddress) proxy.address();
                if (addr == null)
                {                    
                    sysProperties.setProperty("http.proxyHost", "");
                    sysProperties.setProperty("http.proxyPort", "");
                    sysProperties.setProperty("proxySet", "false");
                    proxySet = false;
                }
                else
                {
                    sysProperties.setProperty("http.proxyHost", addr.getHostName());
                    sysProperties.setProperty("http.proxyPort", String.valueOf(addr.getPort()));
                    sysProperties.setProperty("proxySet", "true");
                    proxySet = true;
                }
            }
        }
        catch (java.net.URISyntaxException exception)
        {
            proxySet = false;
        }
        System.setProperties(sysProperties);

        return proxySet;
    }

    private void checkConnection()
    {
        FETCHING_QUEUE.add(common.City.SantoDomingo);
        executorService.execute(new ConditionFetcher(FETCHING_QUEUE, false));
        //System.out.println("connection checked, current state: " + available);
    }

    /**
     * Method that will add a the given city to the eventbuffer and starts the
     * executorService that will create a new thread from the threadpool which
     * will than take the city from the buffer and fetches the weather data
     * from weather underground
     * @param city
     * @throws java.io.UnsupportedEncodingException
     */
    public void fetchCondition(common.City city) throws java.io.UnsupportedEncodingException
    {
        FETCHING_QUEUE.add(city);
        executorService.execute(new ConditionFetcher(FETCHING_QUEUE, true));
    }


    // Creation and handling of WeatherServiceEvent -------------------------------
    public void addWeatherServiceEventListener(WeatherServiceEventListener listener)
    {
        listenerList.add(WeatherServiceEventListener.class, listener);
    }
    
    public void removeWeatherServiceEventListener(WeatherServiceEventListener listener)
    {
        listenerList.remove(WeatherServiceEventListener.class, listener);
    }

    public void fireWeatherServiceEvent(WeatherServiceEvent event)
    {
        Object[] listeners = listenerList.getListenerList();
        int max = listeners.length;
        for(int i = 0 ; i < max ; i++)
        {
            if (listeners[i] == WeatherServiceEventListener.class)
            {
                ((WeatherServiceEventListener) listeners[i+1]).weatherServiceEventPerformed(event);                
            }
        }
    }
    // ------------------------------------------------------------------------

    @Override
    public void actionPerformed(java.awt.event.ActionEvent event)
    {
        if (event.getSource().equals(CHECK_CONNECTION_TIMER))
        {
            checkConnection();
        }
    }

    @Override
    public String toString()
    {
        return "WeatherService";
    }
}
