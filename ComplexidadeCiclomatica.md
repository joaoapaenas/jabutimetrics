# Introdução #

Complexidade ciclomática (também chamada de complexidade condicional) é uma métrica para determinar o quão complexo é um programa (ou um trecho dele).

## Definição de Complexidade Ciclomática ##
Reflete diretamente o número de caminhos independentes que um programa pode tomar durante a sua execução. Esta métrica está relacionada a disciplina de testes, pois para cada um dos caminhos (em tese) deveríamos criar um caso de teste que exercite-o.

## Cálculo da Complexidade Ciclomática ##
De forma geral, a fórmula é a seguinte:
<pre>CC = A - N + C + R</pre>
  * CC: Complexidade Ciclomática
  * A: número de arestas
  * N: número de nós
  * C: número de componentes conectados
  * R: número de saídas


Para algoritmos com um componente, um ponto de entrada e um ponto de saída,
o cálculo se dá da seguinte forma:

<pre> CC = A - N + 2</pre>
  * CC: Complexidade Ciclomática
  * A: número de arestas
  * N: número de nós




Também pode ser calculado como:
<pre> CC = P + 1 </pre>
  * CC: Complexidade Ciclomática
  * P: número de predicativos

## Cálculo na Jabuti ##
Existe uma diferença entre os valores apresentados na Jabuti e o que
por definiçao deveria apresentar.

Por exemplo, um if simples gera dois caminhos possíveis e, com isso,
tem complexidade 2.

Um if com um else também gera dois caminhos possíveis. No entanto,
o jabuti está apontando complexidade igual a 3.

Veja abaixo a lista de divergências:

|Situação|Complexidade Ciclomática (definição)|Complexidade Ciclomática (Jabuti)|
|:---------|:--------------------------------------|:---------------------------------|
|If Else | 2|3 |
|if (Or) | 3|4 |
|if (And) | 3|4 |
|if (Xor) | 2|3 |