$(function(){
    $.getJSON('mimi/top10', function(data) {
        for(let i=0;i<data.length;i++){

            let clickRenderArr = [];
            clickRenderArr.push(`<td style="font-size: 32px">${i+1}</td> <td><img src="img/${data[i].imageName}"></td> <td style="font-size: 20px">${data[i].name}</td>`)
            $("<tr/>", {
                "class": "top-list",
                html: clickRenderArr.join("")
            }).appendTo("#images");
        }
    });
});