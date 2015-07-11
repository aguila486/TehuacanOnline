/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehuacanonline.paginas;

import Elementos.ElementoHtml;

public abstract class JSP {

    public abstract ElementoHtml creaHead();
    public abstract ElementoHtml createHeader();
    public abstract ElementoHtml creaBody();
    public abstract void setContentTypeHtml();
    public abstract void setDocTypeHtml();
    public abstract void addJS(String js);
    public abstract void addCss(String cs);
    public abstract void renderPage();

}
