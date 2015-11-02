Jeu du Donjon
DUBOIS Yann - HEMBERT Romain
Groupe 1
03/11/2015


*** 1/ Introduction

Cette application simule le problème de la piscine :
Plusieurs personne doivent se partager des paniers et des cabines et aller nager. Pour qu'il y ai naturellement un problème, il faut qu'il y ai moins de panier et de cabnes que de nageurs (pour créer une file d'attente)


*** 2/ Usage

Pour lancer l'application, allez dans le dossier du .jar et tapez :
java -jar tp04-dubois-yann-hembert-romain.jar

*** 3/ Architecture

Les sources sont divisées en plusieurs packages :
- action : regroupe toutes les différentres classes d'action et les schedulers (hors Swimmer)
- exceptions : regroupe les exceptions de l'application
- main : Main de l'application
- pool : regroupe les pools des différentes ressources
- resources : regroupes les ressrouces de l'application (Panier, cabine)
- swimmer : garde la classe swimmer

Les tests sont structurés aussi par package et chaque classe de test teste une classe précise.

*** 4/ Code sample

Voici le doStep de la classe FairScheduler. Il permet de faire 1 étape, action par action, puis ensuite de revenir au début pour poursuivre l'étape suivante de chaque action :

    public void doStep() throws ActionFinishedException {
        super.doStep();
        Action toDo = this.actions.get(index); // On récupère l'action à la position index dans la liste d'actions
        toDo.doStep();
        if(toDo.isFinished()){
            this.actions.remove(index);
        }
        
        try {
            // On tente d'incrémenter l'index, si c'est impossible, retour en début de liste d'action
            if(this.actions.get(index+1) != null){
                index++;
            }
        } catch (IndexOutOfBoundsException e) {
            index = 0;
        }
    }