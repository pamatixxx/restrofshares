package io.sudarykov.liqubasefirs;

import db.worker.JSONReadFromFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

import java.sql.SQLException;


@SpringBootApplication
public class LiqubaseFirsApplication {

    public static void main(String[] args) throws IOException, SQLException {
        SpringApplication.run(LiqubaseFirsApplication.class, args);
       JSONReadFromFile.addFromFile();
    }

}
