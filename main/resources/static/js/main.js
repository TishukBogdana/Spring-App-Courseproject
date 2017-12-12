/**
 * Created by Богдана on 11.12.2017.
 */
new Vue({
    el: '#comments',
    created: function () {
        var art =  document.querySelector("div.cmt");
       art.style.textAlign="center";
        fetch("http://localhost:8080/tvcom/getall",{
                method:'GET'
            }
        ).then(function (resp) {
            return resp.json();
        }).then(function (commemt){

            var txt = document.createElement("div");
            txt.innerHTML = "HollyWars";
            txt.style.fontSize = "14pt";
            txt.style.fontWeight = "500";
            txt.style.color = "#761c19";
            art.appendChild(txt);
            for(var i =0;i<commemt.length;i++){

                var cont = document.createElement("div");
                cont.className = "article";

                cont.innerHTML = commemt[i].content;
                cont.style.fontWeight=400;
                cont.style.fontSize = 14;

                art.appendChild(cont);


            }
            var form = document.createElement("form");
            var npt = document.createElement("input");
            var sbm =document.createElement("input");
            sbm.type="submit";
            npt.type="text";
            sbm.value="send comment";
            npt.placeholder = "Add your comment";
            npt.name="content";
            form.method="post";
            form.action= "auth/tvcom/add";
            form.appendChild(npt);
            form.appendChild(sbm);
            art.appendChild(form);
        })
    }


});