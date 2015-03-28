

---


# <h3><u>Métricas que constam no <i>JaBUTi</i> e no <i>Metrics</i></u></h3> #

| **JaBUTI** | **Metrics** |
|:-----------|:------------|
|Number of Children (NOC)|Number of Children (NSC)|
|~~Number os Interfaces Implemented (NII)~~|~~Number of Interfaces (NOI)~~|
|~~Depth of Inheritance Tree (DIT)~~|~~Depth of Inheritance Tree (DIT)~~|
|Number of Methods Overriden by a Subclass (NMOS)|Number of Overriden Methods (NORM)|
|Specialization Index (SI)|Specialization Index (SIX)|
|Cyclomatic Complexity Metric (CC) - CC\_AVR, CC\_MAX|McCabe Cyclomatic Complexity (VG)|
|Weighted Methods per Class (WMC\_CC)|Weighted Methods per Class (WMC)|
|Average Number of Parameters per Method (ANPM)|Number of Parameters (PAR)|
|Maximum Number of Parameters per Method (MNPM)|Number of Parameters (PAR)|
|Number of Class Methods in a class (NCM)|Number of Static Methods (NSM)|
|  |  |
|Lack of Cohesion of Methods (LCOM)|Lack of Cohesion of Methods (LCOM)|

<u>Observação:</u>**apesar da métrica _Lack of Cohesion of Methods_ estar implementada em ambos, a definição que cada um utiliza é diferente.**

<u>Observação 2:</u>**as métricas WMC\_1 da JaBUTi, e NOM (Number of Methods) do Metrics são semelhantes, mas não iguais. A métrica da JaBUTi contabiliza, segundo a definição, todos os métodos da classe. Já a do Metrics, conta apenas os métodos que não são do tipo "static".**

<u>Observação 3:</u>**as métricas**NII/NOI**e**DIT/DIT**apresentam definições ligeiramente diferentes. A métrica**NII**da JaBUTi conta as interfaces "implementadas" (interfaces chamadas por "implements" na declaração da classe), enquanto**NOI**do Metrics conta as interfaces efetivamente programadas e que constam no código do programa. Já na métrica**DIT**, o Metrics considera o caminho pela hierarquia até a classe Object, enquanto a JaBUTi considera o caminho até a primeira classe que não pertence à estrutura do programa, já que a representação utilizada pelo programa não inclui todas as classes até a raiz da árvore de hierarquia (classe Object).**

# <h3><u>Métricas que constam no <i>JaBUTi</i> e não no <i>Metrics</i></u></h3> #

  * Average Method Size (AMZ\_LOCM);
  * Average Method Size (AMZ\_SIZE);
  * Coupling Between Object (CBO);
  * Number of public Class Methods in a class (NCM\_2);
  * Number of Class Variables in a class (NCV);
  * Number of Instance Variables in a class (NIV);
  * Number of Methods Added by a Subclass (NMAS);
  * Number of Methods Inherited by a Subclass (NMIS);
  * Number of Public Instance Methods in a class (NPIM);
  * Response for a Class (RFC);
  * Weighted Methods per Class (WMC):
    * Weighted Methods per Class (WMC): WMC\_1 - metric 1,
    * Weighted Methods per Class (WMC): WMC\_LOCM - metric LOCM,
    * Weighted Methods per Class (WMC): WMC\_SIZE - metric SIZE (number of instructions).
  * Number of Interfaces Implemented (NII);
  * Depth of Inheritance Tree (DIT) - caminho da classe até a primeira classe que não pertence à estrutura do programa (a representação utilizada pela JaBUTi não inclui todas as classes até a raiz da hierarquia, que seria a classe Object).


# <h3><u>Métricas que constam no <i>Metrics</i> e não no <i>JaBUTi</i></u></h3> #

  * Number of Packages: total number of packages
  * Number of Classes: total number of classes in the selected scope
  * Number of Methods (NOM): total number of methods defined in the selected scope
  * Number of Interfaces (NOI): total number of interfaces in the selected scope.
  * Depth of Inheritance Tree (DIT): distance from class Object in the inheritance hierarchy.

  * Lines of Code: since version 1.3.6 Lines of code has been changed and separated into:
    * TLOC: Total lines of code that will counts non-blank and non-comment lines in a compilation unit. usefull for thoses interested in computed KLOC.
    * MLOC: Method lines of code will counts and sum non-blank and non-comment lines inside method bodies.

  * Nested Block Depth (NBD): The depth of nested blocks of code.

  * Afferent Coupling (Ca)<sup>1</sup>: the number of classes outside a package that depend on classes inside the package.
  * Efferent Coupling (Ce)<sup>1</sup>: the number of classes inside a package that depend on classes outside the package.
  * Instability (I): Ce / (Ca + Ce)
  * Abstractness (A): the number of abstract classes (and interfaces) divided by the total number of types in a package
  * Normalized Distance from Main Sequence (Dn): | A + I - 1 |, this number should be small, close to zero for good packaging design


---

1. Semelhantes à métrica _CBO - Coupling Between Object_, implementada no JaBUTi.


---


As listas com as descrições das métricas implementadas, respectivamente, no JaBUTi e no Metrics encontram-se em:

  * http://code.google.com/p/jabutimetrics/wiki/Jabuti_Metricas
  * http://code.google.com/p/jabutimetrics/wiki/Metrics_Metricas