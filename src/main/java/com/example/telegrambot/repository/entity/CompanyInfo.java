package com.example.telegrambot.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Data
@Entity
@Table(name = "company")
@EqualsAndHashCode
public class CompanyInfo {
    @Id
    @Column(name = "company_id")
    private String company_id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

    @Column(name = "email")
    private String email;
}




