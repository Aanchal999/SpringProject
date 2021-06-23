package mfsi.learnmvc.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import mfsi.learnmvc.service.RoleService;
import mfsi.learnmvc.service.UserService;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		roleService.populateRoles();
		userService.createAdminIfNotExists();
	}

}
