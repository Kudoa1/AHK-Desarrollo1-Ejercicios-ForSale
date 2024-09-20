package com.ahk.arg.forsale.layouts;

import com.samskivert.mustache.Mustache;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LayoutAdvice {

    @ModelAttribute("layout")
    public Mustache.Lambda layout(){
        return new Layout();
    }
}
