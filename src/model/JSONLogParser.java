package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON files.
 */
public class JSONLogParser implements LogParser {
    @Override
    public List<Log> parse(String filePath) throws IOException {
        List<Log> logEntries = new ArrayList<>();
        Path file = Path.of(filePath);

        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line.trim());
            }
        }

        // Remove the brackets at the start and end
        String content = json.toString().replace("[", "").replace("]", "").trim();
        String[] entries = content.split("},\\s*\\{");

        for (String entry : entries) {
            entry = entry.replace("{", "").replace("}", "").trim();
            String[] fields = entry.split(",\\s*");
            int id = 0, points = 0;
            String mitgliedsname = null, ereignis = null;
            House house = null;

            for (String field : fields) {
                String[] keyValue = field.split(":");
                String key = keyValue[0].replace("\"", "").trim();
                String value = keyValue[1].replace("\"", "").trim();

                switch (key) {
                    case "id":
                        id = Integer.parseInt(value);
                        break;
                    case "Mitgliedsname":
                        mitgliedsname = value;
                        break;
                    case "model.Haus":
                        haus = Haus.valueOf(value.toUpperCase());
                        break;
                    case "Ereignis":
                        ereignis = value;
                        break;
                    case "Datum":
                        datum = Integer.parseInt(value);
                        break;
                }
            }
            logEntries.add(new Log(id, mitgliedsname, house, ereignis, points));
        }
        return logEntries;
    }
}