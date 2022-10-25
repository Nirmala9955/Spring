package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
import com.nt.repo.CustomerRepo.ResultView1;
import com.nt.repo.CustomerRepo.ResultView2;

@SpringBootApplication
public class SpringDataProj05JpaRepoFinderMethodsProjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo custRepo = null;
		//get AC IoC container 
		ctx = SpringApplication.run(SpringDataProj05JpaRepoFinderMethodsProjectionApplication.class, args);
		//Get Repo bean 
		custRepo = ctx.getBean(CustomerRepo.class);
		//invoke the methods
		/*List<ResultView1> listRV = custRepo.findByCadd("hyd");
		listRV.forEach(rv -> System.out.println(rv.getCno()+" "+rv.getCname()));
		System.out.println("------------------------");
		custRepo.findByCnoBetween(2, 4).forEach(rv -> System.out.println(rv.getCname()+" "+rv.getBillAmount()));*/
		custRepo.findByCadd("hyd", ResultView1.class).forEach(rv -> System.out.println(rv.getCno()+" "+rv.getCname()));
		custRepo.findByCadd("hyd", ResultView2.class).forEach(rv -> System.out.println(rv.getCname()+" "+rv.getBillAmount()));
		custRepo.findByCadd("hyd", ResultView2.class).forEach(rv -> System.out.println(rv.getCname()+" "+rv.getBillAmount()));

		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
