package com.example.asmstringboot.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "roads")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private int id;
    private String city;
    private String district;
    private String ward;
    private String street;
    @Column(columnDefinition = "Text")
    private String description;
    private int status;
}
