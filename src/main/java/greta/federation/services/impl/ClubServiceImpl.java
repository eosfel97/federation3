package greta.federation.services.impl;



import greta.federation.dto.UserDto;
import greta.federation.dto.StadeDto;
import greta.federation.dto.AdresseDto;
import greta.federation.dto.ClubDto;
import greta.federation.entity.Club;
import greta.federation.exception.EntityNotFoundException;
import greta.federation.exception.ErrorCodes;
import greta.federation.exception.InvalidEntityException;
import greta.federation.repository.ClubRepository;
import greta.federation.services.ClubService;
import greta.federation.validator.ClubValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClubServiceImpl implements ClubService {

    @Autowired
    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl( ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public ClubDto save(ClubDto dto) {
        List<String> errors = ClubValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Club is not valid {}", dto);
            throw new InvalidEntityException("le Club n'est pas valide", ErrorCodes.CLUB_NOT_VALID, errors);
        }

        return ClubDto.fromEntity(
                clubRepository.save(
                        ClubDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClubDto findById(Integer id) {
        if (id == null) {
            log.error("Club ID is null");
            return null;
        }
        return clubRepository.findById(id).map(ClubDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun club avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CLUB_NOT_FOUND)
        );
    }
    @Override
    public ClubDto update(Integer id, ClubDto updatedClub) {
        Club existingClub = clubRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Club not found with ID: " + id));

        existingClub.setNom(updatedClub.getNom());
        existingClub.setDateCreation(updatedClub.getDateCreation());
        existingClub.setNomEtablissementEtat(updatedClub.getNomEtablissementEtat());
        existingClub.setNomAssurance(updatedClub.getNomAssurance());
        existingClub.setRib(updatedClub.getRib());
        existingClub.setAttestationAssurance(updatedClub.getAttestationAssurance());
        existingClub.setUser(UserDto.toEntity(updatedClub.getUser()));
        existingClub.setStade(StadeDto.toEntity(updatedClub.getStade()));
        existingClub.setAdresse(AdresseDto.toEntity(updatedClub.getAdresse()));
        clubRepository.save(existingClub);
        return ClubDto.fromEntity(existingClub);
    }
    @Override
    public ClubDto findByNom(String nom) {
        Club club = clubRepository.findByNom(nom)
                .orElseThrow(() -> new EntityNotFoundException( "Aucun club avec le Nom = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.CLUB_NOT_FOUND));
        return ClubDto.fromEntity(club);
    }

    @Override
    public List<ClubDto> findAll() {
        return clubRepository.findAll().stream()
                .map(ClubDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club not found with id: " + id));
        clubRepository.delete(club);
    }

}
