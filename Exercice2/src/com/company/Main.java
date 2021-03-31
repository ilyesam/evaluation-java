import java.util.ArrayList;

class Plat{
    String nom;
    ArrayList<Ingredient> ingredients;
    Plat(String n){
        this.nom = n;
        this.ingredients = new ArrayList<Ingredient>();
    }
    String getNom(){
        return this.nom;
    }
    ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }
    void addIngredient(Ingredient i){
        this.ingredients.add(i);
    }

    public boolean equals(Object objet){
        if(objet instanceof Plat){
            for(Ingredient i:this.ingredients){
                if(!((Plat) objet).ingredients.contains(i)) return false;
            }
            return this.ingredients.size() ==
                    ((Plat) objet).ingredients.size();
        }
        else return false;
    }
    public static void main(String[] toto){
        Plat p = new Plat("Choucroute");
        p.addIngredient(new Ingredient("choucroute","cuite",500,"g"));
        p.addIngredient(new Ingredient("lard","cuit_entier",150,"g"));
        p.addIngredient(new Ingredient("saucisses","cuite_entiere",2,
                "cardinalité"));

    }
}

class Ingredient{

    private Ingredient nom_aliment;
    public String etat;

    public Ingredient(String choucroute, String cuite, int i, String g) {
    }

    public boolean equals(Object objet){
        return (objet instanceof Ingredient) &&
                this.nom_aliment.equals(((Ingredient) objet).nom_aliment) &&
                this.etat.equals(((Ingredient) objet).etat);
    }
}
class IngredientACuire extends Ingredient{
    int temperature;
    IngredientACuire(String n, String e, int q, String unite, int t){
        super(n,e,q,unite);
        this.temperature = t;
    }
    void cuire(){
        this.etat = "cuit";
    }
}
class IngredientADecouper extends Ingredient{
    IngredientADecouper(String n, String e, int q, String unite){
        super(n,e,q,unite);
    }
    void decouper(){
        this.etat = "decoupé";
    }
}