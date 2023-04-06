package greta.federation.repository;

import greta.federation.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    /* @Query("select a from Article a where  a.nom like :x")
    public Page<Article> chercher(@Param("x") String mc , Pageable pageable);*/

    Optional<Article> findByNom(String nom);

    List<Article> findAllByCategorieId(Integer id_categorie);

}
