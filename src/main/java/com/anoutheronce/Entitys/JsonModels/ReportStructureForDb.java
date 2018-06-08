package com.anoutheronce.Entitys.JsonModels;

public class ReportStructureForDb
{
    private String title;
    private String table;
    private String autograph;

    public ReportStructureForDb() {
    }

    public ReportStructureForDb(String title, String table, String autograph) {
        this.title = title;
        this.table = table;
        this.autograph = autograph;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
