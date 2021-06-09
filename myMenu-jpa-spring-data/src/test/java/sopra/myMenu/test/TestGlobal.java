package sopra.myMenu.test;

public class TestGlobal {

	public static void main(String[] args) {
		TestBaptiste tb = new TestBaptiste();
		tb.utilisateurAdressePreferenceAlimentaireCreate();
		tb.utilisateurAdressePreferenceAlimentaireUpdate();
		tb.utilisateurAdressePreferenceAlimentaireFindall();
		tb.utilisateurAdressePreferenceAlimentaireDelete();
		
		TestCamille tc = new TestCamille(); 
		tc.magasinIngredientCreate(); 
		tc.magasinIngredientDelete();
		tc.magasinIngredientFindAll();
		tc.magasinIngredientUpdate();
		tc.magasinIngredientFindByRisingPrice();
		tc.magasinIngredientFindAllBio();
		tc.magasinIngredientFindAllProduitLocal();
		tc.magasinIngredientFindByBrand();
		tc.magasinIngredientFindByMagasin();
		tc.ajustementCreateSimple();
		tc.ajustementCreateAvecLiens();
		tc.ajustementFindAll();
		tc.ajustementQuantiteDelete();
		tc.ajustementUpdate();
		tc.listeCourseCreateSimple();
		tc.listeCourseCreateAvecLien();
		tc.listeCourseUpdate();
		tc.listeCourseFindAll();
		tc.listeCourseDelete();
		tc.magasinCreate();
		tc.magasinDelete();
		tc.magasinFindAll();
		tc.magasinUpdate();
		tc.magasinFindByName();
		tc.magasinFindBySiret();
		tc.magasinFindByVille();
		tc.magasinFindByZipCode();
		
		
		TestPlat tp = new TestPlat();
		tp.platCreate();
		tp.platDelete();
		tp.platFindAll();
		tp.platUpdate();
		
		TestMenu tm = new TestMenu();
		
		tm.menuCreate();
		tm.menuDelete();
		tm.menuFindAll();
		tm.menuUpdate();
		
		TestRecette tr = new TestRecette();
		tr.RecetteCreate();
		tr.RecetteFindAll();
		tr.RecetteDelete();
		tr.RecetteUpdate();
		
		TestIngredient ti = new TestIngredient();
		ti.IngredientCreate();
		ti.IngredientDelete();
		ti.IngredientFindAll();
		ti.IngredientUpdate();
		
		TestObjectif to = new TestObjectif();
		to.objectifCreate();
		to.objectifUpdate();
		to.objectifFindAll();
		to.objectifDelete();
		
		TestPlanning tplan = new TestPlanning();
		tplan.planningCreate();
		tplan.planningUpdate();
		tplan.planningFindAll();
		tplan.planningDelete();

	}

}
