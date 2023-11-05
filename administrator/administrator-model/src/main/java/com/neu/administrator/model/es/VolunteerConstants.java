package com.neu.administrator.model.es;

/**
 * @ClassName VolunteerConstants
 * @Description es中与志愿者有关的常量放这里
 * @Author CY
 * @Date 2023/11/5 15:09
 * @Version 1.0
 */
public class VolunteerConstants {
    public static final String VOL_MAPPING_TEMPLATE=
            "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"username\":{\n" +
            "        \"type\":\"keyword\"\n" +
            "      },\n" +
            "      \"name\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },\n" +
            "      \"location\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },\n" +
            "      \"duty\":{\n" +
            "        \"type\": \"integer\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"vol_corrected_tasks\":{\n" +
            "        \"type\": \"integer\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"vol_tel\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      }\n" +
            "      \n" +
            "      \n" +
            "    }\n" +
            "  }\n" +
            "}";
}
