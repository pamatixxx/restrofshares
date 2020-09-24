package io.sudarykov.liqubasefirs;


import com.fasterxml.jackson.databind.ObjectMapper;
import db.worker.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


@RestController
@RequestMapping("registerofshares")
public class Controller {

    @Autowired
    private RegisterOfSharesRepository registerOfSharesRepository;

    @PostMapping("registerofshares")
    public String createRegisterOfShares(@RequestParam String usrpow, @RequestParam int count, @RequestParam int parvalue, @RequestParam String daterelease) {

        int totalparvalue = parvalue * count;
        String state = "active";
        registerOfSharesRepository.save(new RegisterOfShares(usrpow, count, totalparvalue, parvalue, daterelease, state));
        registerOfSharesRepository.toString();

        return " Saved succesfully";
    }


    @PostMapping("modify")
    public String modifyRegisterOfShares(@RequestBody String object) throws IOException, SQLException {
        String jsonString = object;
        StringReader stringReader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();
        JSONDetectAutoIntoFile jsonDetectAutoIntoFile = mapper.readValue(stringReader, JSONDetectAutoIntoFile.class);

        StringBuilder result = new StringBuilder("modify colum ");
        //  sb.append(", usrpow='").append(usrpow).append('\'');
        if (jsonDetectAutoIntoFile.usrpow != null) {
            if (jsonDetectAutoIntoFile.parvalue != null) {
                result.append(ModifyBaseAndCreateHistory.chengeColumValue("parvalue", jsonDetectAutoIntoFile.usrpow, jsonDetectAutoIntoFile.parvalue.toString()));
                result.append('\n');
            }
            if (jsonDetectAutoIntoFile.daterelease != null) {
                result.append(ModifyBaseAndCreateHistory.chengeColumValue("daterelease", jsonDetectAutoIntoFile.usrpow, jsonDetectAutoIntoFile.daterelease));
                result.append('\n');
            }
            if (jsonDetectAutoIntoFile.count != null) {
                result.append(ModifyBaseAndCreateHistory.chengeColumValue("count", jsonDetectAutoIntoFile.usrpow, jsonDetectAutoIntoFile.count.toString()));
                result.append('\n');
            }
            ModifyBaseAndCreateHistory.addHistory(jsonDetectAutoIntoFile.usrpow, result);

        } else return result + " error, not usrpow";


        return result + " success";
    }


    @GetMapping("usrpow")
    public Iterable<RegisterOfShares> getAllusrpow() {
        return registerOfSharesRepository.findAll();

    }

    @RequestMapping(value = {"/usrpow", "/usrpow/{id}"},produces = "application/json")
    public ArrayList<Object> getArticle(@PathVariable(name = "id") Integer articleId) throws SQLException, IOException {

        DBWorker dbWorker = new DBWorker();
        Statement statement = dbWorker.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT  *  FROM RegisterOfShares p  WHERE usrpow like '%" + articleId + "%'");

        return  JSONReadFromFile.convertHasMap(resultSet);
    }

    @RequestMapping(value = {"/state", "/state/{state}"},produces = "application/json")
    public ArrayList<Object> getState(@PathVariable(name = "state") String articleId) throws SQLException, IOException {

        DBWorker dbWorker = new DBWorker();
        Statement statement = dbWorker.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT  *  FROM RegisterOfShares p  WHERE state like '%" + articleId + "%'");

        return  JSONReadFromFile.convertHasMap(resultSet);
    }

    @GetMapping("delete")
    public String deleteUsrpow(@RequestParam String usrpow) throws SQLException {
        ModifyBaseAndCreateHistory.delete(usrpow);
        return "deleted";
    }

}

