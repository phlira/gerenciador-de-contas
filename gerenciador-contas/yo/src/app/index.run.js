(function() {
  'use strict';

  angular
    .module('gcontas')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
