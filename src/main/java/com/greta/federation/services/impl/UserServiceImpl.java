package com.greta.federation.services.impl;

import com.greta.federation.dto.ChangerMotDePasseUserDto;
import com.greta.federation.dto.UserDto;
import com.greta.federation.entity.User;
import com.greta.federation.exception.EntityNotFoundException;
import com.greta.federation.exception.ErrorCodes;
import com.greta.federation.exception.InvalidEntityException;
import com.greta.federation.exception.InvalidOperationException;
import com.greta.federation.services.UserService;
import com.greta.federation.repository.UserRepository;
import com.greta.federation.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;


    }

    @Override
    public UserDto save(UserDto dto) {
        List<String> errors = UserValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }

        if(userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));


        return UserDto.fromEntity(
                userRepository.save(
                        UserDto.toEntity(dto)
                )
        );
    }


    private boolean userAlreadyExists(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.isPresent();
    }

    @Override
    public UserDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public UserDto changerMotDePasse(ChangerMotDePasseUserDto dto) {
        validate(dto);
        Optional<User> utilisateurOptional = userRepository.findById(dto.getId());
        if (utilisateurOptional.isEmpty()) {
            log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId());
            throw new EntityNotFoundException("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId(), ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        User user = utilisateurOptional.get();
        user.setPassword(passwordEncoder.encode(dto.getMotDePasse()));

        return UserDto.fromEntity(
                userRepository.save(user)
        );
    }
    private void validate(ChangerMotDePasseUserDto dto) {
        if (dto == null) {
            log.warn("Impossible de modifier le mot de passe avec un objet NULL");
            throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getId() == null) {
            log.warn("Impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalidOperationException("ID utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
            throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }
}
