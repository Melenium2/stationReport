package com.anoutheronce.Service;

import com.anoutheronce.Entitys.MeteoData;
import com.anoutheronce.Entitys.MeteoInfo;
import com.anoutheronce.Entitys.Repository.DataRepos;
import com.anoutheronce.Entitys.Repository.InfoRepos;
import com.anoutheronce.Entitys.WindDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeteoDataService
{
    @Autowired
    private DataRepos dataRepos;
    @Autowired
    private InfoRepos infoRepos;


    public MeteoDataService()
    {

    }

    public Iterable<MeteoData> getAllDataFromTable()
    {
        return dataRepos.findAll();
    }


    public boolean addDataToTable(String meteoId, Integer pressure, Integer temperature, String windDirection)
    {
        MeteoInfo meteoInfo = infoRepos.findByMeteoName(meteoId);
        MeteoData meteoData = new MeteoData(meteoInfo, pressure, temperature, WindDirection.valueOf(windDirection));
        dataRepos.save(meteoData);

        return true;
    }
}
