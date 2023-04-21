package cherry.cworld.awsproxyrds.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
    public static String jsonToString(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }
}
