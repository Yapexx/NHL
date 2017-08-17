package data_getter;

import pojo.*;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

/**
 * Created by yannx_000 on 18/06/2017.
 */
public class JsonTools {
    protected JsonReader reader;

    public JsonTools(JsonReader reader) {
        this.reader = reader;
    };

    public boolean findName(String name) throws IOException {
        boolean find = false;
        String tokenType;
        while ( !find ) {
            tokenType = reader.peek().name();
            switch (tokenType) {
                case "BEGIN_ARRAY":
                    reader.beginArray();
                    break;
                case "END_ARRAY":
                    reader.endArray();
                    break;
                case "BEGIN_OBJECT":
                    reader.beginObject();
                    break;
                case "END_OBJECT":
                    reader.endObject();
                    break;
                case "NAME":
                    String test = reader.nextName();
                    find = test.equals(name);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        return find;
    }
}
