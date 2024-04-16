package Modele;

import java.awt.*;

import static Modele.Constant_prix_temps_xp.*;

public class EspecePlante {

        private String nom;
        private String description;
        private String conseil1;
        private String conseil2;
        private String conseil3;
        private Color couleur;

        private int prix;
        private int timeGrowth;
        private int xp;

        public int getPrix() {
            return prix;
        }

        public int getTimeGrowth() {
            return timeGrowth;
        }
        public String getNom(){
            return this.nom;
        }
        public String getDescription(){
            return this.description;
        }
        public String getConseil1(){
            return this.conseil1;
        }
        public String getConseil2(){
            return this.conseil2;
        }
        public String getConseil3(){
            return this.conseil3;
        }

        public Color getCouleur() {
            return couleur;
        }

        public EspecePlante(){

            this.nom = "Plante";
            this.prix = 0;
            this.timeGrowth = 0;
            this.couleur = Color.BLACK;
            this.description = null;
            this.conseil1 = null;
            this.conseil2 = null;
            this.conseil3 = null;
            this.xp = 0;
        }

        public void initRose(){
            this.nom = "Rose";
            this.prix = roseP;
            this.timeGrowth = roseT;
            this.couleur = Color.PINK;
            this.xp = roseXP;

            this.description = "Fleur emblématique appréciée pour sa beauté et son parfum, souvent associée à l'amour et à la romance.";
            this.conseil1 = "Arrosez régulièrement les roses au pied, en évitant de mouiller les feuilles, pour maintenir un sol humide mais bien drainé.";
            this.conseil2 = "Taillez les roses régulièrement pour favoriser la croissance et la floraison, en supprimant les branches mortes et en coupant les fleurs fanées.";
            this.conseil3 = "Protégez les roses des maladies en surveillant les signes de maladie et en appliquant des traitements préventifs, comme la pulvérisation d'un fongicide.";


        }

        public void initMagnolia(){
            this.nom = "Magnolia";
            this.prix = magnoliaP;
            this.timeGrowth = magnoliaT;
            this.couleur = Color.WHITE;
            this.xp = magnoliaXP;

            this.description = "Arbre élégant et majestueux, réputé pour ses grandes fleurs parfumées et ses feuilles brillantes.";
            this.conseil1 = "Plantez la magnolia dans un sol riche en matière organique, dans un endroit abrité du vent pour protéger ses fleurs délicates.";
            this.conseil2 = "Arrosez régulièrement la magnolia pendant les périodes sèches pour maintenir le sol humide, en veillant à ne pas mouiller excessivement le feuillage pour éviter les maladies.";
            this.conseil3 = "Taillez légèrement la magnolia après la floraison pour éliminer les branches mortes et encourager une nouvelle croissance saine.";
        }

        public void initTulipe(){
            this.nom = "Tulipe";
            this.prix = tulP;
            this.timeGrowth = tulT;
            this.couleur = Color.MAGENTA;
            this.xp = tulXP;

            this.description = "Fleur printanière caractérisée par ses pétales colorés et ses tiges élancées, offrant une beauté délicate dans les jardins et les bouquets.";
            this.conseil1 = "Plantez les bulbes de tulipes à l'automne";
            this.conseil2 = "Arrosez les tulipes modérément après la plantation et pendant leur croissance";
            this.conseil3 = "Une fois que les tulipes ont fleuri, coupez les fleurs fanées pour encourager la plante à concentrer son énergie sur le développement des bulbes pour la saison suivante.";
        }
        public void initLys(){
            this.nom = "Lys";
            this.prix = lysP;
            this.timeGrowth = lysT;
            this.couleur = Color.YELLOW;
            this.xp = lysXP;

            this.description = "Le lys, avec ses pétales délicats et son parfum envoûtant, est une fleur majestueuse souvent associée à la pureté et à la sophistication.";
            this.conseil1 = "Plantez les lys en les espaçant pour permettre une bonne circulation de l'air et éviter les maladies fongiques.";
            this.conseil2 = "Arrosez les lys régulièrement, en veillant à garder le sol légèrement humide mais pas détrempé.";
            this.conseil3 = "Retirez les fleurs fanées dès qu'elles se fanent pour encourager de nouvelles floraisons.";
        }

    public void initPlante(EspecePlante plante){
        String np = plante.getNom();
        switch (np){
            case "Rose" : plante.initRose();
                break;
            case "Tulipe" : plante.initTulipe();
                break;
            case "Lys" : plante.initLys();
                break;
            case "Magnolia" : plante.initMagnolia();
        }
    }

}
