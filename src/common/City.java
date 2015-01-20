/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author hansolo
 */
public enum City
{
    // -12
    Wellington("Wellington", "New Zealand", -43200000),
    FijiIslands("Fiji islands", "Fiji Islands", -43200000),
    Kamchatka("Kamchatka","Russia", -43200000),
    // -11
    Magadan("Magadan", "Russia", -39600000),
    Sakhalin("Sachalin", "Russia", -39600000),
    SolomonIslands("Solomon islands", "Solomon islands", -39600000),
    Malekula("Malekula", "Malampa", -39600000),
    // -10
    Vladivostok("Vladivostok", "Russia", -36000000),
    Guam("Guam", "", -36000000),
    Sydney("Sydney", "Australia", -36000000),
    Brisbane("Brisbane", "Australia", -36000000),
    Melbourne("Melbourne", "Australia", -36000000),
    // -9.5
    Darwin("Darwin", "Australia", -34200000),
    Adelaide("Adelaide", "Australia", -34200000),
    // -9
    Yakutsk("Yakutsk", "Russia", -32400000),
    Tokio("Tokio", "Japan", -32400000),
    Seoul("Seoul", "South Korea", -32400000),
    Pyongyang("Pyongyang", "China", -32400000),
    // -8
    UlanBator("Ulan Bator", "Russia", -28800000),
    Beijing("Beijing", "China", -28800000),
    HongKong("Hong Kong", "China", -28800000),
    KualaLumpur("Kuala Lumpur", "Malaysia", -28800000),
    Perth("Perth", "Australia", -28800000),
    // -7
    UlanGong("Ulan Gong", "Philippines", -25200000),
    Bangkok("Bangkok", "Thailand", -25200000),
    Hanoi("Hanoi", "Vietnam", -25200000),
    Pedang("Pedang", "Nepal", -25200000),
    Jakarta("Jakarta", "Indonesia", -25200000),
    // -6.5
    Rangoon("Rangoon", "Birma", -23400000),
    CocoIslands("Coco islands", "Birma", -23400000),
    // -6
    Omsk("Omsk", "Russia", -21600000),
    Novosibirsk("Novosibirsk", "Russia", -21600000),
    Bishkek("Bishkek", "Russia", -21600000),
    Colombo("Colombo", "Sri Lanka", -21600000),
    Dhaka("Dhaka", "Bangladesh", -21600000),
    // -5.75
    Kathmandu("Kathmandu", "Nepal", -20700000),
    // -5.5
    NewDelhi("New Delhi", "India", -19800000),
    Mumbai("Mumbai", "India", -19800000),
    Kolkata("Kolkata", "India", -19800000),
    Nicobar("Nicobar", "India", -19800000),
    // -5
    Orenburg("Orenburg", "Russia", -18000000),
    Yekaterinburg("Yekaterinburg", "Russia", -18000000),
    Ashgabat("Ashgabat", "Turkmenistan", -18000000),
    Karachi("Karachi", "Pakistan", -18000000),
    // -4.5
    Kabul("Kabul", "Afghanistan", -16200000),
    // -4
    Samara("Samara", "Russia", -14400000),
    Tiflis("Tbilisi", "Georgia", -14400000),
    Yerevan("Yerevan", "Armenia", -14400000),
    AbuDabi("Abu Dhabi", "United Arab Emirates", -14400000),
    Muscat("Muscat", "Oman", -14400000),
    // -3.5
    Tehran("Tehran", "Iran", -12600000),
    // -3
    Moskau("Moskau", "Russia", -10800000),
    Damascus("Damascus", "Syria", -10800000),
    Mogadishu("Mogadishu", "Somalia", -10800000),
    Nairobi("Nairobi", "Kenya", -10800000),
    DarEsSalam("Dar es Salaam", "Tanzania", -10800000),
    // -2
    Helsinki("Helsinki", "Finland", -7200000),
    Kiev("Kiev", "Ukraine", -7200000),
    Athens("Athens", "Greece", -7200000),
    Istanbul("Istanbul", "Turkey", -7200000),
    Kairo("Kairo", "Egypt", -7200000),
    Windhoek("Windhoek", "Namibia", -7200000),
    CapeTown("Cape town", "South Africa", -7200000),
    // -1
    Berlin("Berlin", "Germany", -3600000),
    Hamburg("Hamburg", "Germany", -3600000),
    Cologne("Cologne", "Germany", -3600000),
    Dortmund("Dortmund", "Germany", -3600000),
    Muenster("Muenster", "Germany", -3600000),
    Frankfurt("Frankfurt", "Germany", -3600000),
    Munich("Munich", "Germany", -3600000),
    Paris("Paris", "France", -3600000),
    Rom("Rom", "Italy", -3600000),
    Belgrade("Belgrade", "Serbia", -3600000),
    Alger("Alger", "Algeria", -3600000),
    Lagos("Lagos", "Portugal", -3600000),
    // +0
    London("London", "UK", 0),
    Dublin("Dublin", "Ireland", 0),
    Lisbon("Lisbon", "Portugal", 0),
    Reykjavik("Reykjavik", "Iceland", 0),
    Accra("Accra", "Ghana", 0),
    // +1
    Azores("Azores", "Portugal", 3600000),
    CapeVerde("Cape Verde", "Portugal", 3600000),
    // +2
    Montevideo("Montevidio", "Uruguay", 7200000),
    // +3
    Georgetown("Georgetown", "South Africa", 10800000),
    Brasilia("Brasilia", "Brazil", 10800000),
    RioDeJaneiro("Rio de Janeiro", "Brazil", 10800000),
    BuenosAires("Buenos Aires", "Argentina", 10800000),
    // +3.5
    Newfoundland("Newfoundland", "Canada", 12600000),
    // +4
    Halifax("Halifax", "Canada", 14400000),
    Caracas("Caracas", "Venezuela", 14400000),
    SantoDomingo("Santo Domingo", "Dominican Republic", 14400000),
    Santiago("Santiago", "Chile", 14400000),
    LaPaz("La Paz", "Bolivia", 14400000),
    // +5
    //NewYork("New York", "United States of America", 18000000),
    NewYork("New York", "NY", 18000000),
    Toronto("Toronto", "Canada", 18000000),
    Bogota("Bogota", "Colombia", 18000000),
    Lima("Lima", "Peru", 18000000),
    // +6
    Saskatchewan("Saskatchewan", "Canada", 21600000),
    Austin("Austin", "USA", 21600000),
    NewOrleans("New Orleans", "LA", 21600000),
    MexicoCity("Mexico City", "Mexico", 21600000),
    // +7
    SaltLakeCity("Salt Lake City", "UT", 25200000),
    // +8
    Vancouver("Vancouver", "Canada", 28800000),
    LosAngeles("Los Angeles", "CA", 28800000),
    SanFrancisco("San Francisco", "CA", 28800000),
    // +9
    Yukon("Yukon", "Canada", 32400000),
    // +10
    Hawaii("Hawaii", "United States of America", 36000000),
    // +11
    Nome("Nome", "United States of America", 39600000),
    Samoa("Samoa", "United States of America", 39600000),
    MidwayIslands("Midway islands", "United States of America", 39600000),
    // +12
    Eniwetok("Eniwetok", "Japan", 43200000),
    Kwajalein("Kwajalein", "Marshall islands", 43200000);

    private long offset;
    private String name;
    private String country;

    City(String name, String country, long offset)
    {
        this.name = name;
        this.country = country;
        this.offset = offset;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCountry()
    {
        return this.country;
    }

    public long getOffset()
    {
        return this.offset;
    }
}
