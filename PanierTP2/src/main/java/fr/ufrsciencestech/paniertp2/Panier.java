package fr.ufrsciencestech.paniertp2;

import static java.lang.Math.abs;
import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum de fruits que peut contenir le panier
	
    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
	this.contenanceMax = abs(contenanceMax);
	fruits = new ArrayList<Fruit>();
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
	String s = "";
	for(int i=0;i<getTaillePanier();i++)
	{
		s+= fruits.get(i).toString() + " - ";
	}
        return s;
    }
    
    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size() ;
    }
    
    public int getContenanceMax(){  //accesseur du second attribut
	return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
	Fruit f = this.fruits.get(i);
	return f;
    }
    
    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
	this.fruits.set(i, f);
    }
    
    public boolean estVide(){  //predicat indiquant que le panier est vide
	return this.fruits.isEmpty();
    }
    
    public boolean estPlein(){  //predicat indiquant que le panier est plein
	boolean estPlein = false;
      	if(this.fruits.size() == this.contenanceMax)
       		estPlein = true;
	return estPlein;
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
	if(o == null)
            return;
        if(this.fruits.size() < this.contenanceMax){
            this.fruits.add(o);
        }
        else throw new PanierPleinException();
    }

    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide
	if(this.fruits.size() == 0)
		throw new PanierVideException();
	else
		this.fruits.remove(this.fruits.size() - 1);
    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	double prix = 0;
	for(int i = 0 ; i < this.fruits.size(); i++)
		 prix = prix + this.fruits.get(i).getPrix();

	return prix;
    }
    
    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
	int i = 0;					//A
	while(i < fruits.size()){			//B
            if(fruits.get(i).getOrigine().equals(origine)) //C
		fruits.remove(i);			//D
            else								 
		i++ ;					//E
        }
    }
        
    //groupe 8    
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        return false;
    }
    
    //tests
    public static void main (String[] args){  //modifie par C. Roudet
	//Ecrire ici vos tests
	Poire p1 = new Poire();
	Orange o1 = new Orange(0.6, "Brésil");
	System.out.println(p1.toString());
	System.out.println(o1.toString());

	System.out.println("premier test Panier");
    	Panier p = new Panier(5);
	System.out.println(p.toString());
    	System.out.println("getFruits : "+ p.getFruits());
    	System.out.println("get taille panier : "+ p.getTaillePanier());
    	System.out.println("get contenace max : "+ p.getContenanceMax());
	System.out.println(p.getPrix());
    }

}


