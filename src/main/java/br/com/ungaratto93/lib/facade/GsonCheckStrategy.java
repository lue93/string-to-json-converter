package br.com.ungaratto93.lib.facade;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.util.Map;

public class GsonCheckStrategy implements JsomCheck {

    @Override
    public void toCheck(String json) {
        if(json == null){
            throw new JsonParseException("string json is null for parsing");
        }
        if(json.isEmpty()){
            throw new JsonParseException("string json is empty for parsing");
        }
    }

    @Override
    public void toCheck(JsonObject object) {
        if (object.isJsonNull()) {
            throw new JsonParseException("string json is null for parsing");
        }
    }

    @Override
    public void toCheck(Map map) {
        if (map.isEmpty()) {
            throw new JsonParseException("map is empty for parsing");
        }
    }

}
