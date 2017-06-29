package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.Branch;

/**
 * Created by galib on 5/6/2015.
 */
public interface BranchDao {

    void addBranch(Branch branch);

    void removeBranch(int branchId);
}
