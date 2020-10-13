package fr.ufrsciencestech.paniertp2.model;


public class Cerise implements Fruit{
    private double prix;
    private String origine;
	
    public Cerise() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="France";
    }
    
    public Cerise(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "France";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Cerise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 cerise sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Cerise ce = (Cerise) o;
            return (prix == ce.prix && origine.equals(ce.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une cerise a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
	System.out.println("premier test Cerise");
    Cerise ce = new Cerise();
    System.out.println(ce.toString()); 
    System.out.println("test");

   }
}
