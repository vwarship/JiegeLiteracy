package com.zaoqibu.jiegeliteracy;

/**
 * Created by vwarship on 2014/12/15.
 */
public class Word {
    private String text;
    private String soundPath;

    public Word(String text, String soundPath) {
        this.text = text;
        this.soundPath = soundPath;
    }

    public String getText() {
        return text;
    }

    public String getSoundPath() {
        return soundPath;
    }
}
