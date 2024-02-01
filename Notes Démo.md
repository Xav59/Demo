# Déroulement de la démo

## Explication de code
- 1er use case: ne rien sélectionner et demander un `Explain`
  - > montrer le résultat dans le chat
- 2e use case: sélectionner la méthode ligne 49 `getConcatOfFirstAndLastDigits` et demander `Explain`
  - > montrer dans le chat l'explication assez détaillée


## Génération de javadoc
- Sélectionner la méthode ligne 49 `getConcatOfFirstAndLastDigits` et demander `Generate Docs`


## Complétion de code

- Dans le `main`, faire une refacto pour ajouter un `try/catch`
- Supprimer le contenu du bloc exception
- Commencer à saisir `System.out...` et la magie opère


## Génération de code à partir de consignes

- 1er use case: dans la saisie de code
  - Ligne 64, à la fin du commentaire, faire `Entrée` et éventuellement commencer à saisir `if...`
- 2e use case: via le chat
  - dans le chat, demander l'ajout d'un try/catch dans la méthode readFile:
```
In the method readFile, surround the existing code with a try/catch to log exception
```
  - > montrer les commentaires que Copilot a mis
  - > montrer les boutons d'action sur le résultat
  - > montrer le code généré
  - > noter que les commentaires ont disparu


## Résolution de problèmes

- 1er use case: dans la saisie de code
  - Ligne 53, faire un clic droit `Copilot > Fix This`
- 2e use case: via le chat
  - dans le chat, demander de chercher où peuvent se produire des NPE:
```
@workspace Find where a NullPointerException can occure and fix the code
```
- 3e use case: une limite de l'outil
  - > montrer la logique rapidement d'aller chercher le 1er digit puis le dernier
  - Ligne 76, demander de traiter le `FIXME` pour éviter les `NumberFormatException`
    - > montrer qu'il veut supprimer un bloc de code :/


## Génération de tests unistaires
- Dans le chat, faire un `/tests`
  - montrer le résultat avec les différents cas de test
- Demander à changer de framework de test: `use JUnit4 instead of JUnit5`
  - montrer le changement dans les `import` et les `assertFalse`

