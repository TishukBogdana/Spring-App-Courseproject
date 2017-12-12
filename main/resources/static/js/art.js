
new Vue({
    el:"#app",
    created: function () {
        var art =  document.querySelector("div.art");
        fetch('http://localhost:8080/articles/getlast',{method:'GET'}).then(function (resp) {
            return resp.json();
        }).then(function (data) {

            for (var i=0;i<data.length;i++){

                var div = document.createElement("div");
                div.className = "article_header";
                div.style.fontSize = "20pt";
                div.style.fontWeight = "500";
                div.style.color = "#761c19";
                div.style.textAlign = "center";
                div.innerHTML = data[i].name;
                art.appendChild(div);
                var body = document.createElement("div");
                body.className = "article";

                body.innerHTML = data[i].body;
                div.style.textAlign = "center";
                art.appendChild(body);
                var tail = document.createElement("div");
                tail.className = "article";

                tail.style.fontSize = "14pt";
                tail.style.fontWeight = "500";
                tail.style.color = "#761c19";
                tail.style.textAlign = "right";
                tail.innerHTML = new Date(data[i].dateAdd);
                art.appendChild(tail);

            }
        }).then(function () {
            fetch("http://localhost:8080/artcom/getall",{
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
                txt.style.textAlign ="center";
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
                form.action= "auth/artcom/add";
                form.style.marginLeft ="3%";
                form.appendChild(npt);
                form.appendChild(sbm);
                art.appendChild(form);
            })
        })

    },
    methods:{
        getByName: function () {
            var art =  document.querySelector("div.art");
            while(art.firstChild) art.removeChild(art.firstChild);
            var com =  document.querySelector("div.com");
            while(com.firstChild) com.removeChild(com.firstChild);
            var name  = document.getElementById('begin').value;
            fetch('http://localhost:8080/articles/getname?name='+name,{method:'GET'}).then(function (resp) {
                return resp.json();
            }).then(function (data) {
                console.log(data);
                for (var i=0;i<data.length;i++){

                    var div = document.createElement("div");
                    div.className = "article_header";
                    div.style.fontSize = "20pt";
                    div.style.fontWeight = "500";
                    div.style.color = "#761c19";
                    div.style.textAlign = "center";
                    div.innerHTML = data[i].name;
                    art.appendChild(div);
                    var body = document.createElement("div");
                    body.className = "article";

                    body.innerHTML = data[i].body;
                    div.style.textAlign = "center";
                    art.appendChild(body);
                    var tail = document.createElement("div");
                    tail.className = "article";

                    tail.style.fontSize = "14pt";
                    tail.style.fontWeight = "500";
                    tail.style.color = "#761c19";
                    tail.style.textAlign = "right";
                    tail.innerHTML = new Date(data[i].dateAdd);
                    art.appendChild(tail);

                }
            })
        }

    }
});/**
 * Created by Богдана on 11.12.2017.
 */
