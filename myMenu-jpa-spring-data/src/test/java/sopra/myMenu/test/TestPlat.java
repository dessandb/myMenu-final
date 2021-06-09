package sopra.myMenu.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import sopra.myMenu.model.Plat;

import sopra.myMenu.repository.IPlatRepository;

public class TestPlat {
	@Test	
	public void platCreate() {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(2);

		plat1 = platRepo.save(plat1);
		
		Plat platFind = platRepo.findById(plat1.getId()).get();
		
		
		
		Assert.assertEquals(2, platFind.getNombrePersonne());

		platRepo.delete(plat1);
		context.close();
		
	}

	@Test
	public void platUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(2);

		plat1 = platRepo.save(plat1);

		plat1.setNombrePersonne(4);

		plat1 = platRepo.save(plat1);
		Plat platFind = platRepo.findById(plat1.getId()).get();
		
		Assert.assertEquals(4, platFind.getNombrePersonne());;
		
				
		platRepo.delete(plat1);
		context.close();
	}

	@Test
	public void platFindAll() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(3);

		Plat plat2 = new Plat(3);

		plat1 = platRepo.save(plat1);
		plat2 = platRepo.save(plat2);

		List<Plat> plats = platRepo.findAll();

		Assert.assertEquals(2, plats.size());

		platRepo.delete(plat1);
		platRepo.delete(plat2);
			
		context.close();
	}

	@Test
	public void platDelete() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IPlatRepository platRepo = context.getBean(IPlatRepository.class);
		
		Plat plat1 = new Plat(2);

		Plat plat2 = new Plat(2);

		plat1 = platRepo.save(plat1);
		plat2 = platRepo.save(plat2);

		List<Plat> plats = platRepo.findAll();

		Assert.assertEquals(2, plats.size());

		platRepo.delete(plat1);
		platRepo.delete(plat2);

		plats = platRepo.findAll();

		Assert.assertEquals(0, plats.size());
		
		Assert.assertEquals(0, plats.size());
		context.close();
	}
}
