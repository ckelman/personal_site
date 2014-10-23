



$(document).ready(function () {

  $("#nine-board-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#football-panel").show();

  $("#football-toggle").click(function(){
    $("#nine-board-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#football-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");

    $("#football-pill").addClass("active");

  });

  $("#nine-board-toggle").click(function(){  
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#football-panel").hide();

    $("#nine-board-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");

    $("#nine-board-pill").addClass("active");

  });

  $("#java-game-pc-toggle").click(function(){
    $("#football-panel").hide();
    $("#nine-board-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");

    $("#java-game-pc-pill").addClass("active");
  });

  $("#java-game-mac-toggle").click(function(){
    $("#football-panel").hide();
    $("#nine-board-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#java-game-mac-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");

    $("#java-game-mac-pill").addClass("active");
  });



    $(window).on('resize', function(){



      var $containerWidth = $(window).width();
      var $containerHeight = $(window).height();





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

       if($containerHeight <= 600){
        $('#landing').css("height","600");
        $('#landing').css("background-size","100% 600");

      }
      else{
        $('#landing').css("height","100%");
        $('#landing').css("background-size","100% 100%");
      }


    });
});



