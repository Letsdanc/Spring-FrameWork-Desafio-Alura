/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.foro.model;

/**
 *
 * @author kille
 */

package com.alura.foro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Marca esta clase como una entidad JPA.
@Table(name = "topicos") // Define el nombre de la tabla en la base de datos.
public class Topico
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID.
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING) // Guardamos el estado como texto en la BD.
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    @ManyToOne // Un usuario puede tener varios tópicos.
    @JoinColumn(name = "autor_id") // Nombre de la columna que guarda la relación.
    private Usuario autor;

    @ManyToOne // Un curso puede estar relacionado con varios tópicos.
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Constructor vacío (requerido por JPA).
    public Topico() {}

    // Constructor con parámetros.
    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
    }

    // Getters y Setters.
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public StatusTopico getStatus() { return status; }
    public Usuario getAutor() { return autor; }
    public Curso getCurso() { return curso; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public void setStatus(StatusTopico status) { this.status = status; }
}



