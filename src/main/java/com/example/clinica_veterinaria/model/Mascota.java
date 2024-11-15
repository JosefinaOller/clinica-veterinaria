package com.example.clinica_veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen_mascota")
    @TableGenerator(name = "table_gen_mascota", table = "hibernate_sequence", pkColumnName = "sequence_name", valueColumnName = "next_val", pkColumnValue = "mascota_seq", allocationSize = 1)
    private Long id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @OneToOne
    @JoinColumn(name="id_duenio",referencedColumnName="id_duenio")
    private Duenio duenio;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String especie, String raza, String color) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }
    
}
