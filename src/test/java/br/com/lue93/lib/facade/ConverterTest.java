package br.com.lue93.lib.facade;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


public class ConverterTest {

    JsonConverter converter = new GsonConverter(new GsonCheckStrategy());

    @Test
    public void shouldTransformSimpleJsonStringToJsonObj() {
        String json = "{\n" +
                "  \"name\": \"Jhon\",\n" +
                "  \"age\": \"39\",\n" +
                "  \"locality\": \"New York\",\n" +
                "  \"region\": \"State\",\n" +
                "  \"postalCode\": \"12345\",\n" +
                "  \"countryName\": \"Country\"\n" +
                "}\n" +
                "\n";

        JsonObject jsonObject =  converter.from(json);
        Assert.assertTrue(jsonObject.getClass().equals(JsonObject.class));
        Assert.assertEquals("name", jsonObject.keySet().stream().findFirst().get());
        Assert.assertEquals("name=\"Jhon\"", jsonObject.entrySet().stream().findFirst().get().toString());
    }

    @Test
    public void shouldTransformComplexeStringJsonToJsonObj() {
        String complexJson = "{\n" +
                "  \"First\": \"[11, 12, 13, 14, 15]\",\n" +
                "  \"Second\": \"[21, 22, 23]\",\n" +
                "  \"Third\": \"[31, 32,33]\"\n" +
                "}\n";
        JsonObject jsonObject =  converter.from(complexJson);
        Assert.assertTrue(jsonObject.getClass().equals(JsonObject.class));
        Assert.assertEquals("First", jsonObject.keySet().stream().findFirst().get());
    }

    @Test
    public void shouldTransformJsonObjectToMap() {
        String json = "{\n" +
                "  \"name\": \"Jhon\",\n" +
                "  \"age\": \"39\",\n" +
                "  \"locality\": \"New York\",\n" +
                "  \"region\": \"State\",\n" +
                "  \"postalCode\": \"12345\",\n" +
                "  \"countryName\": \"Country\"\n" +
                "}\n" +
                "\n";

        JsonObject jsonObject =  converter.from(json);
        Map<String, JsonElement> map = converter.from(jsonObject);
        Assert.assertEquals("name", map.keySet().stream().findFirst().get());
        Assert.assertEquals("\"Jhon\"", map.values().stream().findFirst().get().toString());
    }

    @Test
    public void shouldNotTransformNullJsonString() {
        String nullJson = null;
        Assert.assertThrows(JsonParseException.class, () -> { converter.from(nullJson);});
    }

    @Test
    public void shouldNotTransformEmptyJsonString() {
        String nullJson = "";
        Assert.assertThrows(JsonParseException.class, () -> { converter.from(nullJson);});
    }

}
