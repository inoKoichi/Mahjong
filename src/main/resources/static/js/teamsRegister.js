(function() {
    $('.veen-2 .log').click(function() {
        $('.check').addClass('check-2')
        var name = $('.veen-2 .tada .name input').val();
        var mail = $('.veen-2 .tada .mail input').val();
        var uid = $('.veen-2 .tada .uid input').val();
        var pwd = $('.veen-2 .tada .pwd input').val();
        var chkname = /^[A-Za-z0-9 ]{3,40}$/;
        var chkmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        var chkuid = /^[A-Za-z0-9_]{3,20}$/;
        var chkpwd = /^[A-Za-z0-9!@#$%^&*()_]{6,20}$/;
        if ((!chkname.test(name) || !chkmail.test(mail) || !chkuid.test(uid) || !chkpwd.test(pwd)) || ($('.veen-2 .in-1 input[type="radio"]').is(":not(:checked)") && $('.veen-2 .in-2 input[type="radio"]').is(":not(:checked)"))) {
            $('.check .p1,.check .p2,.check .p3,.check .p4,.check .p5,p').empty();
            if (!chkname.test(name)) {
                $('.check .p1').text('Enter Valid Name');
            }
            if (!chkmail.test(mail)) {
                $('.check .p2').text('Enter Valid Mail');
            }
            if (!chkuid.test(uid)) {
                $('.check .p3').text('Enter Valid User Name');
            }
            if (!chkpwd.test(pwd)) {
                $('.check .p4').text('Enter Password');
            }
            if ($('.veen-2 .in-1 input[type="radio"]').is(":not(:checked)") && $('.veen-2 .in-2 input[type="radio"]').is(":not(:checked)")) {
                $('.check .p5').text('Select Gender');
            }
        } else {
            $('.check .p1,.check .p2,.check .p3,.check .p4,.check .p5').empty();
            $('.check').html('<p style="color:#1ec303;line-height:50px;">Youe Registration Is Successful...... ! Please Wait......!</p>', 3000);
            $('.veen-2 .tada input').val('');
            $('.veen-2 .tada input').removeAttr('checked');
            /*setTimeout(function(){
            window.location.reload();
        }, 3000);*/
        }
    });
    $('.main-wrapper').mousemove(function(e) {
        var offset = $(this).offset();
        var relativeX = e.pageX - offset.left;
        var relativeY = e.pageY - offset.top;
        var movex = (-relativeX / 5);
        var movey = (-relativeY / 5);
        $(this).css({
            'background-position-x': movex,
            'background-position-y': movey
        });
    });
    $('.tada').mousemove(function(e) {
        var offset = $(this).offset();
        var relativeX = e.pageX - offset.left;
        var relativeY = e.pageY - offset.top;
        var movex = (-relativeX / 5);
        var movey = (-relativeY / 5);
        $(this).css({
            'background-position-x': movex,
            'background-position-y': movey
        });
    });
    $('.okati').click(function() {
        $('.veen').css({
            'top': 0
        });
        $('.main-wrapper').css({
            'transform': 'scale(.9)'
        });
        $('.veen .tada').css({
            'left': 0
        });
    });

    $('.tada a.close-x').click(function() {
        $('body').find('*').removeAttr('style');
        $('.veen-2 .tada input').removeAttr('checked');
    });




    $('.rendu').click(function() {
        $('.veen-2').css({
            'top': 0
        });
        $('.main-wrapper').css({
            'transform': 'scale(.9)'
        });
        $('.veen-2 .tada').css({
            'left': 0
        });
    });
    $('.veen-2 .tada a.close-x-2').click(function() {
        $('body').find('*').removeAttr('style');
        $('.check').removeClass('check-2');
        $('.check').eampty();
        $('.veen-2 .tada input').removeAttr('checked');
    });


    $('input, textarea, select').each(function(){
        var tmpval = $(this).val();
        if(tmpval != '') {
            $(this).prev().addClass('trans');
        }
    });
    $('input, textarea, select').focus(function() {
        $(this).prev().addClass('trans');

    }).blur(function() {
        if ($(this).val() == ''){
            $(this).prev().removeClass('trans');
        }
    });

    $.fn.toggleAttr = function(attr, attr1, attr2) {
        return this.each(function() {
            var self = $(this);
            if (self.attr(attr) == attr1)
                self.attr(attr, attr2);
            else
                self.attr(attr, attr1);
        });
    };
    $('.show-pass').click(function() {
        $(this).toggleClass('go');
        $('.pwd input').toggleAttr('type', 'text', 'password');
    });
});