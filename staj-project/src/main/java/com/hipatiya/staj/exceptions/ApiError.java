package com.hipatiya.staj.exceptions;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ApiError {
    private String id;
    private Date errorTime;
    private Map<String, List<String>> errors;

    public ApiError (){}

    public ApiError (String id, Date errorTime, Map<String, List<String>> errors){
        this.errors=errors;
        this.errorTime=errorTime;
        this.id=id;
    }

    public Map<String, List<String>> getErrors() {return errors;}
    public void setErrors(Map<String, List<String>> errors) {this.errors = errors;}

    public Date getErrorTime() {return errorTime;}
    public void setErrorTime(Date errorTime) {this.errorTime = errorTime;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}


}

