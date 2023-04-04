package greta.federation.controller;

import greta.federation.entity.Joueur;
import greta.federation.entity.Poste;
import greta.federation.service.JoueurService;
import greta.federation.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    @Autowired
    private PosteService posteService;



    @RequestMapping("/addJoueur")
    public ModelAndView display_joueur(
//                         Model model
//                         @RequestParam(name="page", defaultValue = "0") int p,
//                         @RequestParam(name="size", defaultValue = "5") int s,
//                         @RequestParam(name="motCle", defaultValue = "")  String mc
    ){
//        Page<Joueur> pageJoueurs = joueurRepository.chercher("%"+mc+"%", PageRequest.of(p, s));
//        model.addAttribute("listJoueurs",pageJoueurs.getContent());
//        int[] pages = new int[pageJoueurs.getTotalPages()];
//        model.addAttribute("pages",pages);
//        model.addAttribute("size",s);
//        model.addAttribute("pageCourante",p);
//        model.addAttribute("motCle",mc);
        List<Poste> listePoste = posteService.listePoste();
        ModelAndView mav = new ModelAndView("addJoueur");
        mav.addObject("listePoste", listePoste);
        return mav;
    }

    @RequestMapping(value = "/saveJoueur", method = RequestMethod.POST)
    public String saveJoueur(@ModelAttribute("joueur") Joueur joueur) {
        joueurService.save(joueur);
        return "article";
    }
}
