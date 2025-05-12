package br.com.lue93.lib.facade;

import com.google.gson.*;

import java.util.Map;

public class GsonConverter implements JsonConverter {

    private final Gson gson;
    private final JsomCheck check;

    public GsonConverter(JsomCheck check) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.check = check;
    }

    public JsonObject from(String json) {
        check.toCheck(json);
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public Map<String, JsonElement> from(JsonObject jsonObject) {
        check.toCheck(jsonObject);
        return jsonObject.asMap();
    }

    public String fromComplexMap(Map<String, Map<String, Map<String, Object>>> map) {
        check.toCheck(map);
        return gson.toJson(map);
    }

    public String fromSimpleMap(Map<String, String> map) {
        check.toCheck(map);
        return gson.toJson(map);
    }

}
