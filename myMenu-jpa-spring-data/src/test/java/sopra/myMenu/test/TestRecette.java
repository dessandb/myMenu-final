package sopra.myMenu.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.myMenu.model.Ingredient;
import sopra.myMenu.model.ProduitSaison;
import sopra.myMenu.model.Recette;
import sopra.myMenu.model.TypeAlimentation;
import sopra.myMenu.model.TypeProduit;
import sopra.myMenu.repository.IIngredientRepository;
import sopra.myMenu.repository.IRecetteRepository;


public class TestRecette {
	@Test	
	public void RecetteCreate() {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
	
		
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
			
			
		rec1 = recRepo.save(rec1);
		
		Recette recFind = recRepo.findById(rec1.getId()).get();
		try {
		Assert.assertEquals("couscous", recFind.getNom());
		Assert.assertEquals( "mettre les legumes et le poulet", recFind.getEtapes());
		Assert.assertEquals( 5, recFind.getNombrePers());
		Assert.assertEquals(800, recFind.getTotalCalories());
		Assert.assertEquals(TypeAlimentation.HALAL, recFind.getTypeRecette());
		
		}finally {
						
		recRepo.delete(rec1);
		
		context.close();
	}}
	
	@Test	
	public void RecetteUpdate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
		
		rec1 = recRepo.save(rec1);
		
							
		rec1.setNom("tartiflette");
		rec1.setEtapes("patate et reblochon");
		rec1.setNombrePers(8);
		rec1.setTotalCalories(500);
		rec1.setTypeRecette(TypeAlimentation.NONE);
		
			
		rec1 = recRepo.save(rec1);
		Recette recFind = recRepo.findById(rec1.getId()).get();
		try {
		Assert.assertEquals("tartiflette", recFind.getNom());
		Assert.assertEquals( "patate et reblochon", recFind.getEtapes());
		Assert.assertEquals( 8, recFind.getNombrePers());
		Assert.assertEquals(500, recFind.getTotalCalories());
		Assert.assertEquals(TypeAlimentation.NONE, recFind.getTypeRecette());
		}finally {
				
		recRepo.delete(rec1);
		context.close();
	}}
	
	@Test
	public void RecetteFindAll() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
						
		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
		
		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);

		rec1 = recRepo.save(rec1);
		rec2 = recRepo.save(rec2);
		rec3 = recRepo.save(rec3);
			
		
		List<Recette> recettes = recRepo.findAll();
		try {
		Assert.assertEquals(3, recettes.size());
		}finally {
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
			
		context.close();
	}
	}

	@Test
	public void RecetteDelete() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
		
		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);
						
		Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
		
		Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 800,5F, TypeAlimentation.HALAL);

		rec1 = recRepo.save(rec1);
		rec2 = recRepo.save(rec2);
		rec3 = recRepo.save(rec3);
			
		
		List<Recette> recettes = recRepo.findAll();
		
		Assert.assertEquals(3, recettes.size());
	
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
		
		recettes = recRepo.findAll();
		
		Assert.assertEquals(0, recettes.size());
		context.close();
	}
	@Test
	public void findByRisingCalories() {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:application-context.xml");
		IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
	
	Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,5F, TypeAlimentation.HALAL);
					
	Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
	
	Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,5F, TypeAlimentation.HALAL);

	rec1 = recRepo.save(rec1);
	rec2 = recRepo.save(rec2);
	rec3 = recRepo.save(rec3);
	
	List<Recette> recettesParCalories = recRepo.findByRisingCalories();
	try {
		Assert.assertEquals(rec1.getId(), recettesParCalories.get(1).getId());
		Assert.assertEquals(rec2.getId(), recettesParCalories.get(2).getId());
		Assert.assertEquals(rec3.getId(), recettesParCalories.get(0).getId());
	}finally{
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
	}
	
}
	@Test
public void findByName() {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);

	Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,5F, TypeAlimentation.HALAL);
	
Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);

Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,5F, TypeAlimentation.HALAL);

rec1 = recRepo.save(rec1);
rec2 = recRepo.save(rec2);
rec3 = recRepo.save(rec3);


	List<Recette> recettesParNom = recRepo.findByName("couscous");
	try {
		Assert.assertEquals(rec1.getId(), recettesParNom.get(0).getId());
	} finally {
		recRepo.delete(rec1);
	}
	}
//	@Test
//	public void findByRisingNote() {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//		IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);
//
//		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,3F, TypeAlimentation.HALAL);
//		
//	Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);
//
//	Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,2F, TypeAlimentation.HALAL);
//
//	rec1 = recRepo.save(rec1);
//	rec2 = recRepo.save(rec2);
//	rec3 = recRepo.save(rec3);
//
//
//	List<Recette> recettesParNote = recRepo.findByRisingNote();
//	try {
//		Assert.assertEquals(rec1.getId(), recettesParNote.get(1).getId());
//		Assert.assertEquals(rec2.getId(), recettesParNote.get(2).getId());
//		Assert.assertEquals(rec3.getId(), recettesParNote.get(0).getId());
//	}finally{
//		recRepo.delete(rec1);
//		recRepo.delete(rec2);
//		recRepo.delete(rec3);
//	}
//	
//}
	@Test
	public void findByTypeAlimentation() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		IRecetteRepository recRepo = context.getBean(IRecetteRepository.class);

		Recette rec1 = new Recette("couscous", "mettre les legumes et le poulet", 5, 200,3F, TypeAlimentation.HALAL);
		
	Recette rec2 = new Recette("tartiflette", "patate et reblochon", 5, 800,5F, TypeAlimentation.NONE);

	Recette rec3 = new Recette("couscous", "mettre les legumes et le poulet", 5, 10,2F, TypeAlimentation.HALAL);

	rec1 = recRepo.save(rec1);
	rec2 = recRepo.save(rec2);
	rec3 = recRepo.save(rec3);


	List<Recette> recettesPartypalim = recRepo.findByTypeAlimentation(TypeAlimentation.HALAL);
	try {
		Assert.assertEquals(rec1.getId(), recettesPartypalim.get(0).getId());
		
	}finally{
		recRepo.delete(rec1);
		recRepo.delete(rec2);
		recRepo.delete(rec3);
	}
	
}
	
}




