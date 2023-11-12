package com.neu.administrator.model.es;

public class ChildConstants {
    public static final String CHILD_MAPPING_TEMPLATE="{\n" +
            "\"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"username\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"score\":{\n" +
            "        \"type\": \"integer\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"password\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"name\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"grade\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"locate\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"duty\":{\n" +
            "        \"type\": \"integer\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"completed_tasks\":{\n" +
            "        \"type\": \"integer\",\n" +
            "        \"index\": true\n" +
            "      },\n" +
            "      \"is_pass\":{\n" +
            "        \"type\": \"boolean\",\n" +
            "        \"index\": false\n" +
            "      }\n" +
            "    }\n" +
            "   }\n" +
            " }";
}
