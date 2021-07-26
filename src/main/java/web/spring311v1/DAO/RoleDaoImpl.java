package web.spring311v1.DAO;

import web.spring311v1.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("select r from Role r",Role.class).getResultList();
    }


    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Role.class,id));
    }

    @Override
    public Role getById(Long id) {
        TypedQuery<Role> query=entityManager.createQuery(
                "select role from Role role WHERE role.id = :id",Role.class);
        return query
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public Role getByName(String name) {
        TypedQuery<Role>query = entityManager.createQuery(
                "select role from  Role  r WHERE r.role =:roleName",Role.class
        );
        return query
                .setParameter("roleName",name)
                .getSingleResult();
    }

    @Override
    public void upDate(Role roleUpdDate) {
        entityManager.merge(roleUpdDate);
    }
}
