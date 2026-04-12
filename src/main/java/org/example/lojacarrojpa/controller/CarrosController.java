package org.example.lojacarrojpa.controller;

import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.example.lojacarrojpa.model.Carros;
import org.example.lojacarrojpa.service.CarrosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Carros")
public class CarrosController {

    private final CarrosService service;

    public CarrosController(CarrosService service){
        this.service = service;
    }

    @GetMapping
    public List<Carros> findAll(){
        return service.listar();
    }

    @PostMapping
    public Carros salvar(@RequestBody @Valid Carros carros){
        return service.salvar(carros);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long Id){
        service.deletar(Id);
    }

    @PutMapping("/{id}")
    public Carros atualizar(@PathVariable Long Id, @RequestBody @Valid Carros carros ){
        return service.atualizar(Id, carros);
    }
}
