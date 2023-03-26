package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
    public String heavenMenu()	{
        return "heaven";
    }
    public String waterfallMenu()	{
        return "waterfall";
    }
    public String addUserMenu(){
        return "addUser";
    }
}
