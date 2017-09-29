import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Matrice {
	public static List Name;
	public static List theme;
	public static int[][] tab;
	public static int[][] mutBinaire;
	public static int[][] mtt;
	public static int[][] mttBinaire;
	public static int[][] mutR;
	
	public Matrice() {
		// TODO Auto-generated constructor stub
	}
	
	public final void remplirMutBinaire(final int[][] tableau){
		int longueur = tableau.length;
		int largeur = tableau[0].length;
		
		mutBinaire = new int[longueur][largeur];
		
		for(int i=0;i< longueur;i++){
			for(int y=0;i<largeur;i++){
				if(tableau[i][y]>0)
					mutBinaire[i][y]=1;
				else
					mutBinaire[i][y]=0;
			}
		}	
	}
	
	public final void remplirMtt(final int[][] tableau){
		
	}
	
	public static void printMatrice(final int[][] mat){
		
	}
	
	

	public static void main(String[] args) throws IOException {
		File fichier = new File("test.txt");
		BufferedReader br = new BufferedReader(new FileReader(fichier));
		String line;
		Name = new ArrayList();
		theme = new ArrayList();
		
		try {
			while ((line = br.readLine()) != null) {
				String[] retval = line.split(";");
				if(!Name.contains(retval[1]))
					Name.add(retval[1]);
				
				if(!theme.contains(retval[2]))
					theme.add(retval[2]);		
				}
		br.close();	
		}
		catch (Exception e){
		}
		
		int nameSize = Name.size();
		int themeSize = theme.size();

		tab = new int[nameSize][themeSize];
		br = new BufferedReader(new FileReader(fichier));
		int idName;
		int idTheme;
		
		try {
			while ((line = br.readLine()) != null) {
				String[] retval = line.split(";");
				tab[Name.indexOf(retval[1])][theme.indexOf(retval[2])]++;
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/**
		for (int i = 0; i < theme.size(); i++) {
			System.out.println(theme.get(i));
		}
		*/
		
		

		//affichage de la matrice
		for (int i= 0; i<nameSize; i++) {
			System.out.println(Name.get(i));
			for (int y = 0; y < themeSize; y++) {
				System.out.println(theme.get(y) + " : " + tab[i][y]);
				
			}
		}
		
	}
}
