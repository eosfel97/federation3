package com.greta.federation.services.impl;

import com.greta.federation.dto.BilletDto;
import com.greta.federation.dto.UserDto;
import com.greta.federation.entity.Billet;
import com.greta.federation.entity.User;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.InvalidUserException;
import com.greta.federation.repository.BilletRepository;
import com.greta.federation.services.BilletService;
import com.greta.federation.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BilletServiceImpl implements BilletService {

    private final BilletRepository billetRepository;

    @Autowired
    public BilletServiceImpl(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }

    @Override
    public BilletDto save(BilletDto dto, UserDto userDto) {
        // Valider UserDto
        List<String> userValidationErrors = UserValidator.validate(userDto);
        if (!userValidationErrors.isEmpty()) {
            throw new InvalidUserException(userValidationErrors);
        }

        // Générer automatiquement le numéro du billet et la date d'achat
        dto.setNumero(generateTicketNumber());
        dto.setDateAchat(LocalDateTime.now());

        // Convertir UserDto en User et l'associer au billet
        User user = UserDto.toEntity(userDto);
        Billet billet = BilletDto.toEntity(dto);
        billet.setUser(user);

        // Enregistrer le billet et retourner le résultat
        billet = billetRepository.save(billet);
        return BilletDto.fromEntity(billet);
    }
    @Override
    public BilletDto findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("L'id du billet ne peut pas être null");
        }

        Billet billet = billetRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun billet trouvé avec l'ID " + id
                )
        );

        return BilletDto.fromEntity(billet);
    }

    @Override
    public List<BilletDto> findAll() {
        return billetRepository.findAll().stream()
                .map(BilletDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("L'id du billet ne peut pas être null");
        }
        Billet billet = billetRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun billet trouvé avec l'ID " + id
                )
        );

        billetRepository.delete(billet);
    }

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int TICKET_NUMBER_LENGTH = 12;

    private String generateTicketNumber() {
        StringBuilder builder = new StringBuilder(TICKET_NUMBER_LENGTH);
        for (int i = 0; i < TICKET_NUMBER_LENGTH; i++) {
            int index = new Random().nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(index));
        }
        return builder.toString();
    }
}
