package by.goncharov.dragon.core.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.goncharov.dragon.core.entity.Role;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Description of RoleDAOImplTest class
 *
 * @author Mikita Hancharou
 * @created 18.05.13 17:20
 */
public class RoleDAOImplTest {

    private static final String ROLE_NAME_OLD = "horse" + System.currentTimeMillis();
    private static final String ROLE_NAME_NEW = "bull" + System.currentTimeMillis();
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("../deploy/WEB-INF/applicationContext.xml");
    private static final RoleDAO ROLE_DAO = (RoleDAO) CONTEXT.getBean(RoleDAO.class);

    @Test
    public void testSaveFindUpdateDelete() throws Exception {
        Role role = new Role();

        role.setRoleName(ROLE_NAME_OLD);
        int saveRoleId = ROLE_DAO.save(role);
        Role byRoleId = ROLE_DAO.findByRoleId(saveRoleId);
        assertNotNull(byRoleId);
        assertEquals(ROLE_NAME_OLD, byRoleId.getRoleName());

        role.setRoleName(ROLE_NAME_NEW);
        ROLE_DAO.update(role);
        byRoleId = ROLE_DAO.findByRoleId(saveRoleId);
        assertNotNull(byRoleId);
        assertEquals(ROLE_NAME_NEW, byRoleId.getRoleName());

        ROLE_DAO.delete(byRoleId);
        byRoleId = ROLE_DAO.findByRoleId(saveRoleId);
        assertNull(byRoleId);
    }
}
