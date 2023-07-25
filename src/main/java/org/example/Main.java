package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class Main {

    //Ввод currency_rates --code=USD --date=2022-10-08
    //Вывод USD (Доллар США): 61,2475


    public static void main(String[] args){
        MyReader.readURL();
        String fooResourceUrl = MyReader.getUrl();
        if (fooResourceUrl == null) {
            return;
        } else {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
            String body = response.getBody();
            String result = MyReader.getCode() + " (";
            try {
                int index = body.indexOf(MyReader.getCode());
                body = body.substring(index);
                for(int i = body.indexOf("<Name>") + 6; i < body.indexOf("</Name>"); i++){
                    result += body.toCharArray()[i];
                }
                result += "): ";
                for(int i = body.indexOf("<Value>") + 7; i < body.indexOf("</Value>"); i++){
                    result += body.toCharArray()[i];
                }
                System.out.println(result);
            }catch (Exception ex) {
                System.out.println("Wrong valute");
                return;
            }
        }
    }
}