<#import "parts/common.ftl" as c>

<@c.page>
  <style><#include "style/dataPageStyle.css" /></style>
  
  <div id="content" class="mt-4 ml-5">    
    <form method="post" action="/addData">
      
      <div class="form-group row">
        <label for="inputId" class="col-sm-3 col-form-label">Meteostation ID: </label>
        <div class="col-sm-5">
          <input type="text" class="form-control" name="meteoId" id="inputId" placeholder="Enter meteostation id" required autofocus />
        </div>
      </div>
      
      <div class="form-group row">
        <label for="inputName" class="col-sm-3 col-form-label">Meteostation name: </label>
        <div class="col-sm-5">
          <input type="text" class="form-control" name="meteoName" id="inputName" placeholder="Enter meteostation name" />
        </div>
      </div>
      
      <div class="form-group row">
        <label for="inputCountry" class="col-sm-3 col-form-label">Meteostation country: </label>
        <div class="col-sm-5">
          <input type="text" class="form-control" name="country" id="inputCountry" placeholder="Enter meteostation country" />
        </div>
      </div>
      
      <div class="form-group row">
        <label class="col-sm-3 col-form-label label-danger">${message?if_exists}</label>
        <div class="sol-sm-5">
          <input type="hidden" name="_csrf" value="${_csrf.token}" />
          <button type="submit" class="btn btn-primary" id="buttonAdd">Add meteostation</button>
        </div>
      </div>
    </form>  
    
    <div class="mt-3 style-for-cards" id="deleteForm">
      <a class="btn btn-success" data-toggle="collapse" href="#deleteByName" role="button" aria-expanded="false" aria-controls="delteByName">Delete station by Name</a>
      <div class="collapse" id="deleteByName">
        <div class="card card-body">
          <form method="post" action="/delete">
            <div class="form-group row">
              <label for="inputName" class="col-sm-5 col-form-label">Meteostion name: </label>
              <div class="col-sm-7">
                <input type="text" class="form-control" id="inputName" name="meteoName" placeholder="Enter meteostion name" />
              </div>
            </div>
            <div class="form-group row">
              <div class="col-sm-4">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-outline-success" id="buttonDelete">Delete</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>  
  </div>
  
  <div id="tableContent">
    <table id="meteoInfoTable" class="table table-bordered table-hover">
      <thead class="thead-dark">
        <tr>
          <th scope="col" align="center"><b>ID</b></th>
          <th scope="col" align="center"><b>Station name</b></th>
          <th scope="col" align="center"><b>Station country</b></th>        
        </tr>
        <tbody>
          <#list tableData as data>
            <tr>
              <td>
                <span>${data.meteo_id}</span>
              </td>
              <td>
                <span>${data.meteoName}</span>
              </td>
              <td>
                <span>${data.country}</span> 
              </td>
            </tr>
          <#else>
            <b>No data</b>
          </#list>
        </tbody>
      </thead>
    </table>
  </div>

</@c.page>