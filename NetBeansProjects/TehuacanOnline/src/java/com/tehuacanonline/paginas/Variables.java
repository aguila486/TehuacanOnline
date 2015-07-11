/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tehuacanonline.paginas;

import Elementos.ElementoHtml;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.taglibs.standard.tag.common.core.Util;

public class Variables {    
    Hashtable <String, String> _variables;
    private  HttpServletRequest _request;                      
     
    public  Hashtable<String, String>  GetVariables(){
        return  _variables;
    }
     
     public  Variables(  HttpServletRequest request){         
        _request=request;
        _variables= new Hashtable<String, String>(){{ put("USUARIO", "userr"); 
                                                       put("ID_S_ROL", "1");
                                                       put("NOMBRE", "nom"); 
                                                       put("PUESTO", "29");
                                                       put("ID_S_AREA", "00");
                                                       put("ID_S_EMPRESA", "00");
                                                       put("VISTA", "100");
                                                        put("MENU_PADRE", "0");
                                                     }};   
         
        cambiaVarRequest(request.getQueryString());
     }
     
     
    public String variablesUrl(){
        String variables="";          
        Iterator it = _variables.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            variables+=e.getKey() + "=" + Util.URLEncode(e.getValue().toString(),"UTF-8") +"&";
        }         
        return variables;       
    }                    
    
    //cambia el valor de la variables con un request
    private void cambiaVarRequest(String reqvar){
        if(reqvar != null && reqvar.length()!=0){
            for(int ps= 0; ps< reqvar.split("&").length;ps++){            
                String variablecom=reqvar.split("&")[ps];                                               
                if(_variables.containsKey(variablecom.split("=")[0].toUpperCase())){
                    String keyn= reqvar.split("&")[ps].split("=")[0].toUpperCase();
                    try {
                        _variables. put(keyn, URLDecoder.decode(reqvar.split("&")[ps].split("=")[1], "UTF-8")  );
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Variables.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }         
    }          
    
    public String  PintaVAr(){
        ElementoHtml table = new ElementoHtml("table");         
        ElementoHtml td, tr;
        for(String var : _variables.keySet()){                          
            tr= new ElementoHtml("tr");
            td=new ElementoHtml("td");
            td.setText(var);
            tr.AppendChild(td);
             
            td.setText(_variables.get(var));
            tr.AppendChild(td);
            table.AppendChild(tr);
        }
        return table.GetHTML();                 
    }    
}