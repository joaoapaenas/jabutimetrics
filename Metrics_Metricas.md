<h2><u>Lista das métricas implementadas no "Metrics 1.3.6":</u></h2>



---




# <h3> 01. <i>Number of Classes (NOC)</i></h3> #
Total number of classes in the selected scope.

# <h3> 02. <i>Number of Children (NSC)</i> </h3> #
Total number of **direct** subclasses of a class. A class implementing an interface counts as a direct child of that interface.

# <h3> 03. <i>Number of Interfaces (NOI)</i> </h3> #
Total number of interfaces in the selected scope.

# <h3> 04.  <i>Depth of Inheritance Tree (DIT)</i> </h3> #
Distance from class Object in the inheritance hierarchy.

# <h3> 05. <i>Number of Overridden Methods (NORM)</i> </h3> #
Total number of methods in the selected scope that are overridden from an ancestor class The calculation of NORM can be customized from its preference page,where you can control whether to count abstract methods, methods that call the inherited implementation (through use of super.[same-method] call). Certain methods that are supposed to be overridden can be excluded explicitly (like toString, equals and hashCode).

# <h3> 06. <i>Number of Methods (NOM)</i> </h3> #
Total number of methods defined in the selected scope.

# <h3> 07. <i>Lines of Code (LOC)</i> </h3> #
since version 1.3.6 Lines of code has been changed and separated into:
  * **TLOC:** Total lines of code that will counts non-blank and non-comment lines in a compilation unit. usefull for thoses interested in computed KLOC.
  * **MLOC:** Method lines of code will counts and sum non-blank and non-comment lines inside method bodies.

# <h3> 08. <i>Specialization Index (SIX)</i> </h3> #
Average of the specialization index, defined as NORM **DIT / NOM. This is a class level metric**

# <h3> 09. <i>McCabe Cyclomatic Complexity</i> </h3> #
Counts the number of flows through a piece of code. Each time a branch occurs (if, for, while, do, case, catch and the ?: ternary operator, as well as the && and || conditional logic operators in expressions) this metric is incremented by one. Calculated for methods only. For a full treatment of this metric see [McCabe](http://www.mccabe.com/nist/nist_pub.php).

# <h3> 10. <i>Weighted Methods per Class (WMC)</i> </h3> #
Sum of the McCabe Cyclomatic Complexity for all methods in a class.

# <h3> 11. <i>Lack of Cohesion of Methods (LCOM)</i> </h3> #
A measure for the Cohesiveness of a class. Calculated with the Henderson-Sellers method (LCOM, see page 147). If (m(A) is the number of methods accessing an attribute A, calculate the average of m(A) for all attributes, subtract the number of methods m and divide the result by (1-m). A low value indicates a cohesive class and a value close to 1 indicates a lack of cohesion and suggests the class might better be split into a number of (sub)classes.

I'm unsure of the usefullness of this metric in Java since it penalizes the proper use of getters and setters as the only methods that directly access an attribute and the other methods using the gettter/setter methods. Perhaps I could alter the implementation to take this into account, assuming standard JavaBean naming conventions.

The LCOM metric has its own preference page, where you can control whether static fields and static methods should be considered in the calculation of LCOM.

# <h3> 12. <i>Afferent Coupling (CA)</i> </h3> #
The number of classes outside a package that depend on classes inside the package.

# <h3> 13. <i>Efferent Coupling (CE)</i> </h3> #
The number of classes inside a package that depend on classes outside the package.

# <h3> 14. <i>Instability (RMI)</i> </h3> #
Ce / (Ca + Ce)

# <h3> 15. <i>Abstractness (RMA)</i> </h3> #
The number of abstract classes (and interfaces) divided by the total number of types in a package

# <h3> 16. <i>Normalized Distance from Main Sequence (RMD)</i> </h3> #
| A + I - 1 |, this number should be small, close to zero for good packaging design.

# <h3> 17. <i>Number of Static Methods (NSM)</i> </h3> #
Total number of static methods in the selected scope.

# <h3> 18. <i>Number of Attributes (NOF)</i> </h3> #
Total number of attributes in the selected scope.

# <h3> 19. <i>Number of Packages (NOP)</i> </h3> #
Total number of packages in the selected scope.

# <h3> 20. <i>Number of Static Attributes (NSF)</i> </h3> #
Total number of static attributes in the selected scope.

# <h3> 21. <i>Nested Block Depth (NBD)</i> </h3> #
The depth of nested blocks of code.

# <h3> 22. <i>Number of Parameters (PAR)</i> </h3> #
Total number of parameters in the selected scope.


---


<h2><u>Referências</u></h2>

  * http://metrics.sourceforge.net/
  * http://open.ncsu.edu/se/tutorials/metrics/index.html#section4_0

**Observação:**

As métricas implementadas no plug-in "Metrics 1.3.6" têm como referência os livros:
  * "Object-Oriented Metrics, measures of Complexity", de Brian Henderson-Sellers, Prentice Hall, 1996.
  * "OO Design Quality Metrics, An Analysis of Dependencies" de Robert Martin.
  * "Agile Software Development, Principles, Patterns and Practices" de Robert Martin.