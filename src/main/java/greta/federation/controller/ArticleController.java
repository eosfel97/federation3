package greta.federation.controller;

import greta.federation.repository.ArticleRepository;
import greta.federation.repository.CategorieRepository;
import greta.federation.repository.ImageArticleRepository;
import greta.federation.entity.Article;
import greta.federation.entity.Categorie;
import greta.federation.entity.ImageArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository ;
    @Autowired
    private ImageArticleRepository imageArticleRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @RequestMapping(value = "/index")
    public  String index(Model model,
                         @RequestParam(name="page", defaultValue = "0") int p ,
                         @RequestParam(name="size", defaultValue = "5") int s,
                         @RequestParam(name="motCle", defaultValue = "")  String mc){
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
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public  String addArticle( Model model){
        model.addAttribute("article",new Article());
        model.addAttribute("categorie",new Categorie());
        return "addArticle";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("article") Article article, Categorie categorie, @RequestParam("images") MultipartFile[] images, Model model) throws IOException {
        // Enregistrer l'article dans la base de données
        articleRepository.save(article);

        // Enregistrer les images dans le répertoire de stockage des images
        List<ImageArticle> imageArticles = new ArrayList<>();
        for (MultipartFile image : images) {
            // Vérifier que le fichier téléchargé est une image
            if (!image.getContentType().startsWith("image/")) {
                model.addAttribute("errorMessage", "Le fichier téléchargé doit être une image.");
                return "error-page";
            }

            // Générer un nom de fichier unique
            String originalFilename = image.getOriginalFilename();
            String filename = UUID.randomUUID().toString() + "-" + originalFilename;

            // Enregistrer l'image dans le répertoire de stockage des images
            Path imagePath = Paths.get("/images/").resolve(filename);
            Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

            // Enregistrer le chemin d'accès à l'image dans une nouvelle entité ImageArticle
            ImageArticle imageArticle = new ImageArticle();
            imageArticle.setNom(filename);
            imageArticle.setArticle(article);
            imageArticleRepository.save(imageArticle);
            // Enregistrer la catégorie dans l'entité Article
            article.setCategorie(categorie);

            // Ajouter l'entité ImageArticle à la liste
            imageArticles.add(imageArticle);
        }

        // Ajouter la liste d'entités ImageArticle à l'article
        article.setImages(imageArticles);

        // Afficher une page de confirmation
        model.addAttribute("article", article);
        return "article-confirmation";
    }


    }
