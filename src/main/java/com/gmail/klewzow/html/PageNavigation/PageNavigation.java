package com.gmail.klewzow.html.PageNavigation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PageNavigation {
    private final int MAX_PAGE = 6;
    private List<Button> btn;
    private int value;
    private final int MAX_BUTTON=5;

    public PageNavigation() {
    }

    public PageNavigation(int value) {
        this.value = value;
    }

    public List<Button> btnGenerate(int btnActive) {

        btn = new ArrayList<>();
        for (int i = 0; i < this.MAX_BUTTON; i++) {
            btn.add(new Button(i + 1));
            if (i == btnActive - 1) {
                btn.get(i).setActive(true);
            }
        }
        btn.add(new Button(value));
        return btn;
    }

    public List<Button> getBtn() {
        return btn;
    }

    public void setBtn(List<Button> btn) {
        this.btn = btn;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
