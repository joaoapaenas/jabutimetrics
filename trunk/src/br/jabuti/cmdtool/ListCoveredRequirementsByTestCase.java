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



import java.io.*;
import java.util.*;

import br.jabuti.criteria.*;
import br.jabuti.project.*;
import br.jabuti.util.*;


/**
	This application program list the set of covered requirements in a
	given JabutiProject, considering a given test case number and a specific 
	testing criterion.
 
 	By executing such an application, in a project named "test.jbt", 
 	considering the all-nodes criterion and the test case number 1
 	
	$ java -cp ".;lib\BCEL.jar;lib\jviewsall.jar" cmdtool.ListCoveredRequirementsByTestCase -all-nodes -P fact.jbt 1

	The corresponding output is:
	
	All-Nodes Coverage w.r.t. Test Case 0001
	
	Total coverage: 19 of 20
	
	{(0,0,2),(0,0,3),(0,0,1),(0,1,6),(0,1,4),(0,1,1),(0,1,3),(0,1,5),(0,1,2),(0,1,0),(0,2,0),(0,2,2),
	 (0,2,1),(0,2,6),(0,2,8),(0,2,4),(0,2,5),(0,2,7),(0,2,3)}
 
	where, which 3-tuple (<I>a</I>,<I>b</I>,<I>c</I>) means:
		 <UL>
		 <LI><I>a</I> - the class number
		 <LI><I>b</I> - the method number
		 <LI><I>c</I> - the requirement number
		 </UL>

<P>

	Observe the requirement number is a integer that unically identifies a given
	testing requirement in a given method. The user can use 
	{@link PrintRequirementsTable} to generate a table containing the correpondence 
	between requirement number and the testing requirement itself.

 @version: 0.00001
 @author: Auri Marcelo Rizzo Vincenzi

*/
public class ListCoveredRequirementsByTestCase {
    public static void usage() {
        System.out.println(ToolConstants.toolName + " v. " + ToolConstants.toolVersion);
        System.out.println("\nListCoveredRequirementsByTestCase usage:");
        System.out.println("-------------------\n");
        System.out.println("java br.jabuti.cmdtool.ListCoveredRequirementsByTestCase [-d <DIR>] -anei|-aned|-aeei|-aeed|-auei|-aued|-apuei|-apued -p <PROJECT_NAME> <test_case_number>\n");
        System.out.println("      [-d <DIR>]              Optional parameter. Specify the directory where the project");
        System.out.println("                              is located. If not specified, the current directory is assumed.");
		System.out.println("      -anei                   reports the required elements by the all-nodes-exception-independent criterion.");
		System.out.println("      -aned                   reports the required elements by the all-nodes-exception-dependent criterion.");
		System.out.println("      -aeei                   reports the required elements by the all-edges-exception-independent criterion.");
		System.out.println("      -aeed                   reports the required elements by the all-edges-exception-dependent criterion.");
		System.out.println("      -auei                   reports the required elements by the all-uses-exception-independent criterion.");
		System.out.println("      -aued                   reports the required elements by the all-uses-exception-dependent criterion.");
		System.out.println("      -apuei                  reports the required elements by the all-potential-uses-exception-independent criterion.");
		System.out.println("      -apued                  reports the required elements by the all-potential-uses-exception-dependent criterion.");
        System.out.println("      -p <PROJECT_NAME>       Specify the name of the project to be used. The");
        System.out.println("                              project must be a valid project file (.jba) generated by");
        System.out.println("                              instrument the base class.");
        System.out.println("      <test_case_number>      The number of the test case being evalueted) generated");
        System.out.println("\nCopyright (c) 2002\n");
    }

    public static void main(String args[]) throws Throwable {
		
        String workDir = null;
        String projectName = null;
						
        JabutiProject project = null;
        
        int criterionId = -1;
        String criterionName = null;
		
        if (args.length > 0) {

            int i = 0;
			
            while ((i < args.length) && (args[i].startsWith("-"))) {
                // selected criterion
                if (("-anei".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.PRIMARY_NODES;
                	criterionName = AbstractCriterion.getName( criterionId );
                } 
				else if (("-aned".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.SECONDARY_NODES;
                	criterionName = AbstractCriterion.getName( criterionId );
                } 
				else if (("-aeei".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.PRIMARY_EDGES;
                	criterionName = AbstractCriterion.getName( criterionId );
                } 
                else if (("-aeed".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.SECONDARY_EDGES;
                	criterionName = AbstractCriterion.getName( criterionId );
                }
                else if (("-auei".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.PRIMARY_USES;
                	criterionName = AbstractCriterion.getName( criterionId );
                } 
                else if (("-aued".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.SECONDARY_USES;
                	criterionName = AbstractCriterion.getName( criterionId );
                }                
                else if (("-apuei".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.PRIMARY_POT_USES;
                	criterionName = AbstractCriterion.getName( criterionId );
                } 
                else if (("-apued".equals(args[i])) && (i < args.length - 1)) {
                	criterionId = Criterion.SECONDARY_POT_USES;
                	criterionName = AbstractCriterion.getName( criterionId );
                }                
                
				 // -d: work directory
                else if (("-d".equals(args[i])) && (i < args.length - 1)) {
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
			
            // Gettin the test case number 
            if (i >= args.length) {
                System.out.println("Error: Missing test case number!!!");
                usage();
                System.exit(0);
            }
			
            int tcNumber = Integer.parseInt(args[i]);
			
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
 				
                // Getting the desered test case
                String tcLabel = ToolConstants.getFourDigitNumber(tcNumber);
                TestCase tc = TestSet.getTestCase(tcLabel);
       			
                if (tc != null) {
                    //HashSet pathLabels = tc.getPathSetLabels();

                    System.out.println("\n" + criterionName + " Coverage w.r.t. Test Case " + tcLabel + "\n" );
                    System.out.println("Total coverage: " + tc.getTestCaseCoverage( criterionId ) + "\n" );
	                
                    // For each class
                    String[] classFileNames = project.getAllClassFileNames();

                    System.out.print("{");                
                    for (i = 0; i < classFileNames.length; i++) {
                        ClassFile cf =project.getClassFile(classFileNames[i]);
	                
                        // For each method
                        String[] methodsNames = cf.getAllMethodsNames();

						if ( methodsNames == null )
							continue;

                        for (int j = 0; j < methodsNames.length; j++) {
                            ClassMethod cm = cf.getMethod(methodsNames[j]);
	                		
                            Criterion criterion = cm.getCriterion(criterionId);
							
                            Object req[] = criterion.getRequirements();
	                			
                            HashSet covReq = new HashSet();
	
                            covReq = cm.getCoveredRequirementsByTestCase(criterionId, tcLabel);
                            Iterator it = covReq.iterator();

                            if (it.hasNext() && ((i > 0) || (j > 0))) {
                                System.out.print(",");
                            }
                            
                            while (it.hasNext()) {
                            	String elem = null;
                            	int elemId = -1;
                            	if ( criterionId == Criterion.PRIMARY_EDGES || 
                            	     criterionId == Criterion.SECONDARY_EDGES ) {
                                	elem = ((Edge) it.next()).toString();
	                                for (int c = 0; ((c < req.length)
	                                        && (elemId == -1)); c++) {
	                                    if (elem.equals(((Edge) req[c]).toString())) {
	                                        elemId = c;
	                                    }
	                                }
	                            }
                                else if ( criterionId == Criterion.PRIMARY_USES || 
                            	          criterionId == Criterion.SECONDARY_USES || 
										  criterionId == Criterion.PRIMARY_POT_USES || 
                            	          criterionId == Criterion.SECONDARY_POT_USES ) {
                                	elem = ((DefUse) it.next()).toString();
	                                for (int c = 0; ((c < req.length)
	                                        && (elemId == -1)); c++) {
	                                    if (elem.equals(((DefUse) req[c]).toString())) {
	                                        elemId = c;
	                                    }
	                                }
	                            }
                                else {
                                	elem = it.next().toString();
	                                for (int c = 0; ((c < req.length)
	                                        && (elemId == -1)); c++) {
	                                    if (elem.equals(req[c].toString())) {
	                                        elemId = c;
	                                    }
	                                }
	                            }
	           					
                                System.out.print("(" + cf.getClassId() + "," + cm.getMethodId() + "," + elemId + ")");
                                if (it.hasNext()) {
                                    System.out.print(",");
                                }
                            }
                        }
                    }
                    System.out.print("}\n");
                } else {
                    System.out.println("Invalid test case number!!!");
                }
            } catch (Exception e) {
                ToolConstants.reportException(e, ToolConstants.STDERR);
                System.exit(0);
            }
        } else {
            usage();
        }
    }
}
