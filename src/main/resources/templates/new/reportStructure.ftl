<#import "parts/common.ftl" as c/>

<@c.page>
<meta name="csrf-token" content="${_csrf.token}" >

<style>
        <#include "style/reportPageStyle.css" />
</style>

    <!-- Report structure -->
    
    <div id="left" class="mt-4 ml-5">
      <form id="inputForm">
        
        <div class="form-group row">
          <label for="titleLabel" class="col-sm-4 col-form-label">Title of report: </label>
          <div class="col-sm-6">
            <input type="text" class="form-control" name="title" id="titleLabel" placeholder="Enter report title" />
          </div>
        </div>
        
        <div class="form-group row">
          <label class="col-sm-4">Chose the colums you need: </label>
          <div class="col-sm-5">
            <div class="style-for-cards" id="choseForm">
              <a class="btn btn-outline-secondary" role="button" data-toggle="collapse" href="#choseList" aria-expanded="false" aria-control="choseList">Chose colums</a>
              <div id="choseList" class="collapse">
                <div class="card card-body" id="cardBody">
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="msName" name="meteoInfo" />
                    <label for="msName" class="form-check-label"> Meteostation name</label>
                  </div>
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="msPressure" name="pressure" />
                    <label for="msPressure" class="form-check-label"> Pressure </label>
                  </div>
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="msTemp" name="temperature" />
                    <label for="msTemp" class="form-check-label"> Temperature </label>
                  </div>
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="msDirection" name="windDirection" />
                    <label for="msDirection" class="form-check-label"> Wind direction </label>
                  </div>
                  
                  <div class="row">
                    <button type="submit" class="btn btn-secondary btn-sm" id="buttonSubmit">Update</button>
                  </div>    
                  
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="form-group row">
          <div class="col-sm-4">
            Autograph?
          </div>
          <div class="col-sm-6">
            <div class="form-check">
              <input type="checkbox" class="form-check-input" id="autographCheck" />
              <label class="form-check-label" for="autographCheck" id="autographLabel">      Yes</label>
            </div>
          </div>
        </div>
        
        <div class="form-group row">
          <label for="autograph" class="col-sm-4 col-form-label">Input your name: </label>
          <div class="col-sm-6">
            <input type="text" class="form-control" placeholder="Disabled" name="autograph" id="autograph" disabled="disabled" />
          </div>
        </div>
        
      </form>
      
      <div class="form-group row">
        <div class="col-sm-10" id="formSaveReport">
          <input type="hidden" name="_csrf" valye="${_csrf.token}" />
          <button type="submit" class="btn btn-success" id="buttonSaveReport">Save report</button>
        </div>
      </div>
      
    </div>
    
    <div id="right">
      
      <div class="form-group row rigth-align">
        <div class="col-sm-20">
          <h3 id="reportTitle"></h3>
        </div>
      </div>
      
      <div class="form-group row rigth-align mt-2">
        <div class="col-sm-20">
          <div id="reportTable" class="table table-hover">
            
          </div>
        </div>      
      </div>
      
      <div class="form-group row right-align font-famaly mt-2">
        <div class="col-sm-20 font-italic" id="reportAutograph" style="display:none">
            <i class="font-italic">Autograph_______________________  </i><i id=fioAutograph></i>
        </div>
      </div>

    </div>


<script type="text/javascript">
    <#include "script/ajax.js" />
</script>
<script type="text/javascript">
    <#include "script/textWriter.js" />
</script>
<script type="text/javascript">
    <#include "script/ajaxToDb.js" />
</script>


</@c.page>