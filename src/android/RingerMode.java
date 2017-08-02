package org.cordova.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import android.app.Activity;
import org.json.JSONException;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.log;

public class RingerMode extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Log.v("silencify","testing logcat")
        if (action.equals("GET")) {
            //callbackContext.success("SILENT");
            callbackContext.success("Not Working");
            // AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            // switch (audioManager.getRingerMode()) {
            // case AudioManager.RINGER_MODE_SILENT:
            //     callbackContext.success("SILENT");
                
            //     break;
            // case AudioManager.RINGER_MODE_VIBRATE:
            //     callbackContext.success("VIBRATE");
            //     break;
            // case AudioManager.RINGER_MODE_NORMAL:
            //     callbackContext.success("NORMAL");
            //     break;
            // }
            return true;
        } else if (action.equals("VIBRATE")) {

            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            callbackContext.success("Ringer mode has been changed to vibrate");

            return true;

        } else if (action.equals("NORMAL")) {

            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            callbackContext.success("Ringer mode has been changed to normal");

            return true;

        } else if (action.equals("SILENT")) {

            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            callbackContext.success("Audio mode has been changed to silent");

            return true;

        } else {
            callbackContext.success(action);
            return false;

        }
    }
}
