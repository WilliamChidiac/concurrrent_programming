package Modele;

import java.awt.Color;
import java.awt.Point;

public enum Plant_types {
    PLANT_TYPE1(5, 10, 4, 15, Color.PINK, "Rose", 
    "Fleur emblématique appréciée pour sa beauté et son parfum, souvent associée à l'amour et à la romance.",
    "Arrosez régulièrement les roses au pied, en évitant de mouiller les feuilles, pour maintenir un sol humide mais bien drainé.",
    "Taillez les roses régulièrement pour favoriser la croissance et la floraison, en supprimant les branches mortes et en coupant les fleurs fanées.",
    "Protégez les roses des maladies en surveillant les signes de maladie et en appliquant des traitements préventifs, comme la pulvérisation d'un fongicide."),
    PLANT_TYPE2(7, 12, 6, 20, Color.MAGENTA, "Tulipe", 
    "Fleur printanière caractérisée par ses pétales colorés et ses tiges élancées, offrant une beauté délicate dans les jardins et les bouquets.",
    "Plantez les bulbes de tulipes à l'automne",
    "Arrosez les tulipes modérément après la plantation et pendant leur croissance",
    "Une fois que les tulipes ont fleuri, coupez les fleurs fanées pour encourager la plante à concentrer son énergie sur le développement des bulbes pour la saison suivante."),
    PLANT_TYPE3(10, 17, 9, 25, Color.YELLOW, "Lys", 
    "Le lys, avec ses pétales délicats et son parfum envoûtant, est une fleur majestueuse souvent associée à la pureté et à la sophistication.",
    "Plantez les lys en les espaçant pour permettre une bonne circulation de l'air et éviter les maladies fongiques.",
    "Arrosez les lys régulièrement, en veillant à garder le sol légèrement humide mais pas détrempé.",
    "Retirez les fleurs fanées dès qu'elles se fanent pour encourager de nouvelles floraisons."),
    PLANT_TYPE4(14, 22, 13, 30, Color.WHITE, "Mangolia", 
    "Arbre élégant et majestueux, réputé pour ses grandes fleurs parfumées et ses feuilles brillantes.",
    "Plantez la magnolia dans un sol riche en matière organique, dans un endroit abrité du vent pour protéger ses fleurs délicates.",
    "Arrosez régulièrement la magnolia pendant les périodes sèches pour maintenir le sol humide, en veillant à ne pas mouiller excessivement le feuillage pour éviter les maladies.",
    "Taillez légèrement la magnolia après la floraison pour éliminer les branches mortes et encourager une nouvelle croissance saine.");

    public final int xp;
    public final int cost;
    public final int growthTime;
    public final int money_collected;
    public final Color color;
    public final String nom;
    public final String desc;
    public final String cons1;
    public final String cons2;
    public final String cons3;

    Plant_types(int xp, int cost, int growthTime, int money_collected, Color color, String nom, String desc, String c1, String c2, String c3) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.money_collected = money_collected;
        this.color = color;
        this.nom = nom;
        this.desc = desc;
        this.cons1 = c1;
        this.cons2 = c2;
        this.cons3 = c3;
    }

    /*
     * Create a plant of the given type at the given position
     */
    public Plant create_plant(Point pos) {
        return new Plant(this.xp, this.cost, this.growthTime, pos, this.money_collected, this.color);
    }
}