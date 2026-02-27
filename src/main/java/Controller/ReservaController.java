package com.casopractico1.controller;

import com.casopractico1.domain.Reserva;
import com.casopractico1.service.ReservaService;
import com.casopractico1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    // LISTAR
    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("listaReservas", reservaService.listarReservas());
        return "reservas/lista";
    }

    // NUEVO
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("listaServicios", servicioService.listarServicios());
        return "reservas/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaService.buscarPorId(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("listaServicios", servicioService.listarServicios());
        return "reservas/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
