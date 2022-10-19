package com.gmail.klewzow;

import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
@Component
public class SaxParser extends DefaultHandler {
    private String status;
    private List<Element> elements;
    private Element element;
    private long check = 0;

    public SaxParser() {
        this.element = new Element();
        this.elements = new ArrayList<>();
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.status = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.status = "";
        if(check == 5000){
            return;
        }
        if(qName.equals("foreign_names") && element.getName() != null ) {
            elements.add(element);
            element = new Element();
        }
        check+=1;

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);

        if (this.status.equals("name")) {
            element.setName(text);

        }
        if (this.status.equals("meaning")) {
            element.setMeaning(text);

        }
        if (this.status.equals("gender")) {
            element.setGender(text);
        }
        if (this.status.equals("origin")) {
            element.setOrigin(text);
        }
        if (this.status.equals("PeoplesCount")) {
            element.setPeoplesCount(text);
        }
        if (this.status.equals("WhenPeoplesCount")) {
            element.setWhenPeoplesCount(text);
        }
        if (this.status.equals("Source")) {
            element.setSource(text);
        }

    }
}
