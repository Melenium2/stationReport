package com.anoutheronce.Entitys.JsonModels;

import javax.validation.constraints.NotBlank;

public class TableCretaria
{
    @NotBlank(message = "No options")
    private String msName;
    @NotBlank(message = "No options")
    private String msPressure;
    @NotBlank(message = "No options")
    private String msTemp;
    @NotBlank(message = "No options")
    private String msDirection;

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

    public String getMsPressure() {
        return msPressure;
    }

    public void setMsPressure(String msPressure) {
        this.msPressure = msPressure;
    }

    public String getMsTemp() {
        return msTemp;
    }

    public void setMsTemp(String msTemp) {
        this.msTemp = msTemp;
    }

    public String getMsDirection() {
        return msDirection;
    }

    public void setMsDirection(String msDirection) {
        this.msDirection = msDirection;
    }
}
