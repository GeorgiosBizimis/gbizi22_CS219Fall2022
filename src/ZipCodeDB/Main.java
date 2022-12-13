package ZipCodeDB;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        Database db = new Database();

        System.out.println(db.findByZip("13617"));
        System.out.println(db.findByZip("12901"));
        System.out.println(db.findByZip("hello"));

        System.out.println(db.search("13617"));

        WeatherObservation wob = db.search("13617").getWeatherData();
        System.out.println(wob);
    }

}
