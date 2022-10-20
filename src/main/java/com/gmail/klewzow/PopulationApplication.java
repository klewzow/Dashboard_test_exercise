package com.gmail.klewzow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

 @SpringBootApplication
public class PopulationApplication {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
         SpringApplication.run(PopulationApplication.class, args);
    }



}
