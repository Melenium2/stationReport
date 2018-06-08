package com.anoutheronce.Service;

import com.anoutheronce.Entitys.MeteoInfo;
import com.anoutheronce.Entitys.Repository.InfoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeteoInfoService
{
    @Autowired
    InfoRepos infoRepos;

    public MeteoInfoService()
    {

    }

    public Iterable<MeteoInfo> getAllDataFromTable()
    {
        return infoRepos.findAll();
    }
}

