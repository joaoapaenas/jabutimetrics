Links para as planilhas utilizadas nesta página:
  * http://spreadsheets.google.com/pub?key=pKWnJNvmkYrP_tMkmyicDbA
  * http://spreadsheets.google.com/pub?key=pKWnJNvmkYrObbEFl-urZSA


---





---


# <h3>Exemplo do Manual da JaBUTi - Máquina de vendas</h3> #

![http://jabutimetrics.googlecode.com/files/resultados1-vending-machine.png](http://jabutimetrics.googlecode.com/files/resultados1-vending-machine.png)

Na tabela acima (disponível também no link: http://spreadsheets.google.com/pub?key=pKWnJNvmkYrP_tMkmyicDbA), é mostrado o resultado obtido em ambas as ferramentas, sendo que o que está grifado em vermelho é um valor divergente.

Como pode-se ver, as métricas que deram valores diferentes foram: ANPM (Número Médio de Parâmetros), CC\_AVG (Número Médio da Complexidade Ciclomática) e WMC\_CC (_Weighted Methods per Class_).

Para analisar os resultados, considerando o **código-fonte**, é preciso considerar a tabela abaixo:
|Classe|Número de Métodos|Número Total de Parâmetros| Soma da CC dos Métodos da Classe|
|:-----|:------------------|:---------------------------|:---------------------------------|
|Dispenser.java|3 |4 |11|
|TestDriver.java|1 |1 |7 |
|VendingMachine.java|4 |1 |5 |

**ANPM:** efetuando a divisão entre o número total de parâmetros e o número de métodos de cada classe, verifica-se que o "Metrics" calculou os valores corretamente.

**CC\_AVG:** efetuando a divisão entre a soma da complexidade ciclomática dos métodos da classe e o número de métodos de cada classe, verifica-se que o "Metrics" calculou os valores corretamente.

**WMC\_CC:** pela definição, o WMC\_CC é a soma da complexidade ciclomática dos métodos de cada classe. Assim, como pode ser verificado, o "Metrics" retornou o valor correto.

<h4><u><i>Observação (baseada na resposta por e-mail de Marcio Delamaro):</i></u></h4>

Os valores retornados pela JaBUTi foram divergentes porque ela considera, justamente, o _bytecode_ do programa. Com isso, ela pode considerar métodos que não estão explícitos no código-fonte (por exemplo, ela considera o método construtor por default, e o "Metrics" apenas quando ele está implementado explicitamente no código-fonte). Como as classes Dispenser e TestDriver não possuem construtor no código-fonte, se adicionarmos 1 ao número de métodos e refazermos as contas, ANPM e CC\_AVG estão de acordo com o que seria esperado da análise do _bytecode_ do programa.



---


# <h3>Exemplo do Programa de Testes </h3> #

Executando o programa de testes (OConGraX) na JaBUTi, e comparando com os resultados obtidos no Metrics, foi obtida uma planilha, disponível no link abaixo:

http://spreadsheets.google.com/pub?key=pKWnJNvmkYrObbEFl-urZSA

Observando a planilha, é possível ver que as métricas que deram valores divergentes são: ANPM, CC\_AVG, CC\_MAX, DIT, MNPM, NCM, NII e WMC\_CC. Para realizar uma análise mais justa, as métricas ANPM, CC\_AVG, CC\_MAX e WMC\_CC não serão consideradas no momento, pois elas dependem de uma análise mais detalhada do bytecode do código e do grafo gerado pela JaBUTi.

Com relação às métricas MNPM e NCM, vendo apenas o código-fonte temos que o valor retornado pelo Metrics está correto.

Já as métricas NII e DIT deram valores divergentes, possivelmente porque a definição considerada pelo Metrics é ligeiramente diferente da definição considerada pelo JaBUTi.

  * A métrica NII (número de interfaces implementadas) da JaBUTi, conta as interfaces "implementadas" (interfaces chamadas por "implements" na declaração da classe), enquanto a métrica do Metrics conta as interfaces efetivamente programadas e que constam no código do programa. Assim, o valor retornado por ambas as ferramentas está correto.

  * A métrica DIT (_depth of inheritance tree_) apresenta definições iguais, entretanto o Metrics considera o caminho pela hierarquia até a classe Object, enquanto a JaBUTi considera o caminho até a primeira classe que não pertence à estrutura do programa, já que a representação utilizada pelo programa não inclui todas as classes até a raiz da árvore de hierarquia (classe Object). Desta forma, o valor retornado por ambas, apesar de divergentes, estão de acordo com a definição utilizada por cada uma das ferramentas.


---


# <h3> Sobre o tempo de execução </h3> #

O tempo de execução da JaBUTi, para o exemplo da **máquina de vendas** foi muito bom, com o resultado das métricas saindo em cerca de um minuto. Já para o exemplo do **programa de testes**, ele demorou cerca de 3 minutos para carregar as classes e mais uns 5 minutos para computar as métricas.

Os exemplos foram rodados na JaBUTi num computador muito bom. Não tenho todas as configurações dele no momento, mas trata-se de um AMD Quad-Core com 8GB de RAM.