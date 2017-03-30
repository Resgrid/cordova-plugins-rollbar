/**
 * Rollbar.js
 *
 * Cordova Rollbar plugin for version >= 3.0.0
 *
 * Copyright(c) Resgrid 2015 (http://resgrid.com)
 */

var exec = require('cordova/exec');
var RollbarSetup = require('rollbar-browser/dist/rollbar.umd.nojson.js');

var Rollbar = {
  native: {
    init: function(successCallback, errorCallback){
      return exec(successCallback, errorCallback, "CDVRollbar", "init", []);
    }
  },
  browser: {
    init: function(config) {
      return RollbarSetup.init(config);
    }
  }
};

module.exports = Rollbar;
