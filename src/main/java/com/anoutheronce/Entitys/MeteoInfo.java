package com.anoutheronce.Entitys;

import javax.persistence.*;

@Entity
@Table(name = "MeteostationInfo")
public class MeteoInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private Long meteo_id;
    private String meteoName;
    private String country;

    public MeteoInfo()
    {

    }

    public MeteoInfo(Long meteo_id, String meteoName, String country)
    {
        this.meteo_id = meteo_id;
        this.meteoName = meteoName;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeteoName() {
        return meteoName;
    }

    public void setMeteoName(String meteoName) {
        this.meteoName = meteoName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getMeteo_id() {
        return meteo_id;
    }

    public void setMeteo_id(Long meteo_id) {
        this.meteo_id = meteo_id;
    }
}
