Execução do CheckStyle para o Exemplo de Jabuti

Tempo de execução:

  * real 0m1.361s
  * user 0m1.104s
  * sys 0m0.076s


O CheckStyle encontro os seguentes problemas no estilo de codificação, usando os modulos definidos em http://jabutimetrics.googlecode.com/files/jabuti_checks.xml:

```
java -jar checkstyle-all-5.0-beta2.jar -c jabuti_checks.xml  $*.java > checkstyle-test.txt

```

```
$/Dispenser.java:0: Missing package-info.java file.
$/Dispenser.java:1: Linha contém mais do que 80 caracteres.
$/Dispenser.java:22:1: Class should define a constructor.
$/Dispenser.java:28: array initialization lcurly no nível de indentação 12 não está na indentação correcta, 4
$/Dispenser.java:28:21: '3' é um número mágico.
$/Dispenser.java:28:24: '4' é um número mágico.
$/Dispenser.java:28:27: '6' é um número mágico.
$/Dispenser.java:28:30: '7' é um número mágico.
$/Dispenser.java:28:33: '8' é um número mágico.
$/Dispenser.java:28:36: '9' é um número mágico.
$/Dispenser.java:28:39: '10' é um número mágico.
$/Dispenser.java:29: Filho de array initialization no nível de indentação 16 não está na indentação correcta, [8, 14]
$/Dispenser.java:29:17: '11' é um número mágico.
$/Dispenser.java:29:21: '12' é um número mágico.
$/Dispenser.java:29:25: '13' é um número mágico.
$/Dispenser.java:29:29: '14' é um número mágico.
$/Dispenser.java:29:33: '15' é um número mágico.
$/Dispenser.java:29:37: '16' é um número mágico.
$/Dispenser.java:29:41: '17' é um número mágico.
$/Dispenser.java:29:45: '19' é um número mágico.
$/Dispenser.java:31:5: O método 'dispense' não foi concebido para extensão - precisa de ser abstracto, final ou vazio.
$/Dispenser.java:51:5: O número de "return"s é 3 (máximo permitido é 2).
$/Dispenser.java:62:5: O método 'setValidSelection' não foi concebido para extensão - precisa de ser abstracto, final ou vazio.
$/TestDriver.java:1: Linha contém mais do que 80 caracteres.
$/TestDriver.java:22: A forma de importação '.*' deve ser evitada - java.io.*.
$/TestDriver.java:25:1: Class should define a constructor.
$/TestDriver.java:25:1: Utility classes should not have a public or default constructor.
$/TestDriver.java:34:24: Variável 'machine' deve ser declarada final.
$/TestDriver.java:44:29: Variável 'tcTokens' deve ser declarada final.
$/TestDriver.java:49:34: String literal expressions should be on the left side of an equals comparison.
$/TestDriver.java:51:39: String literal expressions should be on the left side of an equals comparison.
$/TestDriver.java:53:39: String literal expressions should be on the left side of an equals comparison.
$/TestDriver.java:54:25: Variável 'selection' deve ser declarada final.
$/VendingMachine.java:1: Linha contém mais do que 80 caracteres.
$/VendingMachine.java:36:5: O método 'insertCoin' não foi concebido para extensão - precisa de ser abstracto, final ou vazio.
$/VendingMachine.java:38:28: The String "Current value = " appears 2 times in the file.
$/VendingMachine.java:41:5: O método 'returnCoin' não foi concebido para extensão - precisa de ser abstracto, final ou vazio.
$/VendingMachine.java:50:5: O método 'vendItem' não foi concebido para extensão - precisa de ser abstracto, final ou vazio.

$/TestDriver.java:1: Found duplicate of 21 lines in $/Dispenser.java, starting from line 1
$/VendingMachine.java:1: Found duplicate of 21 lines in $/Dispenser.java, starting from line 1
$/VendingMachine.java:1: Found duplicate of 21 lines in $/TestDriver.java, starting from 

```

É importante observar que alguns módulos são muito restritos e inclusive avaliam os comentarios como:

  * MagicNumber
  * DesignForExtension
  * StrictDuplicateCode
  * MultipleStringLiterals