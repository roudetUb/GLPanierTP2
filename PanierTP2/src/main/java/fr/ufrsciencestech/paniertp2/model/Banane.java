package fr.ufrsciencestech.paniertp2.model;

public class Banane implements Fruit
{
    private double prix;
    private String origine;
		
    public Banane(double prix, String origine)
    {
	this.prix = prix;
	this.origine = origine;
    }
    public Banane()
    {
	prix = 10000.69;
	origine = "Martiniquai";
    }
		
    public double getPrix()
    {
	return this.prix;
    }
		
    public void setPrix(double prix)
    {
	this.prix=prix;
    }
		
    public String getOrigine()
    {
	return this.origine;
    }
    public void setOrigine(String origine)
    {
	this.origine=origine;
    }
		
    public String toString()
    {
	return "Banane de " + this.origine + " a " + this.prix + " euros.";
    }
		
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Banane bn = (Banane) o;
            return (prix == bn.prix && origine.equals(bn.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une banane n'a pas de pepins
        return true;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
	
   }
}