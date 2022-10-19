package com.gmail.klewzow.Controllers;

import com.gmail.klewzow.Repositoties.UserRepository;
import com.gmail.klewzow.SaxParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String indexPage() throws ParserConfigurationException, SAXException, IOException {
//        File xml = new File("./foreign_names.xml");
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        SaxParser sp = new SaxParser();
//        parser.parse(xml, sp);
//            userRepository.saveAll(sp.getElements());


        return "index";
    }
}
