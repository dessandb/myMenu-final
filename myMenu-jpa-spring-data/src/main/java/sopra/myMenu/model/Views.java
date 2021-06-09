package sopra.myMenu.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewAdresse extends ViewCommon {}
	
	public static class ViewAdresseWithMagasin extends ViewAdresse {}
	
	public static class ViewAdresseWithUtilisateur extends ViewAdresse {}
	
	public static class ViewUtilisateur extends ViewCommon {}
	
	public static class ViewPreferenceAlimentaire extends ViewCommon {}
	
	public static class ViewPreferenceAlimentaireWithUtilisateur extends ViewPreferenceAlimentaire {}
	
}
