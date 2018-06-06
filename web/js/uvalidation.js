$(function () {
    $("#addu").validate({
        debug:false,
        rules:{
            username:{
                required:true,

            },
            password:{
                required:true,

            },
            confirm_password:{
                required:true,
                equalTo:"#password"
            },
            phone:{
                required:true
            },
            birthday:{
                dateISO:true
            },
            role:{
                min:1
            }
        },
        messages:{
            username:{
                required: "请输入用户名",

            },
            password: {
                required: "请输入密码",

            },
            confirm_password:{
                required: "请输入密码",
                equalTo: "两次密码输入不一致"
            },
            phone:{
                required:"请输入手机号"
            },
            birthday:{
                dateISO:"请输入正确格式的生日，如1900-01-01"
            },
            role:{
              min:"请选择您的身份"
            }
        }

    })
});
