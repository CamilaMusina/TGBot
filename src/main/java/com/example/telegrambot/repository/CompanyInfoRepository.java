package com.example.telegrambot.repository;

import com.example.telegrambot.repository.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoRepository extends JpaRepository <CompanyInfo, String> {}
