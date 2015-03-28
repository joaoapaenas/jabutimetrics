<h2><u>Lista das métricas implementadas no "JaBUTi 1.0":</u></h2>



---


# <h3> 01. <i>Average Number of Parameters per Method (ANPM)</i></h3> #
Métrica calculada através da divisão entre o somatório do número de parâmetros de cada método da classe pelo número total de métodos da classe.

# <h3> 02. <i>Average Method Size (AMZ_LOCM)</i> </h3> #
Métrica calculada através da divisão entre a soma do número de linhas de código dos métodos da classe pelo número de métodos na classe (soma dos métodos instância e classe).

# <h3> 03. <i>Average Method Size (AMZ_SIZE)</i> </h3> #
Média do número de instruções do _bytecode_.

# <h3> 04.  <i>Coupling Between Object (CBO)</i> </h3> #
Há acoplamento entre duas classes quando uma classe usa métodos e/ou variáveis de instância de outra classe. A métrica é calculada através da contagem do número de classes às quais uma classe está acoplada de alguma forma, o que exclui o acoplamento baseado em herança. Assim, o valor CBO de uma classe A é o número de classes das quais a classe A utiliza algum método e/ou variável de instância.

# <h3> 05. <i>Cyclomatic Complexity Metric (CC)</i> </h3> #
Métrica que calcula a complexidade do método, através dos grafos de fluxo de controle que descreve a estrutura lógica do método.

Os grafos de fluxo consistem de nós e ramos, onde os nós representam comandos ou expressões e os ramos representam a transferência de controle entre estes nós.

A métrica pode ser calculada das seguintes formas:

  * O número de regiões do grafo de fluxo corresponde à Complexidade Ciclomática;

  * A Complexidade Ciclomática, V(G), para o grafo de fluxo G é definida como:

> |V(G) = E - N + 2|
|:---------------|

> onde, V(G) mede os caminhos linearmente independentes encontrados no grafo, E é o número de ramos do grafo de fluxo e N o número de nós.

  * A Complexidade Ciclomática, V(G), para o grafo de fluxo G é definida como:

> |V(G) = P(G)+1|
|:------------|

> onde, P(G) é o número de nós predicativos contidos no grafo de fluxo G. Os nós predicativos são comandos condicionais (if, while, ...) com um ou mais operadores booleanos (or, and, nand, nor ). Um nó é criado para cada nó 'a' ou 'b' de um comando IF a OR b.

Outras formas de se calcular a Complexidade Ciclomática são:
  * V(G) = número de regiões de G;
  * V(G) = número de ramos - número de nós + 2;
  * V(G) = número de nós predicativos + 1.

<u>Variações:</u>**a métrica é aplicada a métodos mas pode ser aplica à classe através da soma (ver WMC\_CC), da média (que ser´a chamada CC\_AVG) e do máximo (CC MAX) entre os métodos.**

# <h3> 06. <i>Depth of Inheritance Tree (DIT)</i> </h3> #
É o maior caminho da classe à raiz na árvore de hierarquia de herança. Interfaces também são consideradas, ou seja, o caminho através de uma hierarquia de interfaces também pode ser o que dá a profundidade de uma classe.

<u>Variação:</u>**como a representação de programa utilizada não inclui todas as classes até a raiz da árvore de hierarquia, será utilizado o caminho da classe até a primeira classe que não pertence à estrutura do programa.**

# <h3> 07. <i>Lack of Cohesion in Methods (LCOM)</i> </h3> #
Métrica calculada através da contagem do número de pares de métodos na classe que não compartilham variáveis de instância menos o número de pares de métodos que compartilham variáveis de instância. Quando o resultado é negativo, a métrica recebe o valor zero. Os métodos estáticos não são considerados na contagem, uma vez que só as variáveis de instância são tomadas.

<u>Variações:</u>_* Considerar só a coesão entre métodos estáticos; esta métrica será chamada LCOM\_2;
  * Considerar a coesão de métodos estáticos ou de instância; esta métrica, chamada LCOM\_3 pode ser calculada como LCOM**+ LCOM\_2;**_<h5><i>Obs.: a variação LCOM_3 aparece no manual como sendo LCOM<i>- LCOM_2; entretanto, no código, a definição é LCOM</i> + LCOM_2. Por isso, colocamos neste Wiki a definição que está implementada no código da JaBUTi.</i></h5>

# <h3> 08. <i>Maximum Number of Parameters per Method (MNPM)</i> </h3> #
Número máximo de parâmetros em um método da classe.

# <h3> 09. <i>Number of Class Methods in a class (NCM)</i> </h3> #
Métrica calculada através da contagem do número de métodos _static_ na classe.

# <h3> 10. <i>Number of Class Variables in a class (NCV)</i> </h3> #
Métrica calculada através da contagem do número de variáveis _static_ na classe.

# <h3> 11. <i>Number of Interfaces Implemented (NII)</i> </h3> #
Número de interfaces implementadas pela classe. Esta métrica é uma variação da UMI (_Use of multiple inheritance_), já que a herança múltipla não se aplica à linguagem Java.

# <h3> 12. <i>Number of Instance Variables in a class (NIV)</i> </h3> #
Métrica calculada através da contagem do número de variáveis de instância na classe, o que inclui as variáveis _public_, _private_ e _protected_ disponíveis para as instâncias.

# <h3> 13. <i>Number of Methods Added by a Subclass (NMAS)</i> </h3> #
Métrica calculada através da contagem do número de novos métodos adicionados pelas subclasses.

# <h3> 14. <i>Number of Methods Inherited by a Subclass (NMIS)</i> </h3> #
Métrica calculada através da contagem do número de métodos herdados pela subclasse de suas superclasses.

# <h3> 15. <i>Number of Methods Overridden by a Subclass (NMOS)</i> </h3> #
Métrica calculada através da contagem do número de métodos definidos na subclasse com o mesmo nome de métodos de sua superclasse.

# <h3> 16. <i>Number of Children (NOC)</i> </h3> #
Métrica calculada através da contagem do número de subclasses imediatas subordinadas à classe na árvore de hierarquia.

# <h3> 17. <i>Number of Public Instance Methods in a class (NPIM)</i> </h3> #
Métrica calculada através da contagem do número de métodos de instância públicas na classe.

# <h3> 18. <i>Response for a Class (RFC)</i> </h3> #
Métrica calculada através da soma do número de métodos da classe mais os métodos que são invocados diretamente por eles. É o número de métodos que podem ser potencialmente executados em resposta a uma mensagem recebida por um objeto de uma classe ou por algum método da classe. Quando um método polimórfico é chamado para diferentes classes, cada diferente chamada é contada uma vez.

# <h3> 19. <i>Specialization Index (SI)</i> </h3> #
Métrica calculada através da divisão entre o resultado da multiplicação de NMOS e DIT pelo número total de métodos.

# <h3> 20. <i>Weighted Methods per Class (WMC)</i> </h3> #
Métrica calculada através da soma da complexidade de cada método. Não se define qual tipo de complexidade pode ser utilizada, assim serão aplicadas as seguintes variações:

  * Utiliza-se o valor 1 como complexidade de cada método; assim WMC\_1 é o numero de métodos na classe;

  * Utiliza-se a métrica CC para a complexidade de cada método; esta métrica será chamada WMC\_CC;

  * Utiliza-se a métrica LOCM para a complexidade de cada método; esta métrica será chamada WMC\_LOCM;

  * Utiliza-se o tamanho do método (número de instruções) para a complexidade de cada método; esta métrica será chamada WMC\_SIZE.


---


# <h2> Referência </h2> #

  * Manual do "JaBUTi 1.0"