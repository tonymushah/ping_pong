ETU 001844

// TODO Ping Pong by Walawala 


Contrôle joueur ORANGE 
Gauche : Q
Droite : D 

Contrôle joueur Bleu
Gauche : Toûche directionnel Gauche
Droite : Toûche directionnel Droite

Lancer le ballon : ESPACE

TODO les bugs
BUG le ballon ne rebondit pas parfois lorsqu'ils est en dehors du cadre
BUG le ballon passe a travers les joeurs 
BUG le ballon bug lorsqu'on le lance en dehors du cadre (toujours à l'horizontal) 

si vous utiliser un Linux ou un WSL (os recommandé : FEDORA 35) , voici quelque commandes

Compiler et demarrer Main
$ bash ./build_run.sh Main 

demarrer seulement Main
$ bash ./run_main.sh Main

NOTE : en utilisant cette commandes, les sorties vers la console vont:
    -- ./logs/output1.log pour les sorties standarts
    -- ./logs/output2.log pour les sorties d'erreurs 

Pour ce qui n'ont pas WSL ou pas sous_linux: 
le script ./launch_.bat est prévue pour celui-ci 


Environnement developpement: 
java 17.0.2 2022-01-18 LTS
Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
vscode 1.67.1x64