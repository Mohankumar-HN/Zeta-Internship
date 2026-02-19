var a =10;
a="hello";
console.log(a);

function add(){
    console.log(arguments);
    var sum=0;
    for(let i=0;i<arguments.length;i++){
        sum+=arguments[i];
    }
    return sum;
}
const result=add(10,20,30,40,5);
console.log(result);