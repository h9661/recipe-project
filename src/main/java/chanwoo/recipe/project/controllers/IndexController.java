package chanwoo.recipe.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"index.html", "/", "", "index"})
    public String getIndexPage(){
        return "index";
    }
}
