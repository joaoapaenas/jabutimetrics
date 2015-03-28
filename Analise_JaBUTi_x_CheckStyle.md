# <h3><u>Métricas similares que constam no <i>JaBUTi</i> e no <i>CheckStyle</i></u></h3> #

| **JaBUTI** | **CheckStyle** |
|:-----------|:---------------|
|Average Number of Parameters per Method (ANPM)|ParameterNumber (Size Violations) |
|Average Method Size (AMZ\_SIZE) |MethodLength (Size Violations) |
|Cyclomatic Complexity Metric (CC) |CyclomaticComplexity (Metrics) |
|Maximum Number of Parameters per Method (MNPM) |ParameterNumber (Size Violations) |


# <h3>Exemplo do Manual da JaBUTi - Máquina de vendas</h3> #

![http://jabutimetrics.googlecode.com/files/jabutixcheckstyle.png](http://jabutimetrics.googlecode.com/files/jabutixcheckstyle.png)

Na tabela acima (disponível também no link: http://spreadsheets.google.com/pub?key=p_W239cOkFGztGgjrzpENLQ), apresenta o resultado obtido em ambas ferramentas, o que está grifado em vermelho é um valor divergente.

# <h3>Execução de CheckStyle</h3> #

```
user@pedrita:~/checkstyle$ java -jar checkstyle-all-5.0-beta2.jar -c jabuti_checks2.xml ../Desktop/example/*.java
```

```
$/Dispenser.java:31:5: Cyclomatic Complexity is 6 (max allowed is 0).
$/Dispenser.java:31:5: Método tem 19 linhas (máx. permitido são 0).
$/Dispenser.java:31:16: Mais do que 0 parâmetros.
$/Dispenser.java:51:5: Cyclomatic Complexity is 4 (max allowed is 0).
$/Dispenser.java:51:5: Método tem 10 linhas (máx. permitido são 0).
$/Dispenser.java:51:21: Mais do que 0 parâmetros.
$/Dispenser.java:62:5: Cyclomatic Complexity is 1 (max allowed is 0).
$/Dispenser.java:62:5: Método tem 3 linhas (máx. permitido são 0).
$/Dispenser.java:62:17: Mais do que 0 parâmetros.
$/TestDriver.java:27:5: Cyclomatic Complexity is 7 (max allowed is 0).
$/TestDriver.java:27:5: Método tem 34 linhas (máx. permitido são 0).
$/TestDriver.java:27:24: Mais do que 0 parâmetros.
$/VendingMachine.java:30:5: Cyclomatic Complexity is 1 (max allowed is 0).
$/VendingMachine.java:30:5: Método tem 5 linhas (máx. permitido são 0).
$/VendingMachine.java:36:5: Cyclomatic Complexity is 1 (max allowed is 0).
$/VendingMachine.java:36:5: Método tem 4 linhas (máx. permitido são 0).
$/VendingMachine.java:41:5: Cyclomatic Complexity is 2 (max allowed is 0).
$/VendingMachine.java:41:5: Método tem 8 linhas (máx. permitido são 0).
$/VendingMachine.java:50:5: Cyclomatic Complexity is 1 (max allowed is 0).
$/VendingMachine.java:50:5: Método tem 8 linhas (máx. permitido são 0).
$/VendingMachine.java:50:17: Mais do que 0 parâmetros.
```

<u>Observação:</u>**Como o CheckStyle somente apresenta uma lista de erros, nós alteramos os valores limites para 0, afim de listar resultados que posam ser comparar com JaBUTi.**

# <h3>Resultado da execução do CheckStyle no Código da JaBUTi</h3> #

```
user@pedrita:~/checkstyle$ java -jar checkstyle-all-5.0-beta2.jar -c jabuti_checks2.xml ../workspace/JabutiMetrics/src/br/jabuti/*/*.java
```
Tempo:
  * real	0m7.739s
  * user	0m7.120s
  * sys	0m0.284s



  * resultado no arquivo http://jabutimetrics.googlecode.com/files/jabuti01.txt

```
user@pedrita:~/checkstyle$ java -jar checkstyle-all-5.0-beta2.jar -c jabuti_checks2.xml ../workspace/JabutiMetrics/src/br/jabuti/mobility/*/*.java
```
Tempo:
  * real	0m1.353s
  * user	0m1.064s
  * sys	0m0.072s

  * resultado no arquivo http://jabutimetrics.googlecode.com/files/jabuti02.txt