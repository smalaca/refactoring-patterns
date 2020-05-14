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

        switch (operation) {
            case "higher":
                return coverage.isHigherThan(value);
            case "equal":
                return coverage.isEqualTo(value);
            case "lower":
                return coverage.isLowerThan(value);
        }

        throw new IllegalArgumentException("Unsupported condition given: " + operation);
    }
}
