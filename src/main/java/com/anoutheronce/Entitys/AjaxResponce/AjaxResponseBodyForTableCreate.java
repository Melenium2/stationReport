package com.anoutheronce.Entitys.AjaxResponce;

import java.util.List;
import java.util.Map;

public class AjaxResponseBodyForTableCreate
{
    private String message;
    private Map<String, List<String>> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, List<String>> getResult() {
        return result;
    }

    public void setResult(Map<String, List<String>> result) {
        this.result = result;
    }
}
