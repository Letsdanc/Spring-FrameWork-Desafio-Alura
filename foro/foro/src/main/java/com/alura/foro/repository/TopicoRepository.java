/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alura.foro.repository;

/**
 *
 * @author kille
 */


import com.alura.foro.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para manejar las consultas de la entidad Topico
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
