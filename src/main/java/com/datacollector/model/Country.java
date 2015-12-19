package com.datacollector.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Formatter;

/**
 * Created by sanjay on 19/12/15.
 */
@Entity
@Table(name = "Country")
public class Country implements Model{

    @Id
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;
    @Column(name="cctld")
    private String ccTLD;
    @Column(name="year")
    private short year;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCcTLD() {
        return ccTLD;
    }

    public void setCcTLD(String ccTLD) {
        this.ccTLD = ccTLD;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String toString(String formatString) {
        //Format from the internet http://stackoverflow.com/questions/8533612/align-strings-in-columns-in-jtextarea
        return String.format(formatString
                ,
                code,
                name,year,ccTLD
        );
    }
}
