package com.greta.federation.repository;

import com.greta.federation.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    /* @Query("select a from Article a where  a.nom like :x")
    public Page<Article> chercher(@Param("x") String mc , Pageable pageable);*/

    Optional<Article> findByNom(String nom);

    List<Article> findAllByCategorieId(Integer id_categorie);

}
