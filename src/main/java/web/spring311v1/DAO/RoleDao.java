package web.spring311v1.DAO;

import web.spring311v1.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();

    void add(Role role);

    void delete(Long id);

    Role getById(Long id);

    Role getByName(String string);

    void upDate(Role roleUpdDate);
}

