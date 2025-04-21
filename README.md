# string-to-json-converter Library

**string-to-json-converter** é uma biblioteca Java que facilita a manipulação e conversão de dados JSON. Ela permite transformar strings JSON em objetos JSON, objetos JSON em mapas e oferece tratamento robusto para entradas inválidas. Essa abordagem automatiza o processo de conversão e validação, garantindo eficiência e confiabilidade, integrada com a biblioteca Gson.

---

## 📦 Importando no projeto

### Maven
Adicione a dependência ao seu arquivo `pom.xml`:
```xml
<dependency>
    <groupId>br.com.ungaratto93.lib</groupId>
    <artifactId>string-to-json-converter</artifactId>
    <version>1.0</version>
</dependency>
```

## 📦 Importando no projeto
Exemplo básico

```java
public class Main {
public static void main(String[] args) {
// Instanciando o conversor
JsonConverter converter = new GsonConverter(new GsonCheckStrategy());

        // Exemplo de conversão de string JSON para JsonObject
        String json = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": \"39\",\n" +
                "  \"locality\": \"New York\"\n" +
                "}";
        JsonObject jsonObject = converter.from(json);

        // Exemplo de conversão de JsonObject para Map
        Map<String, JsonElement> map = converter.from(jsonObject);

        System.out.println("Primeiro atributo: " + map.keySet().stream().findFirst().get());
        System.out.println("Valor do primeiro atributo: " + map.values().stream().findFirst().get());
    }
}
```
Detalhes:
- O método from(String json) transforma uma string JSON em um objeto JsonObject.
- O método from(JsonObject jsonObject) converte um objeto JSON para um Map<String, JsonElement>.
- A biblioteca inclui tratamento de exceções para strings JSON nulas ou vazias.

## ⚠️ Alerta
- Tratamento de Erros: A biblioteca lança exceções como JsonParseException ao encontrar entradas inválidas. Certifique-se de tratar essas exceções adequadamente.


## 🛠 Contribuições
Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades para a biblioteca. Abra uma issue ou envie um pull request!
