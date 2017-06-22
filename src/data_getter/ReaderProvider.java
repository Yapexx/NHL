package data_getter;

import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by stagiaire3 on 22/06/2017.
 */
public class ReaderProvider {
    String url;
    JsonReader reader;

    ReaderProvider(String url) throws IOException{
        this.url = url;
        urlToJsonReader();
    }

    public JsonReader getReader() {
        return (this.reader);
    }

    private void urlToJsonReader() throws IOException {
        URL oracle = new URL(this.url);
        URLConnection connect = oracle.openConnection();
        InputStream inputLine = connect.getInputStream();
        this.reader = new JsonReader(new InputStreamReader(inputLine));
    }

}
