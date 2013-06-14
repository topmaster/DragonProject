import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.goncharov.dragon.core.HelloService;
import by.goncharov.dragon.core.dao.RoleDAO;
import by.goncharov.dragon.core.entity.Role;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("../deploy/WEB-INF/applicationContext.xml");
        // hibernate
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());

        String roleName = "horse" + System.currentTimeMillis();
        Role role = new Role();
        role.setRoleName(roleName);

        RoleDAO roleDao = (RoleDAO) context.getBean(RoleDAO.class);
        int roleId = roleDao.save(role);
        Role byRoleId = roleDao.findByRoleId(roleId);

        // locale
        Locale locale = Locale.US;
        String name = context.getMessage("customer.name", new Object[] {24, "http://vk.com/topmaster"}, locale);
        System.out.println("Customer name (English) : " + name);

        String buffer = context.getMessage("contact.type.acquaintance", null, locale);
        System.out.println("Customer name (English) : " + buffer);

        buffer = context.getMessage("contact.type.candidate", null, locale);
        System.out.println("Customer name (English) : " + buffer);

        buffer = context.getMessage("contact.type.customer", null, locale);
        System.out.println("Customer name (English) : " + buffer);

        buffer = context.getMessage("contact.type.distributor", null, locale);
        System.out.println("Customer name (English) : " + buffer);

        buffer = context.getMessage("contact.type.dropped_out", null, locale);
        System.out.println("Customer name (English) : " + buffer);

        locale = Locale.GERMANY;

        String nameGerman = context.getMessage("customer.name", new Object[] {24, "http://vk.com/topmaster"}, locale);
        System.out.println("Customer name (German) : " + nameGerman);

        buffer = context.getMessage("contact.type.acquaintance", null, locale);
        System.out.println("Customer name (German) : " + buffer);

        buffer = context.getMessage("contact.type.candidate", null, locale);
        System.out.println("Customer name (German) : " + buffer);

        buffer = context.getMessage("contact.type.customer", null, locale);
        System.out.println("Customer name (German) : " + buffer);

        buffer = context.getMessage("contact.type.distributor", null, locale);
        System.out.println("Customer name (German) : " + buffer);

        buffer = context.getMessage("contact.type.dropped_out", null, locale);
        System.out.println("Customer name (German) : " + buffer);
    }
}
