package com.smalaca.domain;

public class CodeBaseDeltasRepository {
    private final CodeBaseDeltaRepository codeBaseDeltaRepository;

    public CodeBaseDeltasRepository(CodeBaseDeltaRepository codeBaseDeltaRepository) {
        this.codeBaseDeltaRepository = codeBaseDeltaRepository;
    }

    public CodeBaseDelta findFix(String id) {
        return codeBaseDeltaRepository.find(id);
    }

    public CodeBaseDelta findRefactoring(String id) {
        return codeBaseDeltaRepository.find(id);
    }

    public CodeBaseDelta findTask(String id) {
        return codeBaseDeltaRepository.find(id);
    }
}
