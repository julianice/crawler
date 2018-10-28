package com.example.demo.logic;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
    private HashSet<String> links;

    public Spider(){
        links = new HashSet<>();
    }

    public List<Element> getPageLinks(String URL) {
        Elements hrefs = new Elements();

        if (!links.contains(URL)) {
            try {
                links.add(URL);
                Document document = Jsoup.connect(URL).get();
                hrefs = document.select("a[href]");
            }catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }

        Set<String> d = hrefs.stream().filter(p -> p.attr("href").contains("http")).forEach(links::add);

        System.out.println(d);
        //links = hrefs;
//        for (Element href: hrefs) {
//            if (href.attr("href").contains("http")) {
//                links.add(href.attr("href"));
//                System.out.println(href.text());
//                getPageLinks(href.attr("href"));
//            }
//        }

        return d;
    }
}
