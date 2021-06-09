package sopra.myMenu.test;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.myMenu.model.Planning;
import sopra.myMenu.repository.IPlanningRepository;

public class TestPlanning {

	@Test
	public void planningCreate() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IPlanningRepository planningRepo = context.getBean(IPlanningRepository.class);

		Planning planning1 = new Planning();

		try {
			planning1.setPeriode(Duration.ofDays(7));
			planning1 = planningRepo.save(planning1);

			Planning planningFind = planningRepo.findById(planning1.getId()).get();

			Assert.assertEquals(Duration.ofDays(7), planningFind.getPeriode());
		}

		finally {
			planningRepo.delete(planning1);
			context.close();
		}
	}

	@Test
	public void planningUpdate() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IPlanningRepository planningRepo = context.getBean(IPlanningRepository.class);

		Planning planning1 = new Planning();

		try {
			planning1.setPeriode(Duration.ofDays(7));
			planning1 = planningRepo.save(planning1);

			planning1.setPeriode(Duration.ofDays(4));
			planning1 = planningRepo.save(planning1);

			Planning planningFind = planningRepo.findById(planning1.getId()).get();

			Assert.assertEquals(Duration.ofDays(4), planningFind.getPeriode());
		}

		finally {
			planningRepo.delete(planning1);
			context.close();
		}
	}

	@Test
	public void planningFindAll() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IPlanningRepository planningRepo = context.getBean(IPlanningRepository.class);

		Planning planning1 = new Planning();
		Planning planning2 = new Planning();
		Planning planning3 = new Planning();

		planning1.setPeriode(Duration.ofDays(7));
		planning2.setPeriode(Duration.ofDays(2));
		planning3.setPeriode(Duration.ofDays(5));

		planning1 = planningRepo.save(planning1);
		planning2 = planningRepo.save(planning2);
		planning3 = planningRepo.save(planning3);

		List<Planning> plannings = planningRepo.findAll();

		try {
			Assert.assertEquals(3, plannings.size());
		}

		finally {
			planningRepo.delete(planning1);
			planningRepo.delete(planning2);
			planningRepo.delete(planning3);
			context.close();
		}
	}

	@Test
	public void planningDelete() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IPlanningRepository planningRepo = context.getBean(IPlanningRepository.class);

		Planning planning1 = new Planning();
		Planning planning2 = new Planning();
		Planning planning3 = new Planning();

		planning1.setPeriode(Duration.ofDays(7));
		planning2.setPeriode(Duration.ofDays(2));
		planning3.setPeriode(Duration.ofDays(5));

		planning1 = planningRepo.save(planning1);
		planning2 = planningRepo.save(planning2);
		planning3 = planningRepo.save(planning3);

		List<Planning> plannings = planningRepo.findAll();

		try {
			Assert.assertEquals(3, plannings.size());
		}

		finally {
			planningRepo.delete(planning1);
			planningRepo.delete(planning2);
			planningRepo.delete(planning3);
			
			plannings = planningRepo.findAll();
			
			Assert.assertEquals(0, plannings.size());		
			context.close();
		}
	}

}
