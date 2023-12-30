package com.dajungdagam.dg.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity(name = "areas")
@Table
@Getter
public class Area {
    @Id
    @Column(name = "area_id")
    private int id;
    @Column(name = "GUNAME")
    private String guName;
    @Column(name = "DONGNAME")
    private String dongName;
}
