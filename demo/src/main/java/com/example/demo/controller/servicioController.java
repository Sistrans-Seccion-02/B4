package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.BebidaEmbedded;
import com.example.demo.modelo.BebidaTipos;
import com.example.demo.repositorio.servicioRepository;


@Controller
public class servicioController {

    @Autowired
    private servicioRepository servicioRepository;

    @GetMapping("/servicio")
    public String obtenerTodasLasBebidasTipos(Model model){
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicio";
    }

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }

    @GetMapping("/servicioForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoServicio", new servicio());
        return "servicioForm";
    }

}