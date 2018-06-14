$(function () {
    $("#adds").validate({
        debug:false,
        rules:{
            storeName:{
                required:true,

            },
            phone:{
                required:true
            },
            sDesc:{
                required:true
            }
        },
        messages:{
            storeName: {
                required: "请输入店名",

            },
            phone:{
                required:"请输入手机号"
            },
            sDesc:{
                required:"请输入店铺简介"
            }
        }

    })
});
