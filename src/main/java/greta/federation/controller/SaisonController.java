package greta.federation.controller;

import greta.federation.controller.api.SaisonApi;
import greta.federation.dto.SaisonDto;
import greta.federation.services.SaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaisonController implements SaisonApi {

    private final SaisonService saisonService;

    @Autowired
    public SaisonController(SaisonService saisonService) {
        this.saisonService = saisonService;
    }

    @Override
    public ResponseEntity<SaisonDto> save(SaisonDto dto) {
        return ResponseEntity.ok(saisonService.save(dto));
    }

    @Override
    public ResponseEntity<SaisonDto> findById(Integer id) {
        return ResponseEntity.ok(saisonService.findById(id));
    }

    @Override
    public ResponseEntity<List<SaisonDto>> findAll() {
        return ResponseEntity.ok(saisonService.findAll());
    }

    @Override
    public ResponseEntity<SaisonDto> update(Integer id, SaisonDto dto) {
        return ResponseEntity.ok(saisonService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        saisonService.delete(id);
        return ResponseEntity.ok().build();
    }
}
