package org.foodeezz.service;

import org.foodeezz.persistance.dao.BranchDao;
import org.foodeezz.persistance.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by galib on 5/6/2015.
 */
@Service
@Transactional
public class BranchService {

    @Autowired
    BranchDao branchDao;

    public void addBranch(Branch branch) {
        branchDao.addBranch(branch);
    }

    public void removeBranch(int branchId) {
        branchDao.removeBranch(branchId);
    }
}
