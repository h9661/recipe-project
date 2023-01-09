package chanwoo.recipe.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"index.html", "/", "", "index"})
    public String getIndexPage(){
        System.out.println("some message to say... 1234333343111111222323214343431");
        return "index";
    }
}
