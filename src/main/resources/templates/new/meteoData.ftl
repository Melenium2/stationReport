<#import "parts/common.ftl" as c>

<@c.page>
<!-- css file for template -->
<style><#include "style/dataPageStyle.css" /></style>
<!-- center template -->

<div id="content" class="mt-4 ml-5">
  <form method="post" action="/addDataToTable">
    <div class="form-group row">          
      <label for="meteoChange" class="col-sm-3 col-form-label">Chose station</label>
      <div class="col-sm-4">
        <select class="custom-select" id="meteoChange" onchange=f('meteoChange','meteoInfo')>
          <option value="" selected hidden disabled>Chose meteostation</option>
          <#list tableData as data>
          <option value="">${data.meteoName}</option>
          <#else >
          <option value="">No data in db</option>
          </#list>
        </select>
      </div>
    </div>
    
    <div class="form-group row">
      <label for="pressure" class="col-sm-3 col-form-label">Input pressure: </label>
      <div class="col-sm-5">
        <input type="text" class="form-control" name="pressure"  placeholder="Input presure" id="pressure" oninput="interupt()"/>
      </div>
    </div>
    
    <div class="form-group row">   
      <label for="temperature" class="col-sm-3 col-form-label">Input temperature: </label> 
      <div class = "col-sm-5">
        <input type="text"  class="form-control" name="temperature" placeholder="Input temperature" id="temperature" oninput="interupt()"/></label>      
      </div>      
    </div>
    
    <div class="form-group row">
      <label for="directions" class="col-sm-3 col-form-label">Chose wind direction</label>
      <div class="col-sm-4">
        <select class="custom-select" id="directions" onclick="f('directions','directionResult')">
          <option value="" selected hidden disabled>None</option>
          <#list directions as data>
          <option value="">${data}</option>
          <#else >
          <option value="">No data in db</option>
          </#list>
        </select>
      </div>
    </div>
    
    <div class="form-group row">
      <div class="col-sm-6">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary" disabled="disabled" id="buttonGo">Add to table</button>
      </div>
    </div>
    
    <input type="hidden" id="meteoInfo" name="meteoId" onchange="interupt()"/>
    <input type="hidden" id="directionResult" name="directionName" onchange="interupt()"/>
  </form>
  
  <div class="mt-5 style-for-cards" id="nameFilter">
    <a class="btn btn-success" data-toggle="collapse" href="#filterByName" role="button" aria-expended="false" aria-controls="filterByName">Filter by name(dw)</a>
    <div id="filterByName" class="collapse">
      <div class="card card-body">
        <form method="post" action="filter">
          <div class="form-group row">
            <label for="inputFilter" class="col-sm-3 col-form-label">Enter filter</label>
            <div class="col-sm-9">
              <input type="text" class="form-control" name="inputFilter" placeholder="Input filter" id="filter"/>
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-5">
              <input type="hidden" name="_csrf" value="${_csrf.token}" />
              <button type="submit" class="btn btn-outline-success">Search</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="mt-3 style-for-cards" id="formDelete">
      <a class="btn btn-success" data-toggle="collapse" href="#deleteById" role="button" aria-expanded="false" aria-controls="deleteById">Delete by id(dw)</a>
      <div id="deleteById" class="collapse">
        <div class="card card-body">
          <form method="post" action="delete">
            <div class="form-group row">
              <label for="inputDelete" class="col-sm-3 col-form-label">Enter id</label>
              <div class="col-sm-9">
                <input type="text" class="form-control" name="delete" id="inputDelete" placeholder="Delete Id">            
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-5">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-outline-success">Delete</button>
              </div>
            </div>
          </form>
        </div>    
      </div>
    </div>
  </div>
  
  <div id="tableContent">
    <table id="reportTable" class="table table-bordered table-hover">
      <thead class="thead-dark">
        <tr>
          <th align="center" scope="col"><b>Meteostation name</b></th>
            <th align="center" scope="col"><b>Pressure</b></th>
              <th align="center" scope="col"><b>Temperature (*C)</b></th>
                <th align="center" scope="col"><b>Wind direction</b></th>
                </tr>
              </thead>
              <tbody>
                <#list content as data>
                <tr>
                  <td align="center"><span>${data.meteoInfo.meteoName?if_exists}</span></td>
                  <td align="center"><span>${data.presure?if_exists}</span></td>
                  <td align="center"><span>${data.temperature?if_exists}</span></td>
                  <td align="center"><span>${data.windDerrection?if_exists}</span></td>
                </tr>
                <#else >
                <td colspan="4" align="center">No data in db</td>
                </#list>
              </tbody>
            </table>
          </div>
          
          <!-- scripts -->
          <script type="text/javascript">
          <#include "script/textSelector.js"/>
          </script>
          
          <script type="text/javascript">
          <#include "script/interupt.js"/>
          </script>
          
          
          
          
          </@c.page>