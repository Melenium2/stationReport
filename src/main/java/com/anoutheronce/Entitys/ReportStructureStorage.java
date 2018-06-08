package com.anoutheronce.Entitys;

import javax.persistence.*;

@Entity
@Table(name = "ReportStorage")
public class ReportStructureStorage
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private MeteoUser user;

    private String reportTitle;
    @Column(columnDefinition = "text")
    private String reportTable;
    private String reportAutograph;

    public ReportStructureStorage() {
    }

    public ReportStructureStorage(MeteoUser user, String reportTitle, String reportTable, String reportAutograph) {
        this.user = user;
        this.reportTitle = reportTitle;
        this.reportTable = reportTable;
        this.reportAutograph = reportAutograph;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeteoUser getUser() {
        return user;
    }

    public void setUser(MeteoUser user) {
        this.user = user;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportTable() {
        return reportTable;
    }

    public void setReportTable(String reportTable) {
        this.reportTable = reportTable;
    }

    public String getReportAutograph() {
        return reportAutograph;
    }

    public void setReportAutograph(String reportAutograph) {
        this.reportAutograph = reportAutograph;
    }
}
