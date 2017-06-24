package com.zhaopeng.question.Normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaopeng on 2017/6/24.
 */
public class TinyURL {


    private List<String> list = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        list.add(longUrl);

        return String.valueOf(list.size());

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return list.get(Integer.valueOf(shortUrl) - 1);

    }
}
