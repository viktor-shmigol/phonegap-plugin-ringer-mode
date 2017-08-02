package org.cordova.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import android.app.Activity;
import org.json.JSONException;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;

public class RingerMode extends CordovaPlugin {
    private enum RINGER_MODE {
        VIBRATE, SILENT, NORMAL
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (RINGER_MODE.valueOf(action) == RINGER_MODE.VIBRATE) {

            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            callbackContext.success("Ringer mode has been changed to vibrate");

            return true;

        } else if (RINGER_MODE.valueOf(action) == RINGER_MODE.NORMAL) {

            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            callbackContext.success("Ringer mode has been changed to normal");

            return true;

        } else if (RINGER_MODE.valueOf(action) == RINGER_MODE.SILENT) {

            AudioManager audioManager = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            callbackContext.success("Audio mode has been changed to silent");

            return true;

        } else if (action.equals("GET")) {
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
        } else {
            callbackContext.success(action);
            return false;

        }
    }
}
