package com.anoutheronce.Service;

import com.anoutheronce.Entitys.JsonModels.ReportStructureForDb;
import com.anoutheronce.Entitys.JsonModels.TableCretaria;
import com.anoutheronce.Entitys.MeteoData;
import com.anoutheronce.Entitys.MeteoUser;
import com.anoutheronce.Entitys.ReportStructureStorage;
import com.anoutheronce.Entitys.Repository.DataRepos;
import com.anoutheronce.Entitys.Repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportStructureService
{
    @Autowired
    private DataRepos dataRepos;

    @Autowired
    private ReportRepo reportRepo;

    public Map<String, List<String>> createTableForAjaxScript(TableCretaria cretaria)
    {
        Iterable<MeteoData> object = dataRepos.findAll();

        List<String> msName = new ArrayList<>();
        List<String> msPressure = new ArrayList<>();
        List<String> msTemp = new ArrayList<>();
        List<String> msDirection = new ArrayList<>();

        Map<String, List<String>> result = new HashMap<>();

        if (cretaria.getMsName().equals("true"))
        {
            for (MeteoData md : object)
            {
                msName.add(md.getMeteoInfo().getMeteoName());
            }
            result.put("1", msName);
        }

        if (cretaria.getMsPressure().equals("true"))
        {
            for (MeteoData md : object)
            {
                msPressure.add(md.getPresure().toString());
            }
            result.put("2", msPressure);
        }

        if (cretaria.getMsTemp().equals("true"))
        {
            for (MeteoData md : object)
            {
                msTemp.add(md.getTemperature().toString());
            }
            result.put("3", msTemp);
        }

        if (cretaria.getMsDirection().equals("true"))
        {
            for (MeteoData md : object)
            {
                msDirection.add(md.getWindDerrection().name());
            }
            result.put("4", msDirection);
        }

        return result;
    }

    public void addReportFormToTable(MeteoUser user, ReportStructureForDb structure)
    {
        ReportStructureStorage storage = new ReportStructureStorage(user,
                                                                    structure.getTitle(),
                                                                    structure.getTable(),
                                                                    structure.getAutograph());

        reportRepo.save(storage);
    }
}
