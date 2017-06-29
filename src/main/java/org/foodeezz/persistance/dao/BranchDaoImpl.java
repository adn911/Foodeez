package org.foodeezz.persistance.dao;

import org.foodeezz.persistance.entity.Branch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by galib on 5/6/2015.
 */
@Repository
@Transactional
public class BranchDaoImpl implements BranchDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBranch(Branch branch) {
        entityManager.persist(branch);
    }

    @Override
    public void removeBranch(int branchId) {
        entityManager.remove(entityManager.getReference(Branch.class, branchId));
    }

}
