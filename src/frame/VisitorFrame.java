package frame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fanyuting
 */
public class VisitorFrame extends javax.swing.JFrame {

    /**
     * Creates new form VisitorFrame
     */
    public VisitorFrame() {
        initComponents();
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[10][4],
                new String[]{
                    "No.", "Date", "Category", "Solved"
                }
        ));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        fromYearComboBox.setSelectedItem(year);
        fromMonthComboBox.setSelectedIndex(month);
        fromDateComboBox.setSelectedIndex(day - 1);
        toYearComboBox.setSelectedItem(year);
        toMonthComboBox.setSelectedIndex(month);
        toDateComboBox.setSelectedIndex(day - 1);
    }

    public String getCalTime(Calendar cal) {
//        int fromYear = 2014 - fromYearComboBox.getSelectedIndex();
//        int fromMonth = fromMonthComboBox.getSelectedIndex();
//        int fromDate = 1 + fromDateComboBox.getSelectedIndex();
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(fromYear, fromMonth, fromDate);

        String strdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (cal != null) {
            strdate = sdf.format(cal.getTime());
        }
        //String d=fromYear+"-"+fromMonth+"-"+fromDate;
//        Date d = new Date(fromYear, fromMonth, fromDate);
//        System.out.println(fromYear);
//        System.out.println(fromMonth);
//        System.out.println(fromDate);
//        long sec = date.getTime();
//        return sec;
        // return date;

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        SimpleDateFormat df = new SimpleDateFormat("yy-mm-dd");
//        String dateText = df.format(d);
//        return dateText;
        return strdate;
    }

//    public String getToTime(Calendar cal) {
////        int toYear = 2014 - toYearComboBox.getSelectedIndex();
////        int toMonth = 1 + toMonthComboBox.getSelectedIndex();
////        int toDate = 1 + toDateComboBox.getSelectedIndex();
//////        Calendar cal = Calendar.getInstance();
////        cal.set(toYear, toMonth, toDate);
//
//        String strdate = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        if (cal != null) {
//            strdate = sdf.format(cal.getTime());
//        }
//        return strdate;
//    }
    public Calendar getCalendar(JComboBox yearBox, JComboBox monthBox, JComboBox dateBox) {
        int toYear = 2014 - yearBox.getSelectedIndex();
        int toMonth = monthBox.getSelectedIndex();
        int toDate = 1 + dateBox.getSelectedIndex();
        Calendar cal = Calendar.getInstance();
        cal.set(toYear, toMonth, toDate);
        return cal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateFromPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fromYearComboBox = new javax.swing.JComboBox();
        fromMonthComboBox = new javax.swing.JComboBox();
        fromDateComboBox = new javax.swing.JComboBox();
        categoryPanel = new javax.swing.JPanel();
        categoryComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        dateToPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        toYearComboBox = new javax.swing.JComboBox();
        toMonthComboBox = new javax.swing.JComboBox();
        toDateComboBox = new javax.swing.JComboBox();
        buttonPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("From");

        fromYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001" }));
        fromYearComboBox.setName("visitorFromYearCombobox"); // NOI18N

        fromMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        fromMonthComboBox.setSelectedIndex(10);
        fromMonthComboBox.setName("visitorFromMonthCombobox"); // NOI18N

        fromDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        fromDateComboBox.setSelectedIndex(1);
        fromDateComboBox.setName("visitorFromDayCombobox"); // NOI18N
        fromDateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromDateComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dateFromPanelLayout = new javax.swing.GroupLayout(dateFromPanel);
        dateFromPanel.setLayout(dateFromPanelLayout);
        dateFromPanelLayout.setHorizontalGroup(
            dateFromPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateFromPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromMonthComboBox, 0, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dateFromPanelLayout.setVerticalGroup(
            dateFromPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateFromPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(dateFromPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Stapler", "Tuition Fee", "Complaints", "Collect Assignments", "Meet People" }));

        jLabel3.setText("Category");

        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Category", "Solved"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jLabel2.setText("To");

        toYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001" }));
        toYearComboBox.setName("visitorToYearCombobox"); // NOI18N

        toMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        toMonthComboBox.setSelectedIndex(10);
        toMonthComboBox.setName("visitorToMonthCombobox"); // NOI18N

        toDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        toDateComboBox.setSelectedIndex(1);
        toDateComboBox.setName("visitorToDayCombobox"); // NOI18N
        toDateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDateComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dateToPanelLayout = new javax.swing.GroupLayout(dateToPanel);
        dateToPanel.setLayout(dateToPanelLayout);
        dateToPanelLayout.setHorizontalGroup(
            dateToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateToPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(toYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dateToPanelLayout.setVerticalGroup(
            dateToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateToPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dateToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(toYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchButton.setText("Search");
        searchButton.setName("visitorSearchButton"); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.setName("visitorClearButton"); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setName("visitorBackButton"); // NOI18N

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addGap(18, 18, 18)
                .addComponent(backButton))
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Clear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Back");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Window");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Close");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Help");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Help Contents");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateFromPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateToPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dateFromPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateToPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toDateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDateComboBoxActionPerformed

    private void fromDateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromDateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromDateComboBoxActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        //pass studentID, fromDate, toDate, category index to SearchStudent and search in database
        Calendar fromCal = getCalendar(fromYearComboBox, fromMonthComboBox, fromDateComboBox);
        Calendar toCal = getCalendar(toYearComboBox, toMonthComboBox, toDateComboBox);
        if (fromCal.compareTo(toCal) > 0) {
            JOptionPane.showMessageDialog(dateFromPanel, "End date can't be earlier than start date!");
        } else {
            String fromCalStr = getCalTime(fromCal);
            String toCalStr = getCalTime(toCal);
            //selectedIndex = 0 means search all cateogries in this date range
            sql.SearchStudent search = new sql.SearchStudent();
            if (categoryComboBox.getSelectedIndex() == 0) {
                search = new sql.SearchStudent(1, fromCalStr, toCalStr);
                if (search.getVisitList().size() == 0) {
                    JOptionPane.showMessageDialog(dateFromPanel, "No visit history in this query!");
                } else {
                    resultTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[search.getVisitList().size()][4],
                            new String[]{
                                "No.", "Date", "Category", "Solved"
                            }
                    ));
                    for (int i = 0; i < search.getVisitList().size(); i++) {
                        resultTable.setValueAt(i + 1, i, 0);
                        resultTable.setValueAt(search.getVisitList().get(i).getDate(), i, 1);
                        resultTable.setValueAt(search.getVisitList().get(i).getCategory(), i, 2);
                        if (search.getVisitList().get(i).getSolved() == 0) {
                            resultTable.setValueAt("Unsolved", i, 3);
                        } else {
                            resultTable.setValueAt("Solved", i, 3);
                        }
                    }
                }
            } else {
                ArrayList<model.Visit> visitList = search.searchVisitByCategory(1, categoryComboBox.getSelectedItem().toString(), fromCalStr, toCalStr);
                System.out.println(visitList.size());
                resultTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[visitList.size()][4],
                        new String[]{
                            "No.", "Date", "Category", "Solved"
                        }
                ));
                for (int i = 0; i < visitList.size(); i++) {
                    resultTable.setValueAt(i + 1, i, 0);
                    resultTable.setValueAt(visitList.get(i).getDate(), i, 1);
                    resultTable.setValueAt(categoryComboBox.getSelectedItem().toString(), i, 2);
                    if (visitList.get(i).getSolved() == 0) {
                        resultTable.setValueAt("Unsolved", i, 3);
                    } else {
                        resultTable.setValueAt("Solved", i, 3);
                    }
                }
            }

        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        fromYearComboBox.setSelectedItem(year);
        fromMonthComboBox.setSelectedIndex(month);
        fromDateComboBox.setSelectedIndex(day - 1);
        toYearComboBox.setSelectedItem(year);
        toMonthComboBox.setSelectedIndex(month);
        toDateComboBox.setSelectedIndex(day - 1);
        categoryComboBox.setSelectedIndex(0);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[10][4],
                new String[]{
                    "No.", "Date", "Category", "Solved"
                }
        ));
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisitorFrame().setVisible(true);

                sql.CreateDB createdb = new sql.CreateDB();
                createdb.CreateDB();
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel dateFromPanel;
    private javax.swing.JPanel dateToPanel;
    private javax.swing.JComboBox fromDateComboBox;
    private javax.swing.JComboBox fromMonthComboBox;
    private javax.swing.JComboBox fromYearComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox toDateComboBox;
    private javax.swing.JComboBox toMonthComboBox;
    private javax.swing.JComboBox toYearComboBox;
    // End of variables declaration//GEN-END:variables
}
