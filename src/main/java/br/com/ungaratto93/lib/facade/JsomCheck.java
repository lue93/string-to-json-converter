package br.com.ungaratto93.lib.facade;

import com.google.gson.JsonObject;

import java.util.Map;

public interface JsomCheck {

        void toCheck(String json);
        void toCheck(JsonObject object);
        void toCheck(Map map);

    }
