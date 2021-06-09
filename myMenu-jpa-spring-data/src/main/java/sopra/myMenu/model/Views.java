package sopra.myMenu.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewAdresse extends ViewCommon {}
	
	public static class ViewAdresseWithMagasin extends ViewAdresse {}
	
	public static class ViewAdresseWithUtilisateur extends ViewAdresse {}
	
	public static class ViewUtilisateur extends ViewCommon {}
	
	public static class ViewPreferenceAlimentaire extends ViewCommon {}
	
	public static class ViewPreferenceAlimentaireWithUtilisateur extends ViewPreferenceAlimentaire {}
	
	public static class ViewListeCourse extends ViewCommon{}
	
	public static class ViewListeCourseWithAjustement extends ViewListeCourse{}
	
	public static class ViewMagasin extends ViewCommon{}
	
	public static class ViewMagasinWithMagasinIngredient extends ViewMagasin{}
	
	public static class ViewAjustementQuantite extends ViewCommon{}
	
	public static class ViewMagasinIngredient extends ViewCommon{}
	
	
}
