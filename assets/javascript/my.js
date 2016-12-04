



$(document).ready(function () {

  $("#nine-board-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#football-panel").show();
    $("#campusfly-panel").hide();
    $("#football-pill").addClass("active");

  $("#football-toggle").click(function(){
    $("#nine-board-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#sirge-panel").hide();
    $("#campusfly-panel").hide();
    $("#football-panel").show();

    $("#football-pill").removeClass("active");
    $("#sirge-pill").removeClass("active");
    $("#campusfly-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");

    $("#football-pill").addClass("active");

  });

  $("#nine-board-toggle").click(function(){  
    $("#java-game-mac-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#football-panel").hide();
    $("#sirge-panel").hide();
    $("#campusfly-panel").hide();
    $("#nine-board-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");
    $("#campusfly-pill").removeClass("active");
    $("#sirge-pill").removeClass("active");

    $("#nine-board-pill").addClass("active");

  });

  $("#java-game-pc-toggle").click(function(){
    $("#football-panel").hide();
    $("#nine-board-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#sirge-panel").hide();
    $("#campusfly-panel").hide();
    $("#java-game-pc-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");
    $("#sirge-pill").removeClass("active");
    $("#campusfly-pill").removeClass("active");

    $("#java-game-pc-pill").addClass("active");
  });

  $("#java-game-mac-toggle").click(function(){
    $("#football-panel").hide();
    $("#nine-board-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#sirge-panel").hide();
    $("#campusfly-panel").hide();
    $("#java-game-mac-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");
    $("#sirge-pill").removeClass("active");
    $("#campusfly-pill").removeClass("active");

    $("#java-game-mac-pill").addClass("active");
  });

  $("#sirge-toggle").click(function(){
    $("#football-panel").hide();
    $("#nine-board-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#sirge-panel").show();
    $("#java-game-mac-panel").hide();
    $("#campusfly-panel").hide();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");
    $("#sirge-pill").addClass("active");
    $("#campusfly-pill").removeClass("active");

    $("#java-game-mac-pill").removeClass("active");
  });

  $("#campusfly-toggle").click(function(){
    $("#football-panel").hide();
    $("#nine-board-panel").hide();
    $("#java-game-pc-panel").hide();
    $("#sirge-panel").hide();
    $("#java-game-mac-panel").hide();
    $("#campusfly-panel").show();

    $("#football-pill").removeClass("active");
    $("#nine-board-pill").removeClass("active");
    $("#java-game-pc-pill").removeClass("active");
    $("#java-game-mac-pill").removeClass("active");
    $("#sirge-pill").removeClass("active");
    $("#campusfly-pill").addClass("active");

    $("#java-game-mac-pill").removeClass("active");
  });



    $(window).on('resize', function(){



      var $containerWidth = $(window).width();
      var $containerHeight = $(window).height();





      if ($containerWidth <= 760) {
        $('#landing').css('height', '1100px');
        $('#text-info').removeClass('col-sm-offset-3');
        $('#text-info').addClass('col-sm-offset-3');

        // $('#pro-pic').removeClass('col-sm-offset-4');
        // $('#pro-pic').addClass('col-sm-offset-4');
         $('#pro-pic').removeClass('col-sm-offset-1');
      }

      else if ($containerWidth <= 970) {
        $('#text-info').removeClass('col-sm-offset-3');
        $('#text-info').addClass('col-sm-offset-3');

        // $('#pro-pic').removeClass('col-sm-offset-4');
        // $('#pro-pic').addClass('col-sm-offset-4');
         $('#pro-pic').removeClass('col-sm-offset-1');

         
        $('#landing').css("height","800");
        $('#landing').css("background-size","100% 800");

      }

      else {
        $('#landing').css('height', '100%');
        $('#text-info').removeClass('col-sm-offset-3');
        $('#pro-pic').addClass('col-sm-offset-1');
        // $('#pro-pic').removeClass('col-sm-offset-4');
        // $('#pro-pic').addClass('col-sm-offset-1');

        if($containerHeight <= 600){
        $('#landing').css("height","600");
        $('#landing').css("background-size","100% 600");

      }
      else{
        $('#landing').css("height","100%");
        $('#landing').css("background-size","100% 100%");
      }


      }

       


    });
});



