/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehuacanonline.paginas;

import Elementos.Div;
import Elementos.ElementoHtml;
import Elementos.Input;
import Elementos.Span;

public class LoginPage extends BasePage {

    public LoginPage(Settings settings) {        
        super(settings);
        addCss("/repositorio/TehuacanOnline/css/reset.css");
        addCss("/repositorio/TehuacanOnline/css/estilos.css");        
        //addJS("/respositorio/js/jquery/jquery.min.js");
        
    }
        
    @Override public ElementoHtml   creaBody(){
        ElementoHtml body = new ElementoHtml("body");
        body.setID("bodie");
        ElementoHtml form = new ElementoHtml("form");
        form.setID("frmCC");
        form.agregaAtributo("method", "post");
        form.agregaAtributo("action", "login.jsp");
        form.agregaAtributo("name", "frmCC");
        Div mainWrapper = new Div("", "mainWrapper");
        Div header = new Div("","","header");
        ElementoHtml title = new ElementoHtml("h2");
        title.setText("Tehuacan Online");
        header.AppendChild(title);
        Div contenedorPrincipal = new Div("", "contenedorPrincipal");
        Div loginWrapper = new Div("", "loginWrapper"); 
        Div loginTitle = new Div("","", "loginTitle"); 
        loginWrapper.AppendChild(loginTitle);                                        
        Div campaignLogin = new Div(); 
        loginWrapper.AppendChild(campaignLogin);                                        
        Div loginForm = new Div("","", "loginForm");
        Div usuarioLog = new Div("","", "usuarioLog"); 
        Input inp= new Input("text","usuario", "usuario");
        inp.agregaAtributo("placeholder", "Número de empleado:");
        usuarioLog.AppendChild(inp);
        loginForm.AppendChild(usuarioLog);
        Div llaveLog = new Div("","", "llaveLog"); 
        inp= new Input("password", "password", "password","pass1" );
        inp.agregaAtributo("placeholder", "Password:");
        llaveLog.AppendChild(inp);
        loginForm.AppendChild(llaveLog);       
        loginWrapper.AppendChild(loginForm);
        Div loginLogo = new Div("","", "loginLogo"); 
        loginWrapper.AppendChild(loginLogo);
        ElementoHtml anchor = new ElementoHtml("A", "", "inicioBtn");
        anchor.agregaAtributo("href", "javascript:verificaForm();");
        contenedorPrincipal.AppendChild(header);
        contenedorPrincipal.AppendChild(loginWrapper);
        contenedorPrincipal.AppendChild(anchor);
        mainWrapper.AppendChild(contenedorPrincipal);                           
        form.AppendChild(mainWrapper);
        body.AppendChild(form);
        return body;
    }
}
