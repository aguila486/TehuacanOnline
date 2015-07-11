/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehuacanonline.paginas;

import Elementos.CSS;
import Elementos.ElementoHtml;
import Elementos.Script;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BasePage extends JSP {

    ArrayList<ElementoHtml> js, css;
    Settings _settings;

    public BasePage(Settings settings) {
        js = new ArrayList<ElementoHtml>();
        css = new ArrayList<ElementoHtml>();

        _settings = settings;

    }

    public ElementoHtml getMeta() {
        ElementoHtml meta = new ElementoHtml("meta");
        meta.setStringElementoHTML("<%s %s> %s");
        meta.agregaAtributo("http-equiv", "Content-Type");
        meta.agregaAtributo("content", "text/html; charset=UTF-8");
        return meta;

    }
    
    @Override
    public ElementoHtml createHeader(){
        ElementoHtml header = new ElementoHtml("header");
        return header;
    }

    @Override
    public ElementoHtml creaHead() {

        ElementoHtml header = new ElementoHtml("head");
        header.AppendChild(getMeta());

        for (ElementoHtml element : css) {
            header.AppendChild(element);
        }
        for (ElementoHtml element : js) {
            header.AppendChild(element);
        }
        
        ElementoHtml title = new ElementoHtml("title");
        title.setText("Campaign Management");

        header.AppendChild(title);
        return header;
    }

    @Override
    public ElementoHtml creaBody() {
        return null;
    }

    @Override
    public void setContentTypeHtml() {

    }

    @Override
    public void setDocTypeHtml() {

    }

    @Override
    public void addJS(String javs) {
        Script javas = new Script(javs);
        js.add(javas);
    }

    @Override
    public void addCss(String cs) {
        CSS javas = new CSS(cs);
        css.add(javas);

    }

    @Override
    public void renderPage() {
        String htmlstr = "<!DOCTYPE HTML>";
        ElementoHtml html = new ElementoHtml("html");
        html.AppendChild(creaHead());
        html.AppendChild(creaBody());
        try {
            _settings.getStream().println(html.GetHTML());
        } catch (IOException ex) {
            Logger.getLogger(BasePage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}