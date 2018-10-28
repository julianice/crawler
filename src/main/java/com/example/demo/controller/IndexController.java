package com.example.demo.controller;

        import com.example.demo.logic.Spider;
        import org.jsoup.select.Elements;
        import org.jsoup.nodes.Element;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Set;

@Controller
public class IndexController {
    Spider spider;

    @GetMapping("/")
    public ModelAndView index() {
        Map<String, List<Element>> model = new HashMap<>();
        spider = new Spider();
        List<Element> urls;
        urls = spider.getPageLinks("http://xn--80aeignf2ae1aj.xn--p1ai/hot-tours");

        model.put("name", urls);
        return new ModelAndView("start", model);
    }
}
