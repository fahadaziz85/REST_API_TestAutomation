package files;

public class PayLoad {

    public static String addPlace(){

        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+92) 300 1234567\",\n" +
                "  \"address\": \"Some where on planet Earth\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    // This is a mock response because I didn't get the developed API Ready

    public static String coursePrice(){
      return "{\n" +
              "  \"dashboard\": {\n" +
              "    \"purchaseAmount\": 910,\n" +
              "    \"website\": \"rahulshettyacademy.com\"\n" +
              "  },\n" +
              "  \"courses\": [\n" +
              "    {\n" +
              "      \"title\": \"Selenium Python\",\n" +
              "      \"price\": 50,\n" +
              "      \"copies\": 6\n" +
              "    },\n" +
              "    {\n" +
              "      \"title\": \"Cypress\",\n" +
              "      \"price\": 40,\n" +
              "      \"copies\": 4\n" +
              "    },\n" +
              "    {\n" +
              "      \"title\": \"RPA\",\n" +
              "      \"price\": 45,\n" +
              "      \"copies\": 10\n" +
              "    }\n" +
              "  ]\n" +
              "}";
    }
}
