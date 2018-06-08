package com.anoutheronce.Controller;

import com.anoutheronce.Entitys.WindDirection;
import com.anoutheronce.Service.MeteoDataService;
import com.anoutheronce.Service.MeteoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MeteoDataController
{
    @Autowired
    private MeteoDataService mdService;
    @Autowired
    private MeteoInfoService miService;

    @GetMapping("/")
    public String defaultMeteoDataPage(Model model)
    {
        return "new/homePage";
    }

    @GetMapping("/meteoData")
    public String meteoDataPage(Model model)
        {
            model.addAttribute("tableData", miService.getAllDataFromTable());
            model.addAttribute("content", mdService.getAllDataFromTable());
            model.addAttribute("directions", WindDirection.values());

        return "new/meteoData";
    }

    @PostMapping("/addDataToTable")
    public String addDataToTable(@RequestParam String meteoId,
                                 @RequestParam Integer pressure,
                                 @RequestParam Integer temperature,
                                 @RequestParam String directionName)
    {
        mdService.addDataToTable(meteoId, pressure, temperature, directionName);

        return "redirect:meteoData";
    }

}
