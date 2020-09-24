package db.worker;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.FileReader;

@JsonAutoDetect
public class JSONDetectAutoIntoFile {


    public String usrpow;
    public Integer parvalue;
    public Integer count;
    public Integer totalparvalue;
    public String daterelease;
    public String state;

    JSONDetectAutoIntoFile(){}

    public JSONDetectAutoIntoFile(FileReader fileReader) {
    }

    public JSONDetectAutoIntoFile(Object object) {
    }
}

