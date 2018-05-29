import "../css/site.css"
import "../css/signin.css"
import "../css/register.css"
import "bootstrap/dist/css/bootstrap.min.css"
global.jQuery = require("jquery")
require("expose-loader?$!jquery")
import "bootstrap"
$().ready(function ()
{
    $.validator.addMethod('phone', function( value, element ){

        // /^1\d{10}$/ 来自支付宝的正则
        return this.optional( element ) || /^1\d{10}$/.test( value );

    }, '请输入正确的手机号码');
    $("#registerform").validate({
        rules:{
            username:{
                required:true,
                rangelength:[6,18]
            },
            password:{
                required:true,
                rangelength:[6,18]
            },
            confirm_password:{
                requied:true,
                equalTo:"#password"
            },
            phone:{
                required:true
            },
        },
        messages:{
            username:{
                required: "请输入用户名",
                rangelength:"用户名长度需在6~18个字符"
            },
            password: {
                required: "请输入密码",
                rangelength: "密码长度需在6~18个字符"
            },
            confirm_password:{
                required: "请输入密码",
                equalTo: "两次密码输入不一致"
            },
            phone:{
                required:"请输入手机号"
            }
        }
    })
})