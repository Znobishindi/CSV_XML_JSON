import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
// Задание 1

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = CsvToJson.parseCSV(columnMapping, fileName);
        String json = CrateJsonFile.listToJson(list);
        CrateJsonFile.writeString(json, "data1.json");

// Задание 2
        List<Employee> list1 = XmlToJson.parseXML("data.xml");
        String json1 = CrateJsonFile.listToJson(list1);
        CrateJsonFile.writeString(json1, "data2.json");

// задание 3 пришлю позднее
        String json2 = JsonRead.readString("new_data.json");
        List<Employee> list2 = JsonRead.jsonToList(json2);
        System.out.println(list2);
    }
}

