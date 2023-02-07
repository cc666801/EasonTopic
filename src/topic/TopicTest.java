package topic;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class TopicTest {
    public static void main(String[] args) {
        UrlDataFactory udf = new UrlDataFactory("https://data.moi.gov.tw" +
                "/MoiOD/System/DownloadFile.aspx?DATA=AC" +
                "11E4F5-8E0D-4EED-8C9A-16931B06CA17");
        URL urlByThisUrl = udf.getUrl();
        ArrayList<String[]> data = udf.getData(urlByThisUrl);
        System.out.println(data);
    }
}
