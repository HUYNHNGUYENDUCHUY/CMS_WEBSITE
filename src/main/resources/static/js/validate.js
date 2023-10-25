$(document).ready(function() {
    $("#login-form").validate({
        rules: {
            username: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 5
            }
        },
        messages: {
            username: {
                required: "Vui lòng nhập tên của bạn",
                minlength: "Tên của bạn phải dài ít nhất 2 ký tự"
            },
            password: {
                required: "Vui lòng cung cấp mật khẩu",
                minlength: "Mật khẩu của bạn phải dài ít nhất 5 ký tự"
            }
        },

    });
    $("#button-login").on('submit', function(e) {
        if (!$("#login-form").valid()) {
            e.preventDefault();
        }
    });

    // $("#form-register").



});