package org.cordova.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import android.app.Activity;
import org.json.JSONException;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;

public class RingerMode extends CordovaPlugin {
    AudioManager audioManager;
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
        // your init code here
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("GET")) {
            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            switch (audioManager.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                callbackContext.success("SILENT");
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                callbackContext.success("VIBRATE");
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                callbackContext.success("NORMAL");
                break;
            }
            return true;
        } else if (action.equals("VIBRATE")) {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            callbackContext.success("Ringer mode changed to vibrate");

            return true;

        } else if (action.equals("NORMAL")) {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            callbackContext.success("Ringer mode changed to normal");

            return true;

        } else if (action.equals("SILENT")) {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            callbackContext.success("Audio mode changed to silent");

            return true;

        } else {
            callbackContext.error("Error, Action:" + action.toString());
            return false;

        }
    }
}
