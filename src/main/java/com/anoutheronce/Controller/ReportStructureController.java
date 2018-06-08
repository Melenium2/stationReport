package com.anoutheronce.Controller;

import com.anoutheronce.Entitys.AjaxResponce.AjaxResponceBodyForSavingReport;
import com.anoutheronce.Entitys.AjaxResponce.AjaxResponseBodyForTableCreate;
import com.anoutheronce.Entitys.JsonModels.ReportStructureForDb;
import com.anoutheronce.Entitys.JsonModels.TableCretaria;
import com.anoutheronce.Entitys.MeteoUser;
import com.anoutheronce.Service.ReportStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class ReportStructureController
{
    @Autowired
    private ReportStructureService rsService;

     @PostMapping("/getTableProperty")
     public ResponseEntity<?> getTableResultViaAjax(@Valid @RequestBody TableCretaria cretaria, Errors errors)
     {
         AjaxResponseBodyForTableCreate result = new AjaxResponseBodyForTableCreate();

         if (errors.hasErrors()) {

             result.setMessage(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
             return ResponseEntity.badRequest().body(result);

         }

         result.setMessage("success");
         result.setResult(rsService.createTableForAjaxScript(cretaria));

         return ResponseEntity.ok(result);
     }

     @PostMapping("/jsonToDb")
     public ResponseEntity<?> putAjaxResultToDb(@AuthenticationPrincipal MeteoUser user, @Valid @RequestBody ReportStructureForDb json, Errors errors)
     {
         AjaxResponceBodyForSavingReport result = new AjaxResponceBodyForSavingReport();

         if (errors.hasErrors())
         {
             System.out.println("troubl;e");
             result.setMassage(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
             return ResponseEntity.badRequest().body(result);
         }

         rsService.addReportFormToTable(user, json);
         result.setMassage("Saving success");

         return ResponseEntity.ok(result);
     }
}
