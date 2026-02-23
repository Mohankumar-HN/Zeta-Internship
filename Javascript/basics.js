// var a =10;
// a="hello";
// console.log(a);

// function add(){
//     console.log(arguments);
//     var sum=0;
//     for(let i=0;i<arguments.length;i++){
//         sum+=arguments[i];
//     }
//     return sum;
// }
// const result=add(10,20,30,40,5);
// console.log(result);

let array=[1,2,3,4,5,6,7,8,9,10,2];
// console.log(array);
let evenArray=array.filter(num =>num%2==0);
let sum=0;
let arraySum=array.reduce((acc,num)=>acc+num,0);
let uniqueArray=[...new Set(array)];
let desc=uniqueArray.sort((a,b)=>b-a);


let student=[{
    name:"mohan",
    marks:100  
},
{
    name:"Bob",
    marks:90
},
{
    name:"John",
    marks:80
}]
console.log(student);
console.log(2-"2");
console.log([1,2,3].reduce((a,b)=>a+b));