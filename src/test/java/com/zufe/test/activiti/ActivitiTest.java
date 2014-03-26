package com.zufe.test.activiti;

import org.activiti.engine.RepositoryService;
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
	public void test(){
		
		System.out.println(ctx);
		
		RepositoryService repositoryService =  (RepositoryService) ctx.getBean("repositoryService");
		
		String deploymentId = repositoryService
				  .createDeployment()
				  .addClasspathResource("workflow/hello.bpmn")
				  .deploy()
				  .getId();
		System.out.println(deploymentId);
 
	}

}
