function StateDtl()
{
    let countryId =  document.getElementById("country").value ;

    let parameters = {
        country: countryId
    };
    $.getJSON("/getState", parameters , function(data) {
        let htmltag = "";
        htmltag +="<table class='table table-striped' style='width:100%'>";
        htmltag +="<thead>";
        htmltag +="<tr>";
        htmltag +="<th>State</th>";
        htmltag +=" </thead>";
        for(let i=0;i<data.length;i++)
        {
            htmltag +="<tr>";
            htmltag +="<td><form>";
            htmltag +="<input   class='form-control' size='35' name='dataType' type='text' value="+data[i].stateName+"  ></td>";
            htmltag +="</form>";
            htmltag +="</tr>";
        }
        htmltag +="</table>";
        document.getElementById("dataDiv").innerHTML = htmltag;

    });

}