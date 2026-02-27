package com.casopractico1.controller;

import com.casopractico1.domain.Servicio;
import com.casopractico1.service.ServicioService;
import com.casopractico1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    // LISTAR
    @GetMapping
    public String listarServicios(Model model) {
        model.addAttribute("listaServicios", servicioService.listarServicios());
        return "servicios/lista";
    }

    // MOSTRAR FORMULARIO NUEVO
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("listaCategorias", categoriaService.listarCategorias());
        return "servicios/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardarServicio(@ModelAttribute Servicio servicio) {
        servicioService.guardarServicio(servicio);
        return "redirect:/servicios";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable Integer id, Model model) {
        Servicio servicio = servicioService.buscarPorId(id);
        model.addAttribute("servicio", servicio);
        model.addAttribute("listaCategorias", categoriaService.listarCategorias());
        return "servicios/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Integer id) {
        servicioService.eliminarServicio(id);
        return "redirect:/servicios";
    }
}