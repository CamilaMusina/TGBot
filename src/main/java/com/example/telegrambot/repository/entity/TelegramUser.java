package com.example.telegrambot.repository.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TelegramUsers")
public class TelegramUser {
    @Id
    @Column(name = "chat_id")
    private String chat_id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "company_id")
    private Integer company_id;
    public String getCompanyId(){
        if (company_id == 0)
            return "No Current Company";
        else
            return company_id.toString();
    }
}
