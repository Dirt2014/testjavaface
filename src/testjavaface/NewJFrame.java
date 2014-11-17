/*
 * Created by JFormDesigner on Mon Nov 17 12:48:44 CST 2014
 */

package testjavaface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Fu Yun
 */
public class NewJFrame extends JFrame {
    public NewJFrame() {
        initComponents();
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Fu Yun
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem2 = new JMenuItem();
        jMenu3 = new JMenu();
        jMenuItem3 = new JMenuItem();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Face");
        Container contentPane = getContentPane();

        //======== jMenuBar1 ========
        {

            //======== jMenu1 ========
            {
                jMenu1.setText("File");

                //---- jMenuItem1 ----
                jMenuItem1.setText("jMenuItem1");
                jMenu1.add(jMenuItem1);
            }
            jMenuBar1.add(jMenu1);

            //======== jMenu2 ========
            {
                jMenu2.setText("Edit");

                //---- jMenuItem2 ----
                jMenuItem2.setText("jMenuItem2");
                jMenu2.add(jMenuItem2);
            }
            jMenuBar1.add(jMenu2);

            //======== jMenu3 ========
            {
                jMenu3.setText("jMenu3");

                //---- jMenuItem3 ----
                jMenuItem3.setText("jMenuItem3");
                jMenu3.add(jMenuItem3);
            }
            jMenuBar1.add(jMenu3);
        }
        setJMenuBar(jMenuBar1);

        //======== jPanel1 ========
        {

            // JFormDesigner evaluation mark
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGap(0, 308, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGap(0, 200, Short.MAX_VALUE)
            );
        }

        //---- jButton1 ----
        jButton1.setText("Capture");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });

        //---- jButton3 ----
        jButton3.setText("Confirm");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed(e);
            }
        });

        //---- jButton4 ----
        jButton4.setText("Start");
        jButton4.setPreferredSize(new Dimension(75, 23));
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton4ActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(54, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addGap(23, 23, 23))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Fu Yun
    private JMenuBar jMenuBar1;
    private JMenu jMenu1;
    private JMenuItem jMenuItem1;
    private JMenu jMenu2;
    private JMenuItem jMenuItem2;
    private JMenu jMenu3;
    private JMenuItem jMenuItem3;
    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton3;
    private JButton jButton4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
