$(function () {
    $("#addu").validate({
        debug:false,
        rules:{
            storename:{
                required:true,

            },
            phone:{
                required:true
            },
            sdesc:{
                required:true
            }
        },
        messages:{
            storename: {
                required: "请输入店名",

            },
            phone:{
                required:"请输入手机号"
            },
            sdesc:{
                required:"请输入店铺简介"
            }
        }

    })
});
