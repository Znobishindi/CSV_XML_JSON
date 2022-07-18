import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JsonRead {
    public static String readString(String fileName) {
        String p = null;
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = br.readLine()) != null) {
                list.add(s);
            }
            p = String.join("", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static List<Employee> jsonToList(String json) {
        JSONParser jp = new JSONParser();
        List<Employee> list = new ArrayList<>();
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            Type type = new TypeToken<List<Employee>>() {
            }.getType();
            list = gson.fromJson(json, type);

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return list;
    }
}
