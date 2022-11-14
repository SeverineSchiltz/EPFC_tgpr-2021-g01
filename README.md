# Projet TGPR 2020 - PaintballApp

## Description du projet

- Il s'agit d'une application desktop de type console en java qui permet la gestion d'un établissement de paintball.
- L'application a été codée sous IntelliJ et respecte le patron d'architecture MVC.
- Les infos pour créer la base de données MYSQL se trouve dans le dossier database.

## Notes de livraison

Liste des utilisateurs en base de données (username, password, role):
- lmalsag, leyla01, admin
- nvorkap, nikola01, employe
- sschilt, severine01, member
- ssoupar, sinouhe01, member
- cjadot, christophe01, member vip
- iboudgh, ines01, member vip

-------------------------------------------------------------------------------------

Liste des UC par personne:
		
	Christophe Jadot:
		- EditMenu : un employé peut modifier un member/membre vip et si c'est un admin modifier le status admin de l'employé
		             ou un membre peut se modifier lui-même
		- AddMember : Un employé peut ajouter un membre/membre vip
		- DisplayFieldsStats : affiche le nombre de réservation (non annulée et annulée) par terrain
		- DisplayFieldStatDetail : affiche le nombre de réservation (non annulée et annulée) par type de jeu pour le terrain choisi
	
	Sinouhé Soupart:
		- MainMenuMember : si la personne connectée est un membre ou membre vip alors elle est redirigée vers ce menu
		- SignUp : pour le visiteur qui veut s'ajouter dans l'application sans passer par un employé
		- DisplayAllFightTypes: affiche les différents types de combat possibles 
		
	Nikola Vorkapic:
		- CancelReservation : uc pour supprimer une réservation
		- BookFieldAndEquipment : uc pour réserver un terrain, les équipements, ...
	
	Leyla Malsagova:
		- DisplayAvailableFields : affiche les disponibilités des terrains en rentrant : date, moment et type de combat
		- DisplayAllFields : affiche tous les terrains + infos 
		- AddField : permet à un employé/admin d'ajouter un nouveau terrain dans la DB 
		- DisplayAllEquipments : affiche tous les équipements + infos 
		
	Ines Boudghene:
		- StartMenu: menu de démarrage de l'application
		- Login : menu pour se logger à l'application
		- DisplayFutureReservations : affiche toutes les réservations de tous les membres
		- DisplayMembers : affiches tous les membres enregistrés dans l'application
	
	Séverine Schiltz:
		- DisplayReservation : affiche les réservations du membre connecté
		- MainMenuEmployee : si la personne connectée est un employé ou admin alors elle est redirigée vers ce menu
		- AddEmployee : UC pour ajouter un employé
		- DisplayEmployee : affiche les employés et les admin
