package com.casopractico1.service;

import com.casopractico1.domain.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> listarReservas();
    Reserva guardarReserva(Reserva reserva);
    Reserva buscarPorId(Integer id);
    void eliminarReserva(Integer id);
}
