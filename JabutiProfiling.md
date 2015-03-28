# Execução de Ferramentas de Profile na Jabuti #

## [Eclipse TPTP - Test & Performance Tools Platform](http://eclipse.org/tptp) ##

Para este teste realizamos a carga do Jabuti e executamos com o Exemplo presente no tutorial da ferramenta.
Para a avaliação foram criados os seguintes filtros:

![http://jabutimetrics.googlecode.com/files/filters.png](http://jabutimetrics.googlecode.com/files/filters.png)

Estes filtros descartam as classes comuns do Java da análise de desempenho. Descartamos também as classes pertencentes ao pacote de interface gráfica o br.jabuti.gui.

O resultado da avaliação se encontra na figura abaixo e pode também ser acessada a partir do link: [Planilha com dados de Execução do TPTP no Jabuti](http://spreadsheets.google.com/ccc?key=p4W3XPP4LMg5XycyulM1AQA)

![http://jabutimetrics.googlecode.com/files/screen.png](http://jabutimetrics.googlecode.com/files/screen.png)

Esta análise nos permite concluir que boa parte do tempo está sendo gasto com classes no pacote criteria (faixa vermelha) e também com o pacote graph (faixa marrom).  Ambos possuem um número elevado de chamadas, por isso consumiram boa parte do tempo.

Poucas chamadas foram realizadas aos componentes presentes no pacote responsável pela invocação das métricas. Sabemos que o pacote de métrica faz uso, pelo menos, do pacote graph. Cabe um estudo se este pacote de métricas faz uso das operações definidas no pacote criteria.

O gráfico abaixo mostra em porcentagem o tempo consumido por pacote:

![http://jabutimetrics.googlecode.com/files/screen2.png](http://jabutimetrics.googlecode.com/files/screen2.png)


A ferramenta torna possível também analisar a hierarquia de chamadas a métodos e a porcentagem cumulativa do tempo gasto em cada uma delas. O resultado desta análise se encontra na figura abaixo

![http://jabutimetrics.googlecode.com/files/screen3.png](http://jabutimetrics.googlecode.com/files/screen3.png)

O método rebuild foi o que consumiu a maior parte do tempo, (12%). Na figura é possível ver a porcentagem por chamadas feitas dentro do método rebuild(). A próxima figura apresenta os métodos que consumiram maior porcentagem do tempo.

![http://jabutimetrics.googlecode.com/files/screen4.png](http://jabutimetrics.googlecode.com/files/screen4.png)


A próxima figura apresenta a análise de metodos que implementam as métricas por tempo consumido.


![http://jabutimetrics.googlecode.com/files/screen5.png](http://jabutimetrics.googlecode.com/files/screen5.png)

As métricas que consumiram maior quantidade de tempo foram as que chamaram o método CC, que calcula a complexidade ciclomática e **faz uso do grafo gerado durante o Rebuild**. Neste caso, as métricas, cujos métodos correspondem a: _wmc\_cc_ (peso do método baseado na complexidade ciclomática)  e _cc\_avg_ (complexidade ciclomática média)


## Java Profiler ##

### Código para Teste ###
Esta Ferramenta vem com o jsdk. Para o teste, pesquisamos na classe responsável pela interface o que é chamado na hora de instanciação de um JabutiProject. Simulamos a interação do usuário com a interface, ou
seja, criamos uma classe que faz uso dos mesmo métodos que a interface operada pelo usuário. Abaixo se encontra o trecho da classe utilizada para testes (vale a pena notar que ainda não foram sequer executadas as métricas no código carregado.

---

```
//Codigo utilizado para instanciar projeto. Deve-se passar a classe principal a ser carregada

           JabutiProject project = new JabutiProject("br.jabuti.gui.JabutiGUI", System.getProperty("java.class.path"));

//Codigo para Carregar dependências 
 project.addInstr("br.jabuti.probe.DefaultProbeInsert");

            project.addInstr("br.jabuti.gui.JabutiGUI$19");

            project.addInstr("br.jabuti.criteria.Requirement");

            project.addInstr("br.jabuti.gui.JabutiGUI$52");

            project.addInstr("br.jabuti.junitexec.JUnitJabutiCore");

            project.addInstr("br.jabuti.gui.BytecodePanel$MyScrollbarListener");

            project.addInstr("br.jabuti.util.XMLPrettyPrinter");

            project.addInstr("br.jabuti.gui.JabutiGUI$29");

            project.addInstr("br.jabuti.gui.JabutiGUI$17");

            project.addInstr("br.jabuti.gvf.DotParser$LookaheadSuccess");

            project.addInstr("br.jabuti.gui.CustomReportsDialog$1");

            project.addInstr("br.jabuti.gui.JabutiGUI$54");

            project.addInstr("br.jabuti.project.TestCase");

            project.addInstr("br.jabuti.gui.TableMap");

            project.addInstr("br.jabuti.junitexec.JarFilter");

            project.addInstr("br.jabuti.gui.JabutiGUI$61");

            project.addInstr("br.jabuti.instrumenter.ParseException");

            project.addInstr("br.jabuti.criteria.AbstractCriterion");

            project.addInstr("br.jabuti.gvf.CFGFrame$1");

            project.addInstr("br.jabuti.criteria.AllUses");

            project.addInstr("br.jabuti.verifier.InstructionGraph");

            project.addInstr("br.jabuti.gvf.CFGFrame");

            project.addInstr("br.jabuti.verifier.InvalidStackArgument");

            project.addInstr("br.jabuti.gui.JabutiGUI$16");

            project.addInstr("br.jabuti.gui.JabutiGUI$60");

            project.addInstr("br.jabuti.junitexec.Main");

            project.addInstr("br.jabuti.gui.JabutiGUI$55");

            project.addInstr("br.jabuti.gui.SourcePanel$3");

            project.addInstr("br.jabuti.graph.RRReqLocal");

            project.addInstr("br.jabuti.junitexec.CollectorListener");

            project.addInstr("br.jabuti.criteria.Criterion");

            project.addInstr("br.jabuti.gui.JTableButtonMouseListener");

            project.addInstr("br.jabuti.gui.SourcePanel$2");

            project.addInstr("br.jabuti.gui.JabutiGUI$18");

            project.addInstr("br.jabuti.gui.JabutiGUI$59");

            project.addInstr("br.jabuti.gui.CustomReportsDialog$2");

            project.addInstr("br.jabuti.probe.TraceReader");

            project.addInstr("br.jabuti.gui.JabutiGUI$53");

            project.addInstr("br.jabuti.gui.JabutiGUI");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$2");

            project.addInstr("br.jabuti.gvf.GVFDrawPanel$pAction");

            project.addInstr("br.jabuti.graph.CFG");

            project.addInstr("br.jabuti.graph.CFGNode");

            project.addInstr("br.jabuti.project.TestSet");

            project.addInstr("br.jabuti.project.ClassMethod");

            project.addInstr("br.jabuti.mobility.HostTraceReader");

            project.addInstr("br.jabuti.gvf.GVFSecLink");

            project.addInstr("br.jabuti.gvf.GVFLink");

            project.addInstr("br.jabuti.instrumenter.Instrumenter");

            project.addInstr("br.jabuti.gui.JabutiGUI$28");

            project.addInstr("br.jabuti.gui.JabutiGUI$34");

            project.addInstr("br.jabuti.criteria.AllEdges");

            project.addInstr("br.jabuti.gui.JabutiGUI$57");

            project.addInstr("br.jabuti.gui.JabutiGUI$56");

            project.addInstr("br.jabuti.project.ClasspathParser");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$1");

            project.addInstr("br.jabuti.gvf.GVFCallNode");

            project.addInstr("br.jabuti.instrumenter.ASMParseTokenManager");

            project.addInstr("br.jabuti.probe.NodeNameComparator");

            project.addInstr("br.jabuti.util.InstructCtrl");

            project.addInstr("br.jabuti.gui.JabutiGUI$31");

            project.addInstr("br.jabuti.gui.SourcePanel");

            project.addInstr("br.jabuti.gui.AboutDialog");

            project.addInstr("br.jabuti.gui.CodeSyntesePanel");

            project.addInstr("br.jabuti.instrumenter.FakeBranchInstruction");

            project.addInstr("br.jabuti.gui.ServerProperties");

            project.addInstr("br.jabuti.graph.DominatorTree");

            project.addInstr("br.jabuti.gvf.GVFDrawPanel$1$1");

            project.addInstr("br.jabuti.graph.DominatorTreeNode");

            project.addInstr("br.jabuti.gui.BytecodePanel$2");

            project.addInstr("br.jabuti.gui.BytecodePanel$3");

            project.addInstr("br.jabuti.gui.JabutiGUI$32");

            project.addInstr("br.jabuti.criteria.AllNodes");

            project.addInstr("br.jabuti.gui.JabutiGUI$27");

            project.addInstr("br.jabuti.gui.JabutiGUI$42");

            project.addInstr("br.jabuti.probe.ProberInstrum");

            project.addInstr("br.jabuti.project.Coverage");

            project.addInstr("br.jabuti.lookup.Program");

            project.addInstr("br.jabuti.gui.JabutiGUI$58");

            project.addInstr("br.jabuti.util.HTMLGen");

            project.addInstr("br.jabuti.gui.JabutiGUI$38");

            project.addInstr("br.jabuti.gui.TableSorterPanel");

            project.addInstr("br.jabuti.gvf.GVFExitNode");

            project.addInstr("br.jabuti.junitexec.JUnitUtil");

            project.addInstr("br.jabuti.criteria.Edge");

            project.addInstr("br.jabuti.gui.JabutiGUI$43");

            project.addInstr("br.jabuti.gvf.GVFDrawPanel$1");

            project.addInstr("br.jabuti.gui.SourcePanel$1");

            project.addInstr("br.jabuti.graph.ReduceNode");

            project.addInstr("br.jabuti.gui.JabutiGUI$1");

            project.addInstr("br.jabuti.gui.TotalPanel");

            project.addInstr("br.jabuti.gui.JabutiGUI$30");

            project.addInstr("br.jabuti.gui.JabutiGUI$39");

            project.addInstr("br.jabuti.gui.AvailableMemoryDialog$1");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$10");

            project.addInstr("br.jabuti.gvf.ParseException");

            project.addInstr("br.jabuti.gui.JabutiGUI$40");

            project.addInstr("br.jabuti.lookup.RClass");

            project.addInstr("br.jabuti.gui.JabutiGUI$2");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog");

            project.addInstr("br.jabuti.gui.MyHeaderRenderer");

            project.addInstr("br.jabuti.gui.JabutiGUI$36");

            project.addInstr("br.jabuti.project.ClassSourceFile");

            project.addInstr("br.jabuti.verifier.VMStack");

            project.addInstr("br.jabuti.gui.BytecodePanel$1");

            project.addInstr("br.jabuti.gui.TableSorterPanel$1");

            project.addInstr("br.jabuti.gui.JabutiGUI$35");

            project.addInstr("br.jabuti.instrumenter.ASMParse$JJCalls");

            project.addInstr("br.jabuti.gui.JabutiGUI$33");

            project.addInstr("br.jabuti.gvf.DotParser");

            project.addInstr("br.jabuti.gui.MyTable");

            project.addInstr("br.jabuti.gui.JabutiGUI$37");

            project.addInstr("br.jabuti.device.ProberServer");

            project.addInstr("br.jabuti.gvf.GVFDrawPanel");

            project.addInstr("br.jabuti.criteria.AllPotUses");

            project.addInstr("br.jabuti.lookup.RClassCode");

            project.addInstr("br.jabuti.gui.BytecodePanel");

            project.addInstr("br.jabuti.gui.JabutiGUI$4");

            project.addInstr("br.jabuti.gui.JabutiGUI$3");

            project.addInstr("br.jabuti.graph.Graph");

            project.addInstr("br.jabuti.gui.ServerProperties$3");

            project.addInstr("br.jabuti.instrumenter.ASMInstrumenter");

            project.addInstr("br.jabuti.gui.JabutiGUI$26");

            project.addInstr("br.jabuti.verifier.VMStackElement");

            project.addInstr("br.jabuti.gui.JTableButtonRenderer");

            project.addInstr("br.jabuti.gui.JabutiGUI$7");

            project.addInstr("br.jabuti.mobility.HostProberServer");

            project.addInstr("br.jabuti.gui.AvailableMemoryDialog");

            project.addInstr("br.jabuti.gui.JabutiGUI$47");

            project.addInstr("br.jabuti.gvf.GVFNode");

            project.addInstr("br.jabuti.gui.JabutiGUI$8");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$7");

            project.addInstr("br.jabuti.gui.ServerProperties$4");

            project.addInstr("br.jabuti.probe.DefaultTraceReader");

            project.addInstr("br.jabuti.gui.JabutiGUI$44");

            project.addInstr("br.jabuti.graph.CFGCallNode");

            project.addInstr("br.jabuti.gvf.DotParserConstants");

            project.addInstr("br.jabuti.gvf.Token");

            project.addInstr("br.jabuti.graph.GraphNode");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$8");

            project.addInstr("br.jabuti.gui.JabutiGUI$15");

            project.addInstr("br.jabuti.probe.DefaultProber");

            project.addInstr("br.jabuti.gui.JTableComponentModel$1");

            project.addInstr("br.jabuti.gui.MyJMenuItem");

            project.addInstr("br.jabuti.gui.JTableComponentModel");

            project.addInstr("br.jabuti.probe.DefaultProberHook");

            project.addInstr("br.jabuti.criteria.DefUse");

            project.addInstr("br.jabuti.junitexec.InstrumenterListener");

            project.addInstr("br.jabuti.util.ToolConstants");

            project.addInstr("br.jabuti.device.ProberServer$DeviceConnection");

            project.addInstr("br.jabuti.gui.JabutiGUI$41");

            project.addInstr("br.jabuti.project.JabutiProject");

            project.addInstr("br.jabuti.gvf.GVFLayout");

            project.addInstr("br.jabuti.probe.ProbedNode");

            project.addInstr("br.jabuti.gvf.GVFDisplayable");

            project.addInstr("br.jabuti.gvf.GraphViz");

            project.addInstr("br.jabuti.mobility.mobile.HostProbedNode");

            project.addInstr("br.jabuti.gui.JabutiGUI$9");

            project.addInstr("br.jabuti.util.Debug");

            project.addInstr("br.jabuti.gui.ServerProperties$6");

            project.addInstr("br.jabuti.gui.ServerProperties$5");

            project.addInstr("br.jabuti.gvf.DotParserTokenManager");

            project.addInstr("br.jabuti.gui.TableSorter$1");

            project.addInstr("br.jabuti.instrumenter.Token");

            project.addInstr("br.jabuti.graph.CFGSuperNode");

            project.addInstr("br.jabuti.gui.TitlePanel");

            project.addInstr("br.jabuti.gvf.DotParser$JJCalls");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$9");

            project.addInstr("br.jabuti.gui.CustomReportsDialog");

            project.addInstr("br.jabuti.verifier.InstructionNode");

            project.addInstr("br.jabuti.gui.ProbeCheck");

            project.addInstr("br.jabuti.gvf.MyPoint");

            project.addInstr("br.jabuti.gui.SourcePanel$MyScrollbarListener");

            project.addInstr("br.jabuti.gui.JabutiGUI$10");

            project.addInstr("br.jabuti.gui.SyntesePanel");

            project.addInstr("br.jabuti.gui.AboutDialog$1");

            project.addInstr("br.jabuti.gui.JabutiGUI$14");

            project.addInstr("br.jabuti.gui.JabutiGUI$20");

            project.addInstr("br.jabuti.verifier.VMLocal");

            project.addInstr("br.jabuti.gui.JabutiGUI$23");

            project.addInstr("br.jabuti.gui.JabutiGUI$49");

            project.addInstr("br.jabuti.gvf.TokenMgrError");

            project.addInstr("br.jabuti.gui.LookAndFeelRadioButton");

            project.addInstr("br.jabuti.gui.JabutiGUI$45");

            project.addInstr("br.jabuti.gui.JabutiGUI$11");

            project.addInstr("br.jabuti.gui.SelectedPoint");

            project.addInstr("br.jabuti.util.Persistency");

            project.addInstr("br.jabuti.graph.RRDominator");

            project.addInstr("br.jabuti.gvf.SimpleCharStream");

            project.addInstr("br.jabuti.project.Project2XML");

            project.addInstr("br.jabuti.instrumenter.ASMParse");

            project.addInstr("br.jabuti.instrumenter.SimpleCharStream");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$6");

            project.addInstr("br.jabuti.project.XML2Project");

            project.addInstr("br.jabuti.gui.ServerProperties$1");

            project.addInstr("br.jabuti.gui.TableSorter");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$4");

            project.addInstr("br.jabuti.gvf.CFGFrame$2");

            project.addInstr("br.jabuti.gui.ServerProperties$2");

            project.addInstr("br.jabuti.graph.RoundRobinExecutor");

            project.addInstr("br.jabuti.gvf.CFGFrame$3");

            project.addInstr("br.jabuti.gui.JabutiGUI$51");

            project.addInstr("br.jabuti.graph.ReduceGraph");

            project.addInstr("br.jabuti.graph.RRLiveDefs");

            project.addInstr("br.jabuti.graph.CFGExitNode");

            project.addInstr("br.jabuti.gui.JabutiGUI$6");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$5");

            project.addInstr("br.jabuti.verifier.InvalidInstructionException");

            project.addInstr("br.jabuti.lookup.ClassClosure");

            project.addInstr("br.jabuti.gui.JabutiGUI$13");

            project.addInstr("br.jabuti.instrumenter.ASMParseConstants");

            project.addInstr("br.jabuti.gui.JabutiGUI$25");

            project.addInstr("br.jabuti.instrumenter.TokenMgrError");

            project.addInstr("br.jabuti.gui.JabutiGUI$12");

            project.addInstr("br.jabuti.gui.JabutiGUI$50");

            project.addInstr("br.jabuti.gui.JabutiGUI$46");

            project.addInstr("br.jabuti.junitexec.DirFilter");

            project.addInstr("br.jabuti.project.ClassFile");

            project.addInstr("br.jabuti.criteria.Node");

            project.addInstr("br.jabuti.gui.ProjectManagerDialog$3");

            project.addInstr("br.jabuti.gui.JabutiGUI$LeftPanel");

            project.addInstr("br.jabuti.gui.JabutiGUI$22");

            project.addInstr("br.jabuti.gui.JabutiGUI$24");

            project.addInstr("br.jabuti.metrics.Metrics");

            project.addInstr("br.jabuti.gui.JabutiGUI$5");

            project.addInstr("br.jabuti.gui.WeightColor");

            project.addInstr("br.jabuti.gui.JabutiGUI$48");

            project.addInstr("br.jabuti.gui.JabutiGUI$21");

//Codigo para a Construcao do Projeto: 
           project.rebuild();
```

---


O programa demorou ~130 min. para carregar no meu notebook, consumindo 25% da memória. Meu pc é um Turion64X2 1.8GHz, 2Gb de Ram e executamos o programa dessa forma:

_$ java -Xprof -Xms1024m -Xmx1024m -cp bin/:lib/bcel-5.2.jar br.jabuti.gui.test.ExecutionTimeTesting_

Como ele consumiu 25% da memória, **teoricamente** deve funcionar com 512mb de heap.

Em seguida pode ser vista a saída do profiler do java, com porcentagens de tempo de execuções de estruturas de dados do próprio java (uso de Hash, etc.). Estes dados podem ser utilizados para otimizações futuras, como troca de estruturas de dados.

```
Flat profile of 7742.28 secs (2094 total ticks): main

  Interpreted + native   Method                        
  1.3%     0  +    24    java.io.FileInputStream.readBytes
  0.6%    11  +     1    br.jabuti.project.ClassMethod.<init>
  0.6%     0  +    11    java.util.zip.ZipFile.getEntry
  0.6%     0  +    11    java.io.FileOutputStream.writeBytes
  0.5%     0  +    10    java.lang.Runtime.gc
  0.5%     0  +    10    java.io.UnixFileSystem.getBooleanAttributes0
  0.3%     0  +     6    java.io.FileInputStream.open
  0.3%     0  +     6    java.util.zip.ZipFile.open
  0.3%     0  +     6    java.lang.System.arraycopy
  0.3%     4  +     1    org.apache.bcel.classfile.JavaClass.<init>
  0.2%     0  +     4    java.io.FileInputStream.available
  0.2%     0  +     4    java.lang.Throwable.fillInStackTrace
  0.2%     0  +     4    java.lang.Object.getClass
  0.2%     4  +     0    java.lang.AbstractStringBuilder.<init>
  0.2%     0  +     3    java.io.FileOutputStream.close0
  0.2%     0  +     3    java.lang.Object.clone
  0.2%     0  +     3    java.lang.Object.hashCode
  0.2%     0  +     3    java.io.UnixFileSystem.canonicalize0
  0.2%     3  +     0    java.lang.StringCoding$CharsetSE.encode
  0.2%     1  +     2    br.jabuti.project.ClassFile.<init>
  0.1%     0  +     2    java.lang.ClassLoader.findBootstrapClass
  0.1%     0  +     2    java.io.FileOutputStream.open
  0.1%     0  +     2    java.util.zip.Inflater.inflateBytes
  0.1%     2  +     0    java.lang.StringCoding.trim
  0.1%     2  +     0    java.io.DataInputStream.<init>
 12.4%    99  +   131    Total interpreted (including elided)

     Compiled + native   Method                        
  3.7%    69  +     0    java.util.HashMap.put
  1.4%    26  +     0    java.util.HashMap$HashIterator.nextEntry
  1.2%    23  +     0    java.util.AbstractList.hashCode
  1.0%    19  +     0    java.util.HashMap$KeyIterator.next
  0.9%    16  +     0    java.util.HashSet.contains
  0.8%    15  +     0    java.io.DataInputStream.readUnsignedShort
  0.6%    12  +     0    java.util.AbstractList$Itr.hasNext
  0.6%    12  +     0    org.apache.bcel.generic.InstructionList.getInstructionHandles
  0.5%    10  +     0    br.jabuti.graph.RRLiveDefs.computeBottom
  0.5%     9  +     0    java.util.AbstractList$Itr.next
  0.4%     8  +     0    java.util.HashMap.transfer
  0.4%     7  +     0    java.util.AbstractCollection.addAll
  0.3%     6  +     0    java.util.HashMap.newKeyIterator
  0.3%     6  +     0    java.util.AbstractSet.equals
  0.3%     6  +     0    java.util.Hashtable.get
  0.3%     6  +     0    java.io.DataInputStream.readUTF
  0.3%     6  +     0    br.jabuti.verifier.InstructionGraph.calcStack
  0.3%     5  +     0    java.util.Vector.add
  0.3%     5  +     0    br.jabuti.graph.CFGNode.getLabel
  0.3%     5  +     0    java.util.Hashtable.containsKey
  0.2%     4  +     0    java.util.Hashtable$Enumerator.next
  0.2%     3  +     0    java.util.HashSet.add
  0.2%     3  +     0    java.util.AbstractList.listIterator
  0.2%     3  +     0    br.jabuti.criteria.DefUse.equals
  0.2%     3  +     0    java.util.Hashtable.rehash
 19.0%   345  +     9    Total compiled (including elided)

         Stub + native   Method                        
 10.9%     0  +   203    java.lang.Class.getComponentType
  8.2%     0  +   152    java.lang.Object.hashCode
  6.3%     0  +   117    java.lang.Object.clone
  2.5%     0  +    47    java.lang.System.arraycopy
  1.7%     0  +    32    sun.reflect.Reflection.getCallerClass
  0.9%     0  +    16    java.lang.Class.forName0
  0.5%     1  +     8    java.io.UnixFileSystem.getBooleanAttributes0
  0.4%     0  +     8    java.lang.reflect.Array.newArray
  0.4%     0  +     8    java.io.FileInputStream.readBytes
  0.1%     0  +     2    sun.reflect.Reflection.getClassAccessFlags
  0.1%     0  +     1    java.lang.Class.getModifiers
 32.0%     1  +   594    Total stub

  Thread-local ticks:
 11.2%   235             Blocked (of total)
  0.4%     7             Class loader
  2.5%    46             Compilation
 33.7%   627             Unknown: thread_state


Global summary of 7742.32 seconds:
100.0% 575132            Received ticks
 99.6% 572998            Received GC ticks
  0.0%    37             Compilation
  0.0%    32             Other VM operations
  0.0%     7             Class loader
  0.1%   627             Unknown code


```