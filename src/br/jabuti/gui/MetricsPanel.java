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

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import javax.swing.table.*;

import br.jabuti.lookup.*;
import br.jabuti.metrics.Metrics;

import br.jabuti.util.*;

/**
 * This class is responsable to sort the table according to
 * each column value...
 *
 * @version: 1.0
 * @author: Auri Vincenzi
 * @author: Marcio Delamaro 
 */
class SortFilterModel extends AbstractTableModel {
    /**
	 * Added to jdk1.5.0_04 compiler
	 */
	private static final long serialVersionUID = 2126014330005689140L;

	public SortFilterModel(TableModel m) {
        model = m;
        rows = new Row[model.getRowCount()];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row();
            rows[i].index = i;
        }
        
        columnTip = new String[Metrics.metrics.length + 1];
        columnTip[0] = new String( "Instrumented Classes" );
        for( int i = 0; i < Metrics.metrics.length; i++ ) {
        	columnTip[i+1] = Metrics.metrics[i][1];
        }
    }

    public void sort(int c) {
        sortColumn = c;
        Arrays.sort(rows);
        fireTableDataChanged();
    }

    public void addMouseListener(final JTable table) {
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {  // check for double click
                if (event.getClickCount() < 2) {
                    return;
                }

                // find column of click and
                int tableColumn
                        = table.columnAtPoint(event.getPoint());

                // translate to table model index and sort
                int modelColumn
                        = table.convertColumnIndexToModel(tableColumn);

                sort(modelColumn);
            }
        }
        );
    }

    public void addMouseMotionListener(final JTable table) {
        table.getTableHeader().addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent event) {  
                // find column of click and
                int tableColumn
                        = table.columnAtPoint(event.getPoint());
                  
                table.getTableHeader().setToolTipText(columnTip[ tableColumn ]);
            }
        }
        );
    }

    /* compute the moved row for the three methods that access
     model elements
     */

    public Object getValueAt(int r, int c) {
        return model.getValueAt(rows[r].index, c);
    }

    public boolean isCellEditable(int r, int c) {  // return model.isCellEditable(rows[r].index, c);
        return false;
    }

    public void setValueAt(Object aValue, int r, int c) {
        model.setValueAt(aValue, rows[r].index, c);
    }

    /* delegate all remaining methods to the model
     */

    public int getRowCount() {
        return model.getRowCount();
    }

    public int getColumnCount() {
        return model.getColumnCount();
    }

    public String getColumnName(int c) {
        return model.getColumnName(c);
    }

    public Class getColumnClass(int c) {
        return model.getColumnClass(c);
    }

    /* this inner class holds the index of the model row
     Rows are compared by looking at the model row entries
     in the sort column
     */

    private class Row implements Comparable {
        public int index;
        public int compareTo(Object other) {
            Row otherRow = (Row) other;
            Object a = model.getValueAt(index, sortColumn);
            Object b = model.getValueAt(otherRow.index, sortColumn);

            if (a instanceof Comparable) {
                return ((Comparable) a).compareTo(b);
            } else {
                return index - otherRow.index;
            }
        }
    }

    private TableModel model;
    private int sortColumn;
    private Row[] rows;
   
    String[] columnTip;
}

/**
 * This class shows a table where each line correspond
 * to a given class file and each column to a given metric
 * applied to the corresponding class file.
 *
 * The metrics are calculated by the {@link Metrics} class.
 *
 * @version: 1.0
 * @author: Auri Vincenzi
 * @author: Marcio Delamaro
 *
 */
public class MetricsPanel extends JScrollPane {

    /**
	 * Added to jdk1.5.0_04 compiler
	 */
	private static final long serialVersionUID = -6936425469400413909L;
	private Object[][] cells;
    private String[] columnNames;
    JTable table;

    public MetricsPanel( Program prog, String[] classes ) {
        super();    	
        	// Only the instrumented classes
	        //Metrics mt = new Metrics( prog, classes );
	        // All classes. Project class names painted in blue
			Metrics mt = new Metrics( prog );
            
            columnNames = new String[Metrics.metrics.length + 1];
            columnNames[0] = new String("Class Name");
            for (int i = 0; i < Metrics.metrics.length; i++) {
                columnNames[i + 1] = Metrics.metrics[i][0].toUpperCase();
            }
	  
            //String[] classNames = classes;
            
            String[] classNames = prog.getCodeClasses();
            	  
            cells = new Object[classNames.length][Metrics.metrics.length + 1];
            for (int i = 0; i < classNames.length; i++) {
                cells[i][0] = classNames[i];
                Object[] metrics = mt.getClassMetrics(classNames[i]);

                for (int j = 0; j < metrics.length; j++) {
                    cells[i][j + 1] = metrics[j];
                }
            }

        // set up table model and interpose sorter
        DefaultTableModel model
                = new DefaultTableModel(cells, columnNames);
        SortFilterModel sorter = new SortFilterModel(model);

        // show table
        table = new JTable(sorter);

        table.getTableHeader().setToolTipText("My Header");
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Dimension dim = JabutiGUI.mainWindow().getSize();
		//table.setPreferredScrollableViewportSize( new Dimension( dim.width * 3, (int) ( dim.height * 0.8 )) );		
				
		// Adding the table to the current JScrollPane
		setViewportView( table );
        
        // set up double click handler for column headers
        sorter.addMouseListener(table);
        sorter.addMouseMotionListener(table);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        try {
        	//Program p = new Program(args[0], true, null, args[1]);
        	Program p = new Program("br.jabuti.metrics.Metrics", true, null, ".");
        	//String[] classes = p.getCodeClasses();
        	String[] classes = {"br.jabuti.metrics.Metrics"};
            
            MetricsPanel panel = new MetricsPanel( p, classes );
            frame.getContentPane().add( new JLabel( " NORTH LABEL " ), BorderLayout.NORTH );
        	frame.getContentPane().add( panel, BorderLayout.CENTER );
            frame.getContentPane().add( new JLabel( " SOUTH LABEL " ), BorderLayout.SOUTH );        	
        } catch (Exception e) {
            ToolConstants.reportException(e, ToolConstants.STDERR);
            System.exit(0);
        }
        
        frame.pack();
        frame.setVisible(true);
    }
}