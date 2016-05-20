
function MyModule() {
    var num = 0;
    return{
        ping: function(str){
            console.log(str);
            return "pong";
        },
        count: function(){
            num ++;
            return num;
        }
    };
}

window.MyModule    = MyModule;