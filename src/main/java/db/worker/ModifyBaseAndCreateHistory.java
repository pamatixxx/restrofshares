package db.worker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyBaseAndCreateHistory {


    public static String chengeColumValue(String colum, String usrpow, String newValue) throws SQLException {
        DBWorker dbWorker = new DBWorker();
        Statement statement = dbWorker.getConnection().createStatement();

        String answer = "";

        String oldValueColum = "SELECT " + colum + "  FROM RegisterOfShares p  WHERE usrpow like '%" + usrpow + "%'";
        ResultSet rs =  statement.executeQuery(oldValueColum);
        int i  = 0;
        while (rs.next()) {
            i = rs.getInt(1);
        }
        answer+=colum +" = "+ i + ", old value chenged colum ";
        String sql = "update RegisterOfShares set " + colum + " = '" + newValue + "' WHERE usrpow like '%" + usrpow + "%'";
        statement.executeUpdate(sql);
        answer+=colum + " = " + newValue;
        return answer;
    }

    public static String addHistory(String usrpow, StringBuilder history) throws SQLException {
        DBWorker dbHistory = new DBWorker();
        Statement statement = dbHistory.getConnection().createStatement();
        String sql = "insert into ChangeHistory( history, usrpow ) values ('" + history + "' , " + usrpow + " );";
        statement.executeUpdate(sql);
        return "history add";
    }

    public static String delete(String usrpow) throws SQLException {
        DBWorker dbWorker = new DBWorker();
        Statement statement = dbWorker.getConnection().createStatement();
        String sql = "update RegisterOfShares set state = 'deleted' WHERE usrpow like '%" + usrpow + "%'";
        statement.executeUpdate(sql);
        return "deleted";
    }
}
