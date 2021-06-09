package sopra.myMenu.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.myMenu.model.Menu;
import sopra.myMenu.repository.IMenuRepository;

public class TestMenu {
	@Test
	public void menuCreate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IMenuRepository menuRepo = context.getBean(IMenuRepository.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Menu menu1 = new Menu();

		try {
			menu1.setJour(sdf.parse("11-12-1993"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menu1 = menuRepo.save(menu1);

		Menu menuFind = menuRepo.findById(menu1.getId()).get();

		try {
			Assert.assertEquals(sdf.parse("11-12-1993"), menuFind.getJour());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menuRepo.delete(menu1);
		context.close();
	}

	@Test
	public void menuUpdate() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IMenuRepository menuRepo = context.getBean(IMenuRepository.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		Menu menu1 = new Menu();
		try {
			menu1.setJour(sdf.parse("11-12-1993"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menu1 = menuRepo.save(menu1);

		try {
			menu1.setJour(sdf.parse("12-10-2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menu1 = menuRepo.save(menu1);

		Menu menuFind = menuRepo.findById(menu1.getId()).get();

		try {
			Assert.assertEquals(sdf.parse("12-10-2021"), menuFind.getJour());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		menuRepo.delete(menu1);
		context.close();
	}

	@Test
	public void menuFindAll() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IMenuRepository menuRepo = context.getBean(IMenuRepository.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {

			Menu menu1 = new Menu();
			Menu menu2 = new Menu();
			Menu menu3 = new Menu();

			menu1.setJour(sdf.parse("11-12-1993"));
			menu1.setJour(sdf.parse("11-12-2000"));
			menu1.setJour(sdf.parse("11-12-2021"));

			menu1 = menuRepo.save(menu1);
			menu2 = menuRepo.save(menu2);
			menu3 = menuRepo.save(menu3);

			List<Menu> menus = menuRepo.findAll();

			Assert.assertEquals(3, menus.size());

			menuRepo.delete(menu1);
			menuRepo.delete(menu2);
			menuRepo.delete(menu3);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		context.close();
	}

	@Test
	public void menuDelete() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IMenuRepository menuRepo = context.getBean(IMenuRepository.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {

			Menu menu1 = new Menu();
			Menu menu2 = new Menu();
			Menu menu3 = new Menu();

			menu1.setJour(sdf.parse("11-12-1993"));
			menu1.setJour(sdf.parse("11-12-2000"));
			menu1.setJour(sdf.parse("11-12-2021"));

			menu1 = menuRepo.save(menu1);
			menu2 = menuRepo.save(menu2);
			menu3 = menuRepo.save(menu3);

			List<Menu> menus = menuRepo.findAll();

			Assert.assertEquals(3, menus.size());

			menuRepo.delete(menu1);
			menuRepo.delete(menu2);
			menuRepo.delete(menu3);

			menus = menuRepo.findAll();

			Assert.assertEquals(0, menus.size());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		context.close();
	}

}
