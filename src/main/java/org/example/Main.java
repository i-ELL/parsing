package org.example;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        //String htmlCode = Jsoup.connect("https://spring.io/blog").get().html();
/*
        String blogUrl = "https://online.globus.ru/catalog/molochnye-produkty-syr-yaytsa/";
        //https://online.globus.ru/catalog/molochnye-produkty-syr-yaytsa/?PAGEN_1=2
        //https://online.globus.ru/catalog/molochnye-produkty-syr-yaytsa/?PAGEN_1=3
        Document doc = Jsoup.connect(blogUrl).get();
        System.out.println(doc.title());
        System.out.println(doc.toString());

        Elements elems = doc.getElementsByClass("catalog-section__item__title");
        System.out.println(doc.hasClass("catalog-section__item__title"));
        elems.forEach(elem -> System.out.println(elem));
*/
        //молоко
        //дата
        Date currentDate = new Date();
        String shop = "Глобус";
        //System.out.println(currentDate.getDate() + " " + currentDate.getMonth());
        Elements[] all_elems = new Elements[3];

        for(int i=1; i<10; i++) {
            //страница
            String page = "https://www.globus.ru/catalog/molochnye-produkty-syr-yaytsa/moloko-i-molochnye-produkty/moloko/" + "?page=" + i;
            // https://www.globus.ru/catalog/molochnye-produkty-syr-yaytsa/moloko-i-molochnye-produkty/moloko/?page=2
            Document doc = Jsoup.connect(page).get();
            //цена
            all_elems[0] = doc.getElementsByClass("pim-list__item-price-actual-main");

            //название
            all_elems[1] = doc.getElementsByClass("pim-list__item-title js-crop-text");

            //картинка
            all_elems[2] = doc.getElementsByClass("pim-list__item-img");


            //вывод: цена, название продукта, ссылка на фото
           for (int k=0; k< all_elems[0].size(); k++){
               System.out.println(all_elems[0].get(k).text() + all_elems[1].get(k).text() + "https://www.globus.ru" + all_elems[2].get(k).attr("data-src"));

               //вместо вывода в консоль тут будет отправка в бд: название, цена, картинка, магазин, дата:
               //all_elems[1].get(k).text(), all_elems[0].get(k).text(), "https://www.globus.ru" + all_elems[2].get(k).attr("data-src"), Shop, currentDate.getDate() + "." + currentDate.getMonth()
           }
        }

        //говядина и др просто менять сслыку


    }

}