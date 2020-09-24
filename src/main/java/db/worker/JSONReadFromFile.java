package db.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class JSONReadFromFile {

    public static void addFromFile() throws IOException, SQLException {
        JSONDetectAutoIntoFile jsonDetectAutoIntoFile = new ObjectMapper().readValue(new FileReader("/Users/Судариков Сергей/Desktop/Java/json.json"), JSONDetectAutoIntoFile.class);

        DBWorker worker = new DBWorker();

        Statement statement = worker.getConnection().createStatement();


        String sql = "insert into registerofshares( count, daterelease, parvalue,state ,totalparvalue,usrpow ) values" + " (" + jsonDetectAutoIntoFile.count + "," + jsonDetectAutoIntoFile.daterelease + "," + jsonDetectAutoIntoFile.parvalue + ",'" + jsonDetectAutoIntoFile.state + "'," + jsonDetectAutoIntoFile.totalparvalue + ",'" + jsonDetectAutoIntoFile.usrpow + "'" + ");";
        statement.executeUpdate(sql);
    }


    public JSONReadFromFile() throws IOException {
    }


    public static JSONObject parseJSON(ResultSet resultSet) throws SQLException {
        List<JSONObject> jsonObjects = new ArrayList<>();
        ResultSetMetaData rsMeta = resultSet.getMetaData();
        int columCount = rsMeta.getColumnCount();
        List<String> columNames = new ArrayList<>();
        for (int i = 1; i < columCount; i++) {
            columNames.add(rsMeta.getColumnName(i));
        }

        while (resultSet.next()) {
            JSONObject obj = new JSONObject();
            for (int i = 1; i < columCount; i++) {
                String key = columNames.get(i - 1);
                String value = resultSet.getString(i);
                obj.put(key, value);
            }
            jsonObjects.add(obj);
        }
        return (JSONObject) jsonObjects;
    }

    public static String parseJSONtoString(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsMeta = resultSet.getMetaData();
        int columCount = rsMeta.getColumnCount();
        List<String> columNames = new ArrayList<>();
        for (int i = 1; i < columCount; i++) {
            columNames.add(rsMeta.getColumnName(i));
        }
        String result = "{\n";
        while (resultSet.next()) {

            for (int i = 1; i < columCount; i++) {
                String key = columNames.get(i - 1);
                String value = resultSet.getString(i);
                result += "\"" + key + "\":\"" + value + "\"\n";
            }
        }
        result += "\n}";

        return result;
    }

    public static ArrayList<Object> convertHasMap(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsMeta = resultSet.getMetaData();

        int columCount = rsMeta.getColumnCount();

        System.out.println(columCount);
        List<String> columNames = new ArrayList<>();
        for (int i = 1; i <= columCount; i++) {
            columNames.add(rsMeta.getColumnName(i));
            //    System.out.println(columNames);
            //  System.out.println(columCount);
        }

        ArrayList<Object> map = new ArrayList<Object>();
        //   System.out.println(columCount);
        while (resultSet.next()) {
            int con = 1;
            HashMap hashMap = new HashMap();
            for (int i = 1; i <= columCount; i++) {
                if (columNames.get(i - 1).equals("id")) {
                } else {
                    String key = columNames.get(i - 1);

                    String value = resultSet.getString(i);
                    hashMap.put(key, value);
                }

            } map.add(hashMap);
        }
        return  map;

    }
}

