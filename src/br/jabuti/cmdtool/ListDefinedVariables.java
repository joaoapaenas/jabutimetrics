/*  Copyright 2003  Auri Marcelo Rizzo Vicenzi, Marcio Eduardo Delamaro, 			    Jose Carlos Maldonado

    This file is part of Jabuti.

    Jabuti is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as 
    published by the Free Software Foundation, either version 3 of the      
    License, or (at your option) any later version.

    Jabuti is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Jabuti.  If not, see <http://www.gnu.org/licenses/>.
*/


package br.jabuti.cmdtool;


import org.apache.bcel.generic.*;

import java.io.*;
import java.util.*;

import br.jabuti.util.*;
import br.jabuti.graph.*;
import br.jabuti.lookup.*;
import br.jabuti.project.*;


/**
 Given a project file, a class number (<I>cId</I>),
 method number (<I>mId</I>) and a block number (<I>bId</I>), this 
 application program reports the set of defined variable numbers 
 in the corresponding block.

 <P>
 For example, by running
 
	$ java -cp ".;lib\BCEL.jar;lib\jviewsall.jar" cmdtool.ListDefinedVariables -P fact.jbt 0 1 0

 the output is the set:
  
	{(0,0),(1,1)}
 
 <P>
 Where each tuple (a,b) corresponds to:
		 <UL>
		 <LI><I>a</I> - the varaible index inside the variable table;
		 <LI><I>b</I> - the local variable number;
		 </UL> 

 The variable numbers is based on the LocalVariableTable of the .class file.
 This table contains complete information about the variables when a .class
 file was compiled with -g option. 
 
 Each variable number is refered as an integer number. {@link PrintVariablesTable} 
 gives the correspondency between a integer number and the corresponding
 variable name and source code location.

 @version: 0.00001
 @author: Auri Marcelo Rizzo Vincenzi

 */
public class ListDefinedVariables {
    public static void usage() {
        System.out.println(ToolConstants.toolName + " v. " + ToolConstants.toolVersion);
        System.out.println("\nListDefinedVariables usage:");
        System.out.println("-------------------\n");
        System.out.println("java br.jabuti.cmdtool.ListDefinedVariables [-d <DIR>] -p <PROJECT_NAME>  <class_id> <method_id> <block_id>\n");
        System.out.println("      [-d <DIR>]              Optional parameter. Specify the directory where the project");
        System.out.println("                              is located. If not specified, the current directory is assumed.");
        System.out.println("      -p <PROJECT_NAME>       Specify the name of the project to be used. The");
        System.out.println("                              project must be a valid project file (.jba) generated by");
        System.out.println("                              instrument the base class.");
        System.out.println("      <class_id>              An integer number that represents a given class");
        System.out.println("      <method_id>             An integer number that represents a given method of that class_id");
        System.out.println("      <block_id>              An integer number that represents a given cfg block of that method_id");
        System.out.println("\nCopyright (c) 2002\n");
    }

    public static void main(String args[]) throws Throwable {
        String workDir = null;
        String projectName = null;
						
        JabutiProject project = null;

        if (args.length > 0) {

            int i = 0;
			
            while ((i < args.length) && (args[i].startsWith("-"))) {
				// -d: work directory
                if (("-d".equals(args[i])) && (i < args.length - 1)) {
                    i++;
                    workDir = args[i];
                } // -p: project name
                else if (("-p".equals(args[i])) && (i < args.length - 1)) {
                    i++;
                    projectName = args[i];
                } else {
                    System.out.println("Error: Unrecognized option: " + args[i]);
                    System.exit(0);
                }
                i++;
            }

            // Checking if all essential parameters are not null
            if (projectName == null) {
                System.out.println("Error: Missing parameter!!!");
                usage();
                System.exit(0);
            }
			
            // Getting the classId 
            if (i >= args.length) {
                System.out.println("Error: Missing parameter!!!");
                usage();
                System.exit(0);
            }
			
            int classId = Integer.parseInt(args[i]);

            i++;
			
            // Gettin the methodId
            if (i >= args.length) {
                System.out.println("Error: Missing parameter!!!");
                usage();
                System.exit(0);
            }
			
            int methodId = Integer.parseInt(args[i]);

            i++;

            // Gettin the blockId
            if (i >= args.length) {
                System.out.println("Error: Missing parameter!!!");
                usage();
                System.exit(0);
            }

            int blockId = Integer.parseInt(args[i]);
			
            // Creating the absolute path to a given project
            String absoluteName = null;

            if (workDir != null) {
                absoluteName = workDir + File.separator + projectName;
            } else {
                absoluteName = projectName;
            }

            try {
                File theFile = new File(absoluteName);

                if (!theFile.isFile()) // verifica se existe
                {
                    System.out.println("File " + theFile.getName() + " not found");
                    System.exit(0);
                }
	          	
                project = JabutiProject.reloadProj( theFile.toString(), true );
 				
                // Getting the class code
                Program prog = project.getProgram();
                String classFileName = prog.getCodeClass(classId);

                ClassFile cf = project.getClassFile(classFileName);
                ClassMethod cm = cf.getMethod(methodId);
          		
                LocalVariableGen[] localVar = cm.getLocalVariables();
          		
                Hashtable systemVar = new Hashtable();
                int countSysVar = localVar.length;

                CFG cfg = cm.getCFG();
                GraphNode[] fdt = cfg.findDFT(true);
                GraphNode theNode = null;
          		
                for (i = 0; i < fdt.length; i++) {
                    GraphNode gn = fdt[i];
            		
                    if (gn.getNumber() == blockId) {
                        theNode = gn;
                    }
					
                    Hashtable definitions = ((CFGNode) gn).getDefinitions();

                    if (definitions.size() > 0) {
                        Enumeration it = definitions.keys();

                        while (it.hasMoreElements()) {
                            String s = (String) it.nextElement();

                            if (((!s.startsWith("L@"))
                                            && (!systemVar.containsKey(s)))
                                    || (s.startsWith("L@")
                                            && (s.indexOf(".") > 0)
                                            && (!systemVar.containsKey(s)))
                                    ) {
                                systemVar.put(s, new Integer(countSysVar++));
                            }
                        }
                    }
                }   		

                if (theNode != null) {
                    Hashtable definitions = ((CFGNode) theNode).getDefinitions();
					
                    if (definitions.size() > 0) {
                        System.out.print("\n{");

                        Enumeration it = definitions.keys();

                        while (it.hasMoreElements()) {
                            String s = (String) it.nextElement();
                            int byteOffset = ((Integer) definitions.get(s)).intValue();
                            int localVarIndex = -1;
                            int tabVarIndex = -1;
							
                            if (s.startsWith("L@") && (s.indexOf(".") < 0)) {
                                String numVar = s.substring(2, s.length());

                                localVarIndex = Integer.parseInt(numVar);
                                tabVarIndex = localVarIndex;
								
                                int currentDiff = -1;				   								   		

                                for (i = 0; i < localVar.length; i++) {
                                    if (localVar[i].getIndex() == localVarIndex) {
                                        if ((byteOffset
                                                <= localVar[i].getEnd().getPosition())) {
                                            int diff = Math.abs(localVar[i].getStart().getPosition() - byteOffset);

                                            if ((currentDiff == -1)
                                                    || (diff <= currentDiff)) {
                                                currentDiff = diff;
                                                tabVarIndex = i;
                                            }
                                        }
                                    }
                                }
                            } else {
                                localVarIndex = ((Integer) systemVar.get(s)).intValue();
                                tabVarIndex = localVarIndex;
                            }
				        	
                            System.out.print("(" + tabVarIndex + "," + localVarIndex + ")");

                            if (it.hasMoreElements()) {
                                System.out.print(",");
                            }
                        }
                        System.out.print("}\n");
                    } else {
                        System.out.println("\n\nNo variable definition in this block!!!");
                    }
                } else {
                    System.out.println("Block ID Invalid!!!");
                }

                /*
                 System.out.println( "\nLocal Variables of: " + cm.getMethodName() );
                 for( i = 0; i < localVar.length; i++ ) {
                 System.out.println( localVar[i] );
                 System.out.println( localVar[i].getIndex() + " - " + localVar[i].getName() );
                 }
                 */
            } catch (Exception e) {
                ToolConstants.reportException(e, ToolConstants.STDERR);
                System.exit(0);
            }
        } else {
            usage();
        }
    }
}
