function render(sourceData) {
    for (let i = 0; i < 2; i++) {
        let firstRenderArr = [];
        firstRenderArr.push(`<img src="img/${sourceData[i].imageName}"><br><span >${sourceData[i].name}</span>`)
        $("<div/>", {
            "class": "my-list",
            "id": `${sourceData[i].id}`,
            html: firstRenderArr.join("")
        }).appendTo("#test");
    }
}

function choose(clickElementIndex) {
    $.ajax({
        type: "POST",
        url: "mimi/choice/" + clickElementIndex
    });
}

$(function () {
    $.getJSON("mimi/all", function (sourceData) {
        render(sourceData);

        let sliceIndex = 0;
        let sliceArray = sourceData.slice(++sliceIndex * 2, sourceData.length);

        $("#test").on("click", "div", function () {
            let clickElementIndex = $(this).attr("id");

            choose(clickElementIndex);

            $("div div").remove();

            if (sliceArray.length <= 1) {
                location.href = "top";
            }
            render(sliceArray);

            sliceArray = sliceArray.slice(sliceIndex + 1);

        })
    })
})


