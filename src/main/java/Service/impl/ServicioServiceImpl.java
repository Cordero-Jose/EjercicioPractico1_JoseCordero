package com.casopractico1.service.impl;

import com.casopractico1.domain.Servicio;
import com.casopractico1.repository.ServicioRepository;
import com.casopractico1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public Servicio buscarPorId(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }
}
