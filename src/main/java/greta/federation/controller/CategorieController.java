package greta.federation.controller;

import greta.federation.controller.api.CategorieApi;
import greta.federation.dto.CategorieDto;
import greta.federation.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {
    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public CategorieDto save(CategorieDto dto) {
        return categorieService.save(dto);
    }

    @Override
    public CategorieDto findById(Integer id_categorie) {
        return categorieService.findById(id_categorie);
    }

    @Override
    public CategorieDto findByNom(String nom) {
        return categorieService.findByNom(nom);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categorieService.delete(id);
    }
}
