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
		- EditProfil : un employé peut modifier un member/membre vip ou un membre peut se modifier lui-même
		- AddMember : Un employé peut ajouter un membre/membre vip
		- Statistique : affiche le nombre de fois qu'un terrain a été réservé
	
	Sinouhé Soupart:
		- MainMenuMember : si la personne connectée est un membre ou membre vip alors elle est redirigée vers ce menu
		- SignUp : pour le visiteur qui veut s'ajouter dans l'application sans passer par un employé
		- DisplayAllFightTypes: affiche les différents types de combat possibles 
		
	Nikola Vorkapic:
		- CancelReservation : uc pour supprimer une réservation
		- BookFieldAndEquipment : uc pour réserver un terrain, les équipements, ...
	
	Leyla Malsagova:
		- DisplayAvailableReservation : affiche les disponibilités des terrains, équipements, etc pour une date donnée
		
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