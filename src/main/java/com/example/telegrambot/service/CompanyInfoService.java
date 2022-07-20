package com.example.telegrambot.service;

import com.example.telegrambot.repository.entity.CompanyInfo;
import java.util.Optional;

public interface CompanyInfoService {
    void save(CompanyInfo companyInfo);
    Optional<CompanyInfo> findByCompanyId(String companyId);
}
