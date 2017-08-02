module.exports = {
    set: function (ringerMode, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "RingerMode", ringerMode, []);
    },
    get: function (successCallback, errorCallback) {
        console.log("In get function");
        cordova.exec(successCallback, errorCallback, "RingerMode", "GET", []);
    }
};