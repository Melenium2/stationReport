package com.anoutheronce.Controller;

import com.anoutheronce.Entitys.MeteoInfo;
import com.anoutheronce.Entitys.Repository.InfoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class InfoPageController
{
    @Autowired
    private InfoRepos infoRepos;

    @GetMapping("/meteoInfo")
    public String defaultPage(Map<String, Object> model)
    {
        Iterable<MeteoInfo> reposAll = infoRepos.findAll();
        model.put("tableData", reposAll);

        return "new/meteoInfo";
    }
    
    @PostMapping("/addData")
    public String addInfoDbData(@RequestParam Long meteoId, @RequestParam String meteoName, @RequestParam String country, Map<String, Object> model)
    {
        if (meteoId == 0 || meteoName.isEmpty() || meteoName.endsWith(" ") || country.isEmpty() || country.endsWith(" "))
        {
            model.put("message", "Invalid data");
            displayAllDataFromTable(model);
            return "new/meteoInfo";
        }

        MeteoInfo meteoInfo = new MeteoInfo(meteoId, meteoName, country);
        infoRepos.save(meteoInfo);

        displayAllDataFromTable(model);
        return "new/meteoInfo";
    }

    @PostMapping("/delete")
    public String deleteDataFromInfoDbById(@RequestParam String meteoName, Map<String, Object> model)
    {
        infoRepos.deleteByMeteoName(meteoName);

        displayAllDataFromTable(model);
        return "new/meteoInfo";
    }

    private void displayAllDataFromTable(Map<String, Object> model)
    {
        Iterable<MeteoInfo> infoReposAll = infoRepos.findAll();
        model.put("tableData", infoReposAll);
    }
}
