package com.example.telegrambot.service;

import com.example.telegrambot.repository.entity.CompanyInfo;
import com.example.telegrambot.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CompanyInfoServiceImpl implements CompanyInfoService {
    private final CompanyInfoRepository companyInfoRepository;

    @Autowired
    public CompanyInfoServiceImpl(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    @Override
    public void save(CompanyInfo companyInfo) {
        companyInfoRepository.save(companyInfo);
    }

    @Override
    public Optional<CompanyInfo> findByCompanyId(String companyId) {
        return companyInfoRepository.findById(companyId);
    }
}
