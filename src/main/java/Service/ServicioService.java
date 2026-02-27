package com.casopractico1.service;

import com.casopractico1.domain.Servicio;
import java.util.List;

public interface ServicioService {
    List<Servicio> listarServicios();
    Servicio guardarServicio(Servicio servicio);
    void eliminarServicio(Integer id);
    Servicio buscarPorId(Integer id);
}
