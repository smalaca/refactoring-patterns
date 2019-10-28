package com.smalaca.domain;

public interface BranchRepository {
    Branch find(String branchId);

    void save(Branch branch);
}
