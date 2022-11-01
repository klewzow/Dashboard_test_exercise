package com.gmail.klewzow.html.PageNavigation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


public class Button {
    private int pNumb;
    private String prect ="...";
    private  boolean active = false;
    public Button() {
    }

    public Button(int pNumb) {
        this.pNumb = pNumb;
    }

    public int getpNumb() {
        return pNumb;
    }

    public void setpNumb(int pNumb) {
        this.pNumb = pNumb;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
