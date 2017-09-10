Projet Java EE

Effectué par Jérémy Duong, Antoine Goubin et Coline Patris

Environnement de travail : utilisation d'une base de données MySQL configurée grace à PHPMyAdmin et du serveur d'application Wildfly 11

Nous n'avons pas écrit de commentaires dans les fichiers JSP car ils provoquaient des erreurs de compilation.

La page d'entrée dans ce programme est la page connection, qui permettra de déterminer si vous êtes un administrateur, un employé ou un nouvel utilisateur.

De là, un administrateur pourra voir le niveau global de satisfaction des employés, les derniers commentaires postés et éditer/supprimer des employés ou en créer de nouveaux. Il pourra également modifier le template du prochain MOTM envoyé.
Un employé pourra quand à lui voir le niveau global de satisfaction, les derniers commentaires et éditer la dernière opinion qu'il a posté.
Les nouveaux utilisateurs sont par défaut des employés.
