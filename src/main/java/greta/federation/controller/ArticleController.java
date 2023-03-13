package greta.federation.controller;

import greta.federation.dao.ArticleRepository;
import greta.federation.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository ;
    @RequestMapping(value = "/index")
    public  String index(Model model,
                         @RequestParam(name="page", defaultValue = "0") int p ,
                         @RequestParam(name="size", defaultValue = "5") int s,
                         @RequestParam(name="motCle", defaultValue = "5")  String mc){
        Page<Article> pageArticles = articleRepository.chercher("%"+mc+"%",PageRequest.of(p, s));
        model.addAttribute("listArticles",pageArticles.getContent());
        int[] pages = new int[pageArticles.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);
        model.addAttribute("pageCourante",p);
        model.addAttribute("motCle",mc);
        return "article";
    }
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String delete(Long id,String motCle, int page, int size){
        articleRepository.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
    }
}
