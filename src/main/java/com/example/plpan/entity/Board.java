package com.example.plpan.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Board extends BaseEntity{

    @Id
    private Long bno;

    private String title;

    private String content;

    private String writer;
}
