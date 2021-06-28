// Friends muss noch gegen events oder event augetauscht werden
// const  apiURL = "http://localhost:8080/api/twitter";
var app = new Vue ({
    el: '#app',
    data() {
        return{
            events: []
        }
    },
    created() {
        fetch(apiURL)
            .then((response => {
                return response.json();
            })
                .then(events => {
                    this.events = events;
                }))
    }
})
//
// var app = new Vue({
//     el: '#app',
//     data: {
//         message: 'Hello Vue!'
//     }
// })