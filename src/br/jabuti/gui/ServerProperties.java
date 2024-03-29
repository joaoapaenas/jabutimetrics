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


package br.jabuti.gui;

import javax.swing.*;
import java.io.*;

import br.jabuti.util.*;

/**
 * This class is responsible to show information about
 * the autors of the tool.
 * 
 * @version: 1.0
 * @author: Auri Vincenzi
 * @author: Marcio Delamaro
 */
public class ServerProperties extends javax.swing.JDialog {
    
    /**
	 * Added to jdk1.5.0_04 compiler
	 */
	private static final long serialVersionUID = 7559456573743560269L;
	/** Creates new form ServerProperties */
    public ServerProperties(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        portLabel = new javax.swing.JLabel();
        if ( portField == null ) {
        	portField = new javax.swing.JTextField();
        	portField.setText("1988");
        }
        
        confLabel = new javax.swing.JLabel();
        
        if ( confFileName == null ) {
        	confFileName = new javax.swing.JTextField();
        	confFileName.setText("<configuration_file>");        	
    	}
    	
        browserButton = new javax.swing.JButton();
        scrollArea = new javax.swing.JScrollPane();
        
        if ( textArea == null )
        	textArea = new javax.swing.JTextArea();
        	
        saveButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

		if ( debugCheck == null ) {
        	debugCheck = new javax.swing.JCheckBox();
   	        debugCheck.setSelected(true);
	        debugCheck.setText("Debug");
		}

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle("Test Server Properties");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        portLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        portLabel.setText("Port Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(portLabel, gridBagConstraints);

        portField.setToolTipText("Enter with the server port number");
        portField.setMinimumSize(new java.awt.Dimension(32, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(portField, gridBagConstraints);

        confLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        confLabel.setText("Configuration File:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(confLabel, gridBagConstraints);

        confFileName.setToolTipText("Enter the name of the server configuration file");
        confFileName.setMinimumSize(new java.awt.Dimension(146, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        getContentPane().add(confFileName, gridBagConstraints);

        browserButton.setText("Browse");
        browserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        getContentPane().add(browserButton, gridBagConstraints);

        scrollArea.setMinimumSize(new java.awt.Dimension(64, 128));
        scrollArea.setPreferredSize(new java.awt.Dimension(64, 128));
        scrollArea.setViewportView(textArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        getContentPane().add(scrollArea, gridBagConstraints);

        saveButton.setText("Save");
        //saveButton.setEnabled( false );
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(saveButton, gridBagConstraints);

        debugCheck.setToolTipText("If selected shows server depuration info");
        debugCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        debugCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugCheckActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(debugCheck, gridBagConstraints);

        if ( deviceButton == null)
        {
        	deviceButton = new JRadioButton("Mobile device");
            codeButton = new JRadioButton("Mobile code");
            bg = new ButtonGroup();
            bg.add(deviceButton);
    		bg.add(codeButton);
    		deviceButton.setSelected(true);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(deviceButton, gridBagConstraints);
        getContentPane().add(codeButton, gridBagConstraints);
		
        okButton.setSelected(true);
        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(okButton, gridBagConstraints);

        pack();
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
    }

    private void debugCheckActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your handling code here:
        if ( debugCheck.isSelected() ) 
            System.out.println("Debug enabled...");
        else
            System.out.println("Debug disabled...");
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your handling code here:
        System.out.println("Save Button clicked...");
        
        // Setting the text field with the server configuration info
        String fileName = ServerProperties.confFileName.getText();
        
        if ( !fileName.endsWith( ".txt" ) ) {
            JOptionPane.showMessageDialog(null,
                    "Ivalid configuration file name " + fileName + "!!!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        BufferedWriter out;
        
        try{
	        // Reading the file and inserting its content in the text area
			out = new BufferedWriter(new FileWriter( fileName ));
			out.write( ServerProperties.textArea.getText(), 0, ServerProperties.textArea.getText().length() );
			out.flush();
			out.close();
		} catch ( Exception e ) {
			ToolConstants.reportException( e, ToolConstants.STDERR);
		}
    }

    private void browserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Add your handling code here:
        //System.out.println("Browser Button clicked...");

        JFileChooser fc = new JFileChooser(".");
        
        //LeftPanel leftPanel = new LeftPanel(fc);
        //fc.setAccessory(leftPanel);
        
        fc.setDialogTitle( "Open server configuration file..." );

        javax.swing.filechooser.FileFilter f =
                new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        }
                        if (f.getName().endsWith(".txt")) {
                            return true;
                        }
                        return false;
                    }

                    public String getDescription() {
                        return "Server Configuration file (.txt)";
                    }
                };

        fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
        fc.setFileFilter(f);

        int k = fc.showOpenDialog(this);

        if (k != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        File theFile = fc.getSelectedFile();

        if (!theFile.isFile()) // verifica se existe
        {
            JOptionPane.showMessageDialog(null,
                    "File " + theFile.getName() + " not found",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Setting the text field with the server configuration info
        ServerProperties.confFileName.setText( theFile.toString() );
        BufferedReader in;
        try{
	        // Reading the file and inserting its content in the text area
			in = new BufferedReader(new FileReader( theFile ));
			String line = null;
			ServerProperties.textArea.setText("");
			while ( (line = in.readLine()) != null )
				ServerProperties.textArea.append( line + "\n");
			in.close();
		} catch ( Exception e ) {
			ToolConstants.reportException( e, ToolConstants.STDERR);
		}
 
    }
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false);
        dispose();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new ServerProperties(new javax.swing.JFrame(), true).setVisible(true);
    }
    
    public static void reset() {
	    debugCheck = null;
	    confFileName = null;
	    portField = null;
	    textArea = null;    
    }
    
    public static String[] getServerParameters() {
    	String[] param = null; 
    	if ( (confFileName != null) && ( confFileName.getText().length() > 0) && 
	    	 (portField != null) && ( portField.getText().length() > 0) &&
	    	 (textArea != null) && (textArea.getText().length() > 0) &&
	    	 (debugCheck != null) ) {
	    	
			int i = 1;
	    	if ( debugCheck.isSelected() ) {
	    		param = new String[6];
	    		param[i++] = "-debug";
	    	}
	    	else 
	    		param = new String[5];

	    	if ( deviceButton.isSelected() )
			{
				param[0] = "Device";
			}
			else
			{
				param[0] = "Code";
			}
			
	    	 	
	    	param[i++] = "-port";
	    	param[i++] = portField.getText();
	    	param[i++] = "-projectfile";
	    	param[i++] = confFileName.getText();
	 	}
	 	return param;
    }
    
    // Variables declaration - do not modify
    private javax.swing.JLabel confLabel;
    private javax.swing.JScrollPane scrollArea;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel portLabel;
    private javax.swing.JButton browserButton;
    private javax.swing.JButton okButton;    

    static private javax.swing.JCheckBox debugCheck;
    static private javax.swing.JTextField confFileName;
    static private javax.swing.JTextField portField;
    static private javax.swing.JTextArea textArea;    
    static private ButtonGroup bg;
    static private JRadioButton codeButton, deviceButton;
    // End of variables declaration
}