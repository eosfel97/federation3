package greta.federation.controller;

import greta.federation.dto.CategorieDto;
import greta.federation.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategorieController {
    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }


    public CategorieDto save(CategorieDto dto) {
        return categorieService.save(dto);
    }


    public CategorieDto findById(Integer id_categorie) {
        return categorieService.findById(id_categorie);
    }


    public CategorieDto findByNom(String nom) {
        return categorieService.findByNom(nom);
    }


    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }


    public void delete(Integer id) {
        categorieService.delete(id);
    }
}
