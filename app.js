(function(){
  var app = angular.module('home', []);

  app.directive('projects', function(){
    return {
      restrict: 'E',
      templateUrl: 'projects.html',
      controller:function(){
        this.tab = 1;

        this.selectTab = function(setTab){
          this.tab = setTab;
        };
        this.isSelected = function(checkTab){
          return this.tab === checkTab
        };
      },
      controllerAs: 'panel'

    };
  });

app.directive('landingInfo', function(){
  return{
    restrict: 'E',
    templateUrl: 'landing.html'
  };
});


app.directive('about', function(){
  return{
    restrict: 'E',
    templateUrl: 'about.html'
  };
});

app.directive('contact', function(){
  return{
    restrict: 'E',
    templateUrl: 'contact.html'
  };
});


app.directive('myGame', function(){
  return{
    restrict: 'E',
    templateUrl: 'ap_game.html'
  };
});

app.directive('myMac', function(){
  return{
    restrict: 'E',
    templateUrl: 'ap_game_mac.html'
  };
});

})();
