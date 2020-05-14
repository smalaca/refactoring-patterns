package com.smalaca.services;

import com.smalaca.domain.Coverage;
import com.smalaca.domain.CoverageRepository;

class CoverageService {
    private final CoverageRepository repository;

    CoverageService(CoverageRepository repository) {
        this.repository = repository;
    }

    public boolean is(String coverageId, String operation, long value) {
        Coverage coverage = repository.findBy(coverageId);

        return coverage.is(operation, value);
    }
}
