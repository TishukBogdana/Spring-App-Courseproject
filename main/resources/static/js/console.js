/**
 * Created by Богдана on 11.12.2017.
 */
new Vue({
    el:"#app",
    created:function () {
     window.onload=function () {
         fetch('http://localhost:8080/check').then(function (resp) {


      return resp.json();
         }).then(function (data) {
             if(data===''){
                 //window.location.replace('http://localhost:8080/errorpage.html');
                // console.log(data);
                 }
             console.log(data);
         })
     }
    },
    methods: {
        getUnmoderated: function (arg, mod) {


            var art = document.querySelector("div.content");
            while(art.firstChild) art.removeChild(art.firstChild);
            var moder = "unmod";
            if (mod === 'all') {
                moder = "all";
            }
            fetch('http://localhost:8080/' + arg + '/' + moder, {method: 'GET'}).then(function (resp) {
                return resp.json();
            }).then(function (data) {

                for (var i = 0; i < data.length; i++) {

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
                    if (moder === 'unmod') {
                        var id = document.createElement("input");
                        id.name = "id";
                        id.type = "hidden";
                        if (arg === 'articles') {
                            id.value = data[i].idArticle;
                        }
                        if (arg === 'news') {
                            id.value = data[i].idNews;
                        }
                        var form = document.createElement("form");
                        form.method = "post";
                        form.action = "auth/" + arg + "/rem";
                        var btndel = document.createElement("input");
                        btndel.className="btn btn-default";
                        btndel.type = "submit";
                        btndel.value = "refuse";
                        form.appendChild(id);
                        form.appendChild(btndel);

                        var id2 = document.createElement("input");
                        id2.name = "id";
                        id2.type = "hidden";
                        if (arg === 'articles') {
                            id2.value = data[i].idArticle;
                        }
                        if (arg === 'news') {
                            id2.value = data[i].idNews;
                        }
                        var form2 = document.createElement("form");
                        form2.method = "post";
                        form2.action = "auth/" + arg + "/upd";
                        var accp = document.createElement("input");
                        accp.className="btn btn-default";
                        accp.value = "accept";
                        accp.type = "submit";
                        btndel.type = "submit";
                        form2.appendChild(id2);
                        form2.appendChild(accp);
                        tail.appendChild(form);
                        tail.appendChild(form2);
                    }
                    if (moder === 'all') {
                        var del = document.createElement("input");
                        del.value = "delete";
                        del.className="btn btn default";
                        var id3 = document.createElement("input");
                        id3.name = "id";
                        id3.type = "hidden";
                        if (arg === 'articles') {
                            id3.value = data[i].idArticle;
                        }
                        if (arg === 'news') {
                            id3.value = data[i].idNews;
                        }
                        var form3 = document.createElement("form");
                        form3.method = "post";
                        form3.action = "auth/" + arg + "/rem";
                        del.type = "submit";
                        form3.appendChild(id3);
                        form3.appendChild(del);
                        tail.appendChild(form3);
                    }

                    art.appendChild(tail);

                }
            });
        },
        getComments: function () {


            var art = document.querySelector("div.content");
            var arg;
            while(art.firstChild) art.removeChild(art.firstChild);
            if (document.getElementById('comments').value === 'Comments on articles') {
                arg = 'artcom';

            }
            if (document.getElementById('comments').value === 'Comments on news') {
                arg = 'nwscom';
            }
            if (document.getElementById('comments').value === 'Comments on series') {
                arg = 'sercom';
            }
            if (document.getElementById('comments').value === 'Comments on serisl') {
                arg = 'tvcom';
            }

            fetch("http://localhost:8080/" + arg + "/getall", {
                    method: 'GET'
                }
            ).then(function (resp) {
                return resp.json();
            }).then(function (comment) {

                var txt = document.createElement("div");

                txt.style.fontSize = "14pt";
                txt.style.fontWeight = "500";
                txt.style.color = "#761c19";
                txt.style.textAlign = "center";
                art.appendChild(txt);
                for (var i = 0; i < comment.length; i++) {

                    var cont = document.createElement("div");
                    cont.className = "article";

                    cont.innerHTML = comment[i].content;
                    cont.style.fontWeight = 400;
                    cont.style.fontSize = 14;

                    art.appendChild(cont);
                    console.log(comment[i]);
                    var form = document.createElement("form");
                    var npt = document.createElement("input");
                    var sbm = document.createElement("input");
                    sbm.type = "submit";
                    npt.type = "hidden";
                    sbm.value = "delete";
                    sbm.className="btn btn-default";
                    npt.name = "id";
                    npt.value=comment[i].id;
                    form.method = "post";
                    form.action = "auth/" + arg + "/rem";
                    form.style.marginLeft = "3%";
                    form.appendChild(npt);
                    form.appendChild(sbm);
                    art.appendChild(form);
                }

            })


        }
    }
});