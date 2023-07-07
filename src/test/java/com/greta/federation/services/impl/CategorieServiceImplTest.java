package com.greta.federation.services.impl;

import com.greta.federation.dto.CategorieDto;
import com.greta.federation.services.CategorieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieServiceImplTest {
    @Autowired
    private CategorieService service;

    @Test
    public void shouldSaveCategorieWithSuccess() {
        CategorieDto expectedCategorie = CategorieDto.builder()
                .nom( "bannne ")
                .build();
        CategorieDto savedCategorie = service.save(expectedCategorie);

        assertNotNull(savedCategorie);
        assertNotNull(savedCategorie.getId());
        assertEquals(savedCategorie.getNom(), expectedCategorie.getNom());
    }
}
