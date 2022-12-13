package ZipCodeDB;

import Utility.Weather;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/*
 * Hold data about one zipcode
 */
public class ZipCode implements Comparable<ZipCode>, Distance {

    private String code;
    private String state; // two character code abbreviation
    private String city;
    private double lng;
    private double lat;
    private int pop;
    private Scanner s;

    public ZipCode(String code, String state, String city, double lng, double lat, int pop) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.lng = lng;
        this.lat = lat;
        this.pop = pop;
    }

    public String getCode() {
        return code;
    }

    public double getLat() {
        return this.lat;
    }

    @Override
    public String toString()
    {
        return "Zipcode{" +
                "code='" + code + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", pop=" + pop +
                '}';
    }

    // Natural Ordering for ZipCode
    @Override
    public int compareTo(ZipCode zc) {
        return this.code.compareTo(zc.code);
    }

    @Override
    public double distance(ZipCode zip) {
        return 0; // fancy great circle distance
    }

    public WeatherObservation getWeatherData() {
        // http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=44&lng=-74&username=edharcourt
        this.s = URLScanner("http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=" +
                this.lat + "&lng=-" + this.lng + "&username=edharcourt\n");

        double humidity = 0, speed = 0, temp = 0;
        String clouds = "";

        while(s.hasNextLine()) {
            String line = s.nextLine();
            if(line.indexOf("humidity") > 0) {
                humidity = Double.parseDouble(line.substring(line.indexOf(':') + 1, line.indexOf(',')));
            } else if(line.indexOf("windSpeed") > 0) {
                speed = Double.parseDouble(line.substring(line.indexOf(':') + 3, line.indexOf(',') - 1));
            } else if(line.indexOf("temperature") > 0) {
                temp = Double.parseDouble(line.substring(line.indexOf(':') + 3, line.indexOf(',') - 1));
            } else if(line.indexOf("clouds") > 0) {
                clouds = line.substring(line.indexOf(':') + 3, line.indexOf(',') - 1);
            }
        }

        return new WeatherObservation(humidity, speed, temp, clouds);
    }

    private static Scanner URLScanner(final String url_string)
    {
        final URL url; // null is the nothing value

        try {
            url  = new URL(url_string);
            return new Scanner(url.openConnection().getInputStream());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
