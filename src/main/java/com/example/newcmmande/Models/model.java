package com.example.newcmmande.Models;

import com.example.newcmmande.Views.viewFactory;

public class model {
    private static model mdl;
    private final viewFactory viewfactory;


    public model() {
        this.viewfactory = new viewFactory();
    }
    public static synchronized model getInstance(){
        if(mdl==null){
            mdl=new model();
        }
        return mdl;
    }
    public viewFactory getViewfactory(){
        return viewfactory;
    }
}
