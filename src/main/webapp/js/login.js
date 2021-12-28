$(function () {
    layui.use(['form', 'layer'], function () {
        var form = layui.form;//得到form表单
        form.on('submit(login)', function (data) {

            let username = data.field.username;
            $.ajax({
                url: '/user/login',
                data: JSON.stringify(data.field),
                contentType: "application/json;charset=UTF-8",
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                        if (data.data === "codeErr") {
                            layer.msg("验证码错误");
                        }
                        if (data.data === "error") {
                            layer.msg("用户名或密码错误");
                        }
                        if (data.data === "success") {
                            layer.msg('登陆成功，即将跳转到后台管理页面', function () {
                                location.href = 'index.html';
                            });
                        }
                }
            });
            return false;
        });
    });
});

function freshCode(obj) {
    let date = new Date();
    $(obj).attr("src", "/code/checkCode?" + Math.random()*date.getMilliseconds());
}