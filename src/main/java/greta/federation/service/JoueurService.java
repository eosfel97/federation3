package greta.federation.service;

import greta.federation.entity.Joueur;
import greta.federation.entity.Poste;
import greta.federation.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;


    public void save(Joueur joueur) {
        joueurRepository.save(joueur);
    }
}
