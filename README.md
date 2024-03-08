Cahier des charges : 

Projet PCII 

 

 

Présentation 

Nous allons réaliser un jeu de stratégie en temps réelle, dans notre cas le jeu se déroule dans une jardinerie, l’objectif est de planter et récolter le plus de plantes possibles tout en les protégeant des lapins qui veulent les manger. Pour cela le joueur pourra contrôler différents jardiniers qui pourront planter et récolter les plantes et qui auront un certain rayon de protection contre les lapins. Le joueur gagne des points pour chaque plante qu’il a récolté ainsi que de l’argent pour pouvoir employer de nouveaux jardiniers ou acheter des plantes. Le joueur doit réunir un certain nombre de points avant la fin du temps imparti pour gagner. 

Contraintes 

 

Il faut que le joueur puisse déplacer les jardiniers dans l’environnement à l’aide de la souris, priorité = 1 et difficulté = 2 

Il faut que les jardiniers soient visibles dans l’environnement, priorité = 1 et difficulté = 1 

Lorsque l’on clique sur un jardinier un menu doit s’ouvrir indiquant l’état du jardinier (en mouvement ou non), la possibilité d’arrêter le déplacement du jardinier, la possibilité de planter, ou encore la possibilité de cueillir une plante si celle-ci est prête à être cueillie. priorité = 1 et difficulté = 2 

Il faut que les fleurs plantes évoluent dans le temps (poussent) jusqu’à ce qu’elles soient prêtes à être cueillies, priorité = 1 et difficulté = 2 

Lorsqu’elles ne sont pas prêtes à être cueillies les fleurs ont un visuel classique (éventuellement juste la fleur ou un petit logo d’une montre au-dessus de celle-ci) et quand elles sont prêtes à être cueillies ce visuel doit changer pour indiquer au joueur la possibilité de cueillir la fleur. priorité = 1 et difficulté = 2 

Lorsque l’on clique sur la fleur un menu indiquant l’état de pousse de la fleur doit apparaître. priorité = 1 et difficulté = 2 

Il faut que des lapins apparaissent régulièrement aux extrémités du jardin (éventuellement de plus en plus), priorité = 1 et difficulté = 2 

Il faut que les lapins se déplacent vers les fleurs avec une certaine vitesse (éventuellement de plus en plus vite), priorité = 1 et difficulté = 3 

Lorsqu’un lapin atteint une fleur, la fleur se fait manger par le lapin et elle disparaît, priorité = 1 et difficulté = 1 

Les lapins ne restent pas constamment dans le jardin, Il faut qu’au bout d’un certain temps le lapin sorte du jardin, priorité = 1 et difficulté = 2 

Lorsque l’on clique sur les lapins un menu indiquant le temps restant avant le départ du lapin, priorité = 1 et difficulté = 2 

Lorsqu’un jardinier cueille une fleur, il faut que l’argent et les points augmentent de la quantité que cette fleur apporte (éventuellement rajouter un système de rareté des fleurs, plus la fleur et rare plus elle rapporte de points et de l’argent), priorité = 1 et difficulté = 1 

Planter doit coûter de l’argent et celui-ci doit-être prélevé de la bourse du joueur, s’il n’a pas assez d’argent le joueur ne peut pas planter (éventuellement plus la fleur est rare plus elle coûte cher), priorité = 1 et difficulté = 2 

Le temps de pousse peut varier en fonction de la fleur (éventuellement plus la fleur est rare plus elle met du temps à pousser), priorité = 2 et difficulté = 2 

Il doit y avoir un objectif dans les points (le joueur gagne s’il a atteint un certain nombre de points par exemple), priorité = 1 et difficulté = 1 

Les parties sont limités dans le temps, il faut afficher le temps restant (le joueur doit gagner avant la fin du temps imparti, sinon il a perdu), priorité = 1 et difficulté = 2 

Il faut qu’il y ait un bouton de magasin où l’on peut choisir quelles fleurs acheter pour les planter, lorsque l’on clique sur ce bouton un menu s’affiche contenant les différentes fleurs et leur prix, priorité = 2 et difficulté = 3 

Le score doit être affiché, priorité = 1 et difficulté = 1 

 

Fonctionnalités que l’on souhaite implémenter 

Temps de travail en termes d’analyse, conception, développement et test pour chaque fonctionnalité : 

Apprentissage pour mettre les images des jardiniers, plantes, lapins : 30 mins 

Visibilité des jardiniers : 15 mins 

Déplacement des jardiniers : 30 mins 

Menu du jardinier :  15 mins 

Fonctionnalités du jardinier (arrêter le déplacement, planter, cueillir) : 45 mins 

Visibilité des plantes : 15 mins 

Évolution des plantes : 15 mins 

Visuel classique/cueillir des plantes : 15 mins 

Menu de la plante : 15 mins 

Apparition des lapins : 30 mins 

Déplacement des lapins vers les plantes : 45 mins 

Lapin qui mange une plante : 15 mins 

Disparition des lapins : 15 mins 

Menu du lapin : 15 mins 

Cueillette d’une plante : 30 mins 

Planter par le jardinier : 45 mins 

Système de boutique pour les plantes : 1h 

Variété de fleurs : 30 mins 

Définition d’un objectif de points : 15 mins 

Défilement du temps : 15 mins 

Affichage du score : 15 mins 

 

 

 

 

 

 

 

 

 

 

 

 

Partie Jewin : 

mode d'emploi pour push :

git status
git add cheminFichier
git commit -m "message"
git push origin jewin:jewin 


4. Conception générale : 

Model : 

Vue : GameInterface 

Controller :  

5. Conception détaillée : 

Interface du jeu :
On utilise les API Swing et Awt plus précisément JPanel, JFrame et ActionListener pour créer la fenêtre de jeu.
- Struture des données : constantes entières (WIDTH, HEIGHT)
- On utilise un GridLayout et un BorderLayout pour organiser les éléments de l’interface, un panel principal composé 
de deux panels représentant les boutons interactif et la carte.

6. Résultat : 

Une fenêtre composé de 4 boutons à droite et d'une carte vide à gauche.

7. Documentation utilisateur : 

Nécessite un IDE pour lancer le main de la classe GameInterface. 

8. Documentation développeur : 

Les constantes pour modifier la taille de la fenêtre sont dans la classe GameInterface.
Pour modifier/ajouter des boutons, il faut modifier le constructeur de la classe GameInterface.


9. Conclusion et perspectives : 

On peut éventuellement améliorer la fenêtre de jeux en ajoutant une délimitations entre les boutons et la carte et 
ajouter des images/colorés/redimensionner les boutons.

 

 

 

 

 

 

 
