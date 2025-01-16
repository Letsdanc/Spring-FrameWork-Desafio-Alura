/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.controller;

/**
 *
 * @author kille
 */

import com.alura.foro.model.Topico;
import com.alura.foro.repository.TopicoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // 1️⃣ Obtener todos los tópicos
    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    // 2️⃣ Obtener un tópico por ID
    @GetMapping("/{id}")
    public Topico obtenerPorId(@PathVariable Long id) {
        return topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    // 3️⃣ Crear un nuevo tópico
    @PostMapping
    public Topico crear(@RequestBody Topico topico) {
        return topicoRepository.save(topico);
    }

    // 4️⃣ Actualizar un tópico
    @PutMapping("/{id}")
    public Topico actualizar(@PathVariable Long id, @RequestBody Topico datosActualizados) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(datosActualizados.getTitulo());
            topico.setMensaje(datosActualizados.getMensaje());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    // 5️⃣ Eliminar un tópico
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }
}