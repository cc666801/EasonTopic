package topic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class UrlDataFactory {
    String url;

    public UrlDataFactory(String url) {
        this.url = url;
    }

    public URL getUrl() {
        try {
            URL urlByThisUrl = new URL(url);
            return urlByThisUrl;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String[]> getData(URL urlByThisUrl) {
        ArrayList<String[]> data = new ArrayList<>();
        String line;

        try (InputStream openStream = urlByThisUrl.openStream();
             // wrapping the urlconnection in a bufferedreader
             BufferedReader bufferedReader = new BufferedReader(new
                                            InputStreamReader(openStream));) {
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line.split(","));
            }
            return (data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
