module.exports = {
    set: function (ringerMode, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RingerMode", ringerMode, []);
    },
    get: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RingerMode", "GET", []);
    }
};