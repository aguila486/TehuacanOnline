/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehuacanonline.paginas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

public class Settings {
    public Variables variables;
    private HttpServletRequest _request;
    private JspWriter _stream;
    private String urlServer;

    public Settings(HttpServletRequest request, JspWriter out){
        variables = new Variables(request);
        _request = request;
        _stream = out;
        urlServer = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();        
    }

    public HttpServletRequest getRequest() {
        return _request;
    }

    public JspWriter getStream() {
        return _stream;
    }

    public String UrlServer() {
        return urlServer;
    }

    public String getVariable(String name) {
        if (variables.GetVariables().containsKey(name.toUpperCase())) {
            return variables.GetVariables().get(name.toUpperCase()).replace("vacioquitar", "");
        }
        return "";
    }

    public String getVariableRequest(String name) {
        if (_request.getParameter(name) != null) {
            return _request.getParameter(name).replace("vacioquitar", "");
        }
        return "";
    }

    public String getVariableRequestNumero(String name) {
        if (_request.getParameter(name) != null) {

            if (!_request.getParameter(name).replace("vacioquitar", "").equals("")) {
                return _request.getParameter(name).replace("vacioquitar", "");
            } else {
                return "-1";
            }
        }
        return "";
    }

    public String getVariableRequestEspacio(String name) {
        if (_request.getParameter(name) != null) {
            return _request.getParameter(name).replace("vacioquitar", "");
        }
        return "vacio";
    }

    public void setVariable(String name, String valor) {
        if (variables.GetVariables().containsKey(name.toUpperCase())) {
            variables.GetVariables().put(name.toUpperCase(), valor);
        }
    }

    public void addVariable(String name, String valor) {
        variables.GetVariables().put(name.toUpperCase(), valor);
    }
}