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


| Característica                         | string-to-json-converter                      | Gson (uso puro)                              | Jackson ObjectMapper                        |
|---------------------------------------|-----------------------------------------------|----------------------------------------------|---------------------------------------------|
| **Conversão de String para JsonObject** | Sim, via `converter.from(String)`             | Sim, via `JsonParser.parseString()`          | Sim, via `ObjectMapper.readTree()`          |
| **Conversão de JsonObject para Map**   | Sim, via `converter.from(JsonObject)`         | Manual, exige iteração sobre JsonObject      | Sim, via `ObjectMapper.convertValue()`      |
| **Validação de entrada JSON**          | Sim, com estratégia de verificação (`GsonCheckStrategy`) | Parcial, depende do uso de try/catch        | Sim, lança exceções detalhadas              |
| **Tratamento de erros**                | Lança `JsonParseException` para entradas inválidas | Lança `JsonSyntaxException`                 | Lança `JsonProcessingException`             |
| **Facilidade de uso**                  | Alta, abstrai validações e conversões         | Média, exige controle manual                 | Média, exige configuração e mapeamento      |
| **Integração com Maven**               | Sim, com dependência própria (`br.com.ungaratto93.lib`) | Sim, via `com.google.code.gson`             | Sim, via `com.fasterxml.jackson.core`       |
| **Flexibilidade para estratégias**     | Sim, permite injeção de estratégias de validação | Não                                          | Não                                         |


## ⚠️ Alerta
- Tratamento de Erros: A biblioteca lança exceções como JsonParseException ao encontrar entradas inválidas. Certifique-se de tratar essas exceções adequadamente.


## 🛠 Contribuições
Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades para a biblioteca. Abra uma issue ou envie um pull request!
