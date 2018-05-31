 function createQuestion(tixing){
    //1.先判断在需要插入的位置是否存在子节点div
    var oTest = document.getElementById("question");//获得所有子节点的父节点
    var flag = oTest.hasChildNodes();//判断当前节点是否拥有子节点
    if(flag == false){//不存在其他节点
        //2.当不存在---插入第一个节点
        var obj1 = document.createElement("DIV"); //创建DIV
        //将obj1插入到对应的位置
        //1.取得需要插入的位置的上一个节点
        var obj1Parent = document.getElementById("question");
        //2.将obj1插入到这个节点下面
        //obj1Parent.innerHTML="<div class=\"ceshi ceshi2 \" style=\"color:red\">插入的第一个div</div>"; //插入第一个div
        obj1Parent.innerHTML="<a ><div><span>25 分钟</span><div ></div></div><div ><div>宏状元(成府路店)</div><div ><span ></span></div><div >配送费¥5.5</div><div >可预订，10:00后送餐</div></div></a>"; //插入第一个div
    }else{//存在其他的节点
        //3.当已经存在---插入其他节点
        //3.1.创建需要插入的新节点
        var newNode = document.createElement("div");
        var objDivs = oTest.getElementsByTagName("DIV");
        var sum = objDivs.length + 1;
        var reforeNode = objDivs[objDivs.length-1]
        newNode.innerHTML = "添加的div" + sum;
        //3.2.取得插入位置后面的节点---存在节点最后一个节点
        //var reforeNode = document.getElementById("question_danxuan");
        //3.3.实现插入函数
        oTest.insertBefore(newNode,reforeNode.nextSibling);
    }
}
function getDIV(){
    var obj = document.getElementById("question");
    var objDivs = obj.getElementsByTagName("DIV");
    alert(objDivs.length);
    for(i=0;i<objDivs.length;i++){

    }
}
