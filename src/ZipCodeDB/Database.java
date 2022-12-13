package ZipCodeDB;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Store data about all of zipcodes.
 */
public class Database implements LatLngInterface {
    private final ArrayList<ZipCode> codes; //dangling reference
    private final Scanner s;
    private final static String SOLUTIONS_URL = "http://10.60.15.25/~ehar/cs219/zips.txt";

    public Database() {
        // allocate the array list
        this.codes = new ArrayList<>();
        this.s = URLScanner(SOLUTIONS_URL);
        this.loadZips();
    }

    // Fill the zipcode arraylist with real data
    private void loadZips() {
        // Read zipcode file line by line
        while(s.hasNextLine()) {
            final String line = s.nextLine();
            final String[] parts = line.split(",");
            final ZipCode code = new ZipCode(
                    parts[1].substring(1, parts[1].length() - 1),
                    parts[2].substring(1, parts[2].length() - 1),
                    parts[3].substring(1, parts[3].length() - 1),
                    Double.parseDouble(parts[4]),
                    Double.parseDouble(parts[5]),
                    Integer.parseInt(parts[6]));
            codes.add(code); // put z at the end of the ArrayList
        }

        // sort by the zipcode
        Collections.sort(this.codes);

    } // loadZips

    // Write a function to search for zipcode data by a zipcode
    // Return the reference to the object if found,
    // null if not found
    public ZipCode findByZip(final String code) {
        for (final ZipCode zipCode : this.codes) {
            if (code.equals(zipCode.getCode()))
                return zipCode;
        }

        return null;
    }

    // Provide a simpler interface to the binarySearch function
    public ZipCode search(final String code) {
        // return binarySearch(code, 0, codes.size() - 1);
        final int pos = Collections.binarySearch(this.codes, new ZipCode(code, "", "", 0, 0, 0));

        if(pos != -1)
            return this.codes.get(pos);
        else
            return null;
    }

    private ZipCode binarySearch(final String target, final int low, final int high) {
        if(low > high)
            return null;

        final int mid = (low + high) / 2;
        if(this.codes.get(mid).getCode().equals(target))
            return this.codes.get(mid);
        else if(this.codes.get(mid).getCode().compareTo(target) < 0)
            return binarySearch(target , mid + 1, high);
        else
            return binarySearch(target, low, mid - 1);
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

    @Override
    public ZipCode getNorthern() {
        ZipCode northest = this.codes.get(0);
        for(ZipCode code : this.codes)
            if(code.getLat() > northest.getLat())
                northest = code;

        return northest;
    }
}
