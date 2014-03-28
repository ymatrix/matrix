package com.zufe.test.activiti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivitiTest {

	private static ClassPathXmlApplicationContext ctx;

	static {
		String[] locations = { "applicationContext.xml"};
		ctx = new ClassPathXmlApplicationContext(locations);
		System.out.println(ctx);
	}

	@Test
	public void test() throws Exception{
		
		System.out.println(ctx);
		RepositoryService repositoryService =  (RepositoryService) ctx.getBean("repositoryService");
		IdentityService identityService =  (IdentityService) ctx.getBean("identityService");
		System.out.println(identityService);
//		String deploymentId = repositoryService
//				  .createDeployment()
//				  .addClasspathResource("workflow/hello.bpmn")
//				  .deploy()
//				  .getId();
//		System.out.println(deploymentId);
 
	}

}
