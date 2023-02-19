package com.nasa.prueba.aspirante.dominio.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nasainfo")
@EqualsAndHashCode(callSuper = false)
public class PruebaEntity extends Audit<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String href;
    private String center;
    private String title;
    @Column(name = "nasa_id")
    private String nasa_id;
}
