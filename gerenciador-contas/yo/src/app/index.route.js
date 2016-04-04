(function() {
  'use strict';

  angular
    .module('gcontas')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider
      .when('/pessoa',{
        templateUrl: 'app/pessoa/pessoa.html',
        controller: 'PessoaController'
      })
      .when('/pessoa/edit/:pessoaId',{
        templateUrl: 'app/pessoa/pessoa_edit.html',
        controller: 'PessoaController'
      })
      .otherwise({
        redirectTo: '/pessoa'
      });
  }

})();
