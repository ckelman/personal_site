$(document).ready(function () {


    $(window).on('resize', function(){

      var $containerWidth = $(window).width();

      if ($containerWidth <= 770) {
        $('#landing').css('height', '1000px');
        $('#text-info').removeClass('col-sm-offset-3');
        $('#text-info').addClass('col-sm-offset-3');

        // $('#pro-pic').removeClass('col-sm-offset-4');
        // $('#pro-pic').addClass('col-sm-offset-4');
         $('#pro-pic').removeClass('col-sm-offset-1');
      }

      else if ($containerWidth <= 900) {
        $('#landing').css('height', '800px');
        $('#text-info').removeClass('col-sm-offset-3');
        $('#text-info').addClass('col-sm-offset-3');

        // $('#pro-pic').removeClass('col-sm-offset-4');
        // $('#pro-pic').addClass('col-sm-offset-4');
         $('#pro-pic').removeClass('col-sm-offset-1');
      }

      else {
        $('#landing').css('height', '100%');
        $('#text-info').removeClass('col-sm-offset-3');
        $('#pro-pic').addClass('col-sm-offset-1');
        // $('#pro-pic').removeClass('col-sm-offset-4');
        // $('#pro-pic').addClass('col-sm-offset-1');

      }

    });

});
