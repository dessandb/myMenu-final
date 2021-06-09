package sopra.myMenu.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.myMenu.model.Repas;
import sopra.myMenu.model.TypeRepas;
import sopra.myMenu.repository.IRepasRepository;

public class TestRepas {

	@Test
	public void repasCreate() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IRepasRepository repasRepo = context.getBean(IRepasRepository.class);
		
		Repas repas1 = new Repas();

		try {
			repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
			repas1 = repasRepo.save(repas1);

			Repas repasFind = repasRepo.findById(repas1.getId()).get();

			Assert.assertEquals(TypeRepas.PETIT_DEJ, repasFind.getTypeRepas());
		}

		finally {
			repasRepo.delete(repas1);
			context.close();
		}
	}

	@Test
	public void repasUpdate() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IRepasRepository repasRepo = context.getBean(IRepasRepository.class);

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);

		repas1 = repasRepo.save(repas1);

		repas1.setTypeRepas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);

		Repas repasFind = repasRepo.findById(repas1.getId()).get();

		try {
			Assert.assertEquals(TypeRepas.DINNER, repasFind.getTypeRepas());

		} finally {
			repasRepo.delete(repas1);
			context.close();
		}
	}

	@Test
	public void repasFindAll() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IRepasRepository repasRepo = context.getBean(IRepasRepository.class);

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);
		Repas repas2 = new Repas(TypeRepas.DEJ);
		Repas repas3 = new Repas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);
		repas2 = repasRepo.save(repas2);
		repas3 = repasRepo.save(repas3);

		List<Repas> repas = repasRepo.findAll();

		try {
			Assert.assertEquals(3, repas.size());
		}

		finally {
			repasRepo.delete(repas1);
			repasRepo.delete(repas2);
			repasRepo.delete(repas3);
			
			context.close();
		}

	}

	@Test
	public void repasDelete() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IRepasRepository repasRepo = context.getBean(IRepasRepository.class);

		Repas repas1 = new Repas(TypeRepas.PETIT_DEJ);
		Repas repas2 = new Repas(TypeRepas.DEJ);
		Repas repas3 = new Repas(TypeRepas.DINNER);

		repas1 = repasRepo.save(repas1);
		repas2 = repasRepo.save(repas2);
		repas3 = repasRepo.save(repas3);

		List<Repas> repas = repasRepo.findAll();

		try {
			Assert.assertEquals(3, repas.size());
		}

		finally {
			repasRepo.delete(repas1);
			repasRepo.delete(repas2);
			repasRepo.delete(repas3);

			repas = repasRepo.findAll();

			Assert.assertEquals(0, repas.size());
			
			context.close();
		}
	}

	/*
	 * CREATE TEST WITH LINKS
	 * 
	 * @Test public void repasCreate() {
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 * 
	 * IRepasRepository repasRepo = Application.getInstance().getRepasRepo();
	 * IMenuRepository menuRepo = Application.getInstance().getMenuRepo();
	 * IPlatRepository platRepo = Application.getInstance().getPlatRepo();
	 * 
	 * try {
	 * 
	 * Menu menu1 = new Menu(); menu1.setJour(sdf.parse("11-12-1993")); menu1 =
	 * menuRepo.save(menu1);
	 * 
	 * Plat plat1 = new Plat(); Plat plat2 = new Plat(); plat1.setNombrePersonne(2);
	 * plat2.setNombrePersonne(4); plat1 = platRepo.save(plat1); plat2 =
	 * platRepo.save(plat2);
	 * 
	 * List<Plat> plats = platRepo.findAll();
	 * 
	 * Repas repas1 = new Repas(); repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	 * repas1.setMenu(menu1); repas1.setPlats(plats);
	 * 
	 * repas1 = repasRepo.save(repas1);
	 * 
	 * Repas repasFind = repasRepo.findById(repas1.getId());
	 * 
	 * Assert.assertEquals(TypeRepas.PETIT_DEJ, repasFind.getTypeRepas());
	 * Assert.assertEquals(menu1, repasFind.getMenu()); Assert.assertEquals(plats,
	 * repasFind.getPlats());
	 * 
	 * menuRepo.delete(menu1); platRepo.delete(plat1); platRepo.delete(plat2);
	 * repasRepo.delete(repas1);
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); } }
	 * 
	 */

	/*
	 * UPDATE TEST WITH LINKS
	 * 
	 * @Test public void repasUpdate() {
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	 * 
	 * IRepasRepository repasRepo = Application.getInstance().getRepasRepo();
	 * IMenuRepository menuRepo = Application.getInstance().getMenuRepo();
	 * IPlatRepository platRepo = Application.getInstance().getPlatRepo();
	 * 
	 * try {
	 * 
	 * Menu menu1 = new Menu(); menu1.setJour(sdf.parse("11-12-1993")); menu1 =
	 * menuRepo.save(menu1);
	 * 
	 * Menu menu2 = new Menu(); menu2.setJour(sdf.parse("11-12-2000")); menu2 =
	 * menuRepo.save(menu2);
	 * 
	 * Plat plat1 = new Plat(); Plat plat2 = new Plat(); plat1.setNombrePersonne(2);
	 * plat2.setNombrePersonne(4); plat1 = platRepo.save(plat1); plat2 =
	 * platRepo.save(plat2); List<Plat> plats = platRepo.findAll();
	 * 
	 * Plat plat3 = new Plat(); Plat plat4 = new Plat();
	 * plat3.setNombrePersonne(10); plat4.setNombrePersonne(6); plat3 =
	 * platRepo.save(plat3); plat4 = platRepo.save(plat4); List<Plat> plats2 =
	 * platRepo.findAll();
	 * 
	 * Repas repas1 = new Repas(); repas1.setTypeRepas(TypeRepas.PETIT_DEJ);
	 * repas1.setMenu(menu1); repas1.setPlats(plats);
	 * 
	 * repas1 = repasRepo.save(repas1);
	 * 
	 * repas1.setTypeRepas(TypeRepas.DINNER); repas1.setMenu(menu2);
	 * repas1.setPlats(plats2);
	 * 
	 * Repas repasFind = repasRepo.findById(repas1.getId());
	 * 
	 * Assert.assertEquals(TypeRepas.DINNER, repasFind.getTypeRepas());
	 * Assert.assertEquals(menu2, repasFind.getMenu()); Assert.assertEquals(plats2,
	 * repasFind.getPlats());
	 * 
	 * menuRepo.delete(menu1); menuRepo.delete(menu2); platRepo.delete(plat1);
	 * platRepo.delete(plat2); platRepo.delete(plat3); platRepo.delete(plat4);
	 * repasRepo.delete(repas1);
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); } }
	 * 
	 */

}
