package greta.federation.service;

import greta.federation.entity.Poste;
import greta.federation.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService {

    @Autowired
    private PosteRepository posteRepository;

    public List<Poste> listePoste(){
        List<Poste> listePoste = posteRepository.findAll();
        return listePoste;
    }
}
