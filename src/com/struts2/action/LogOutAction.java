package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogOutAction extends ActionSupport {
    public String execute()	{
        log.info("Called LogOutAction");
        return "success";
    }
}
