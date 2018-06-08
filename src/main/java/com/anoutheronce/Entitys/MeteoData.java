package com.anoutheronce.Entitys;

import javax.persistence.*;

@Entity
@Table(name = "MeteoReports")
public class MeteoData
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meteo_id")
    private MeteoInfo meteoInfo;
    private Integer presure;
    private Integer temperature;

    @Enumerated(EnumType.STRING)
    private WindDirection windDirection;

    public MeteoData()
    {

    }

    public MeteoData(MeteoInfo meteoInfo, Integer presure, Integer temperature, WindDirection windDerrection) {
        this.meteoInfo = meteoInfo;
        this.presure = presure;
        this.temperature = temperature;
        this.windDirection = windDerrection;
    }

    public MeteoInfo getMeteoInfo() {
        return meteoInfo;
    }

    public void setMeteoInfo(MeteoInfo meteoInfo) {
        this.meteoInfo = meteoInfo;
    }

    public Integer getPresure() {
        return presure;
    }

    public void setPresure(Integer presure) {
        this.presure = presure;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public WindDirection getWindDerrection()
    {
        return windDirection;
    }

    public void setWindDerrection(WindDirection windDerrection) {
        this.windDirection = windDerrection;
    }
}
