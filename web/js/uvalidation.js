$(function () {
    $("#addu").validate({
        debug:false,
        rules:{
            username:{
                required:true,
                ajaxtextcheck:true,
                checkUserName:true
            },

            password:{
                required:true,

            },
            confirm_password:{
                required:true,
                equalTo:"#password"
            },
            phone:{
                required:true,
               isMobile:true
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
                checkUserName:"用户名被占用"
            },
            password: {
                required: "请输入密码",

            },
            confirm_password:{
                required: "请输入密码",
                equalTo: "两次密码输入不一致"
            },
            phone:{
                required:"请输入手机号",
                isMobile:"请输入正确的手机号",

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

jQuery.validator.addMethod("ajaxtextcheck",function (value,element) {
    return this.option(element)||(/^([a-zA-Z0-9_]+)$/.test(value));
},"只能包括英文字母、数字和下划线");
//异步验证用户名
jQuery.validator.addMethod("checkUserName", function(value, element){
    var result = false;
    // 设置同步
    $.ajaxSetup({
        async: false
    });
    var param = {
        userName: value
    };
    $.post(base + "/checkUserName.do", param, function(data){
        result = (1 == data);
    });
    // 恢复异步
    $.ajaxSetup({
        async: true
    });
    return result;
}, "用户名已经存在");
//手机号码验证
jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");