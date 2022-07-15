import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CrateJsonFile {
    public static void writeString(String json,String fileName){
        try (FileWriter file = new FileWriter(fileName)){
            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String listToJson(List<Employee> list){
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(list, listType);
        return json;
    }
}
