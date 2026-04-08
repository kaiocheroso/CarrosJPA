package org.example.lojacarrojpa.service;

import org.example.lojacarrojpa.model.Carros;
import org.example.lojacarrojpa.repository.CarrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CarrosService {

    private final CarrosRepository repository;

    public CarrosService(CarrosRepository repository){
        this.repository = repository;
    }

    public List<Carros> listar(){
        return repository.findAll();
    }

    public Carros buscarPorId(Long Id){
        return repository.findById(Id).orElseThrow(() -> new RuntimeException("Esse Carro não existe"));
    }

    public Carros salvar(Carros carros){
        return repository.save(carros);
    }

    public void deletar(Long Id){
        repository.deleteById(Id);
    }

    public Carros atualizar(Long Id, Carros carros){
        buscarPorId(Id);
        carros.setId(Id);
        return repository.save(carros);
    }
}
