package com.example.tmsreader.utils;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;


public class ReadAloud implements TextToSpeech.OnUtteranceCompletedListener {


    private final String UTTER_ID = "utterance";
    private TextToSpeech speaker;
    private HashMap<String, String> ttsOptions;
    public static final MutableLiveData<Integer> marker = null;



    public void init(Context context ) {
        marker.setValue(0);
        speaker = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ttsOptions = new HashMap<String, String>();
                ttsOptions.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, UTTER_ID);

                speaker.setLanguage(Locale.ENGLISH);
            }
        });
        speaker.setOnUtteranceCompletedListener(this);

    }
    public void speakFun(String text){
        speaker.speak(text, TextToSpeech.QUEUE_FLUSH, ttsOptions);
    }

    @Override
    public void onUtteranceCompleted(String utteranceId) {
        if (utteranceId.equals(UTTER_ID)) {
            Log.d("textToSpeech", "completed");
            speaker.speak("Completed", TextToSpeech.QUEUE_FLUSH, ttsOptions);
           }
    }
}