package com.zaoqibu.jiegeliteracy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vwarship on 2014/12/15.
 */
public class Words {
    private List<Word> words = new ArrayList<Word>();

    public void add(Word word) {
        words.add(word);
    }

    public Word get(int i) {
        return words.get(i);
    }

    public int count() {
        return words.size();
    }
}
