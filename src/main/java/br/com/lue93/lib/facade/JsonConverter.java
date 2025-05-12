package br.com.lue93.lib.facade;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public interface JsonConverter {

    JsonObject from(String json);
    Map<String, JsonElement> from(JsonObject jsonObject);
    String fromComplexMap(Map<String, Map<String, Map<String, Object>>> map);
    String fromSimpleMap(Map<String, String> map);


}
