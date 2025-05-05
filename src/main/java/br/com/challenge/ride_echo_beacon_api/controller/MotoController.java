package br.com.challenge.ride_echo_beacon_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.challenge.ride_echo_beacon_api.model.Moto;
import br.com.challenge.ride_echo_beacon_api.model.dto.EchoBeaconResponse;
import br.com.challenge.ride_echo_beacon_api.model.dto.MotoResponse;
import br.com.challenge.ride_echo_beacon_api.repository.MotoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public record MotoFilter(String modelo, String placa) {
    }

    @Autowired
    private MotoRepository repository;

    @GetMapping
    @Cacheable("motos")
    public List<MotoResponse> index() {
        log.info("Listando todas as motos");
        return repository.findAll().stream()
                .map(moto -> new MotoResponse(
                        moto.getId(),
                        moto.getPlaca(),
                        moto.getChassi(),
                        moto.getModelo(),
                        moto.getProblema(),
                        new EchoBeaconResponse(
                                moto.getEchoBeacon().getNumeroIdentificacao(),
                                moto.getEchoBeacon().getStatus()),
                        moto.getDataRegistro()))
                .toList();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @CacheEvict(value = "motos", allEntries = true)
    public ResponseEntity<Moto> create(@RequestBody @Valid Moto moto) {
        log.info("Cadastrando moto " + moto.getModelo());
        repository.save(moto);
        return ResponseEntity.status(201).body(moto);
    }

    @GetMapping("{id}")
    public MotoResponse get(@PathVariable Long id) {
        log.info("Buscando moto " + id);
        Moto moto = getMoto(id);
        return new MotoResponse(
                moto.getId(),
                moto.getPlaca(),
                moto.getChassi(),
                moto.getModelo(),
                moto.getProblema(),
                new EchoBeaconResponse(
                        moto.getEchoBeacon().getNumeroIdentificacao(),
                        moto.getEchoBeacon().getStatus()),
                moto.getDataRegistro());
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "motos", allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando moto " + id);
        repository.delete(getMoto(id));
    }

    @PutMapping("{id}")
    @CacheEvict(value = "motos", allEntries = true)
    public Moto update(@PathVariable Long id, @RequestBody Moto moto) {
        log.info("Atualizando moto " + id + " para " + moto);

        moto.setId(id);
        return repository.save(moto);
    }

    private Moto getMoto(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada"));
    }
}