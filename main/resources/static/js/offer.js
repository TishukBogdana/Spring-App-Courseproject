new Vue({
    el: "#main",
    methods:{
        selectCont: function () {
            var select = document.getElementById('select');

            if(select.value==='Article'){
                document.forms.content.action="auth/article/offer";
                document.getElementById('sbm').value="Send article";

            }
            if(select.value==='News'){

                document.forms.content.action="auth/news/offer";
                document.getElementById('sbm').value="Offer news";

            }
        }
    }
})/**
 * Created by Богдана on 11.12.2017.
 */
