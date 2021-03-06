package siplapro;
/**
 *
 * @author reyes
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.RefineryUtilities;

public class tabulado extends javax.swing.JFrame {
    
    procesos[] iProcesos;
    int Time;
    String[] historial0 = new String[200];
    
    public void cargarProcesos(procesos[] aProcesos, String[] historial, int time){
        for (int i = 0; i < aProcesos.length; i++) {
            try{
                Object o[]=null;
                modelo.addRow(o);
                modelo.setValueAt(aProcesos[i].getName(), i, 0);
                modelo.setValueAt(aProcesos[i].getTlleg(), i, 1);
                modelo.setValueAt(aProcesos[i].getCpu1(), i, 2);
                modelo.setValueAt(aProcesos[i].getEs(), i, 3);
                modelo.setValueAt(aProcesos[i].getCpu2(), i, 4);
                modelo.setValueAt(aProcesos[i].getTfinal(), i, 5);
                modelo.setValueAt(aProcesos[i].getTser(), i, 6);
                modelo.setValueAt(aProcesos[i].getTesp(), i, 7);
                modelo.setValueAt(aProcesos[i].getIndSer(), i, 8);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        float iTMS=0;
        float iTME=0;
        float iIS=0;
        for (int i = 0; i < aProcesos.length; i++) {
            iTMS += (float)Float.valueOf(modelo.getValueAt(i, 6).toString());
            iTME += (float)Float.valueOf(modelo.getValueAt(i, 7).toString());
            iIS += (float)Float.valueOf(modelo.getValueAt(i, 8).toString());
        }
        
        TMS.setText(Float.toString((float)iTMS/aProcesos.length));
        TME.setText(Float.toString((float)iTME/aProcesos.length));
        IS.setText(Float.toString((float)iIS/aProcesos.length));
        
        iProcesos = aProcesos;
        
        Time = time;
        
        for (int i = 0; i < time; i++) {
            historial0[i] = historial[i];
        }
    }

    public tabulado() {
        initComponents();
        this.setSize(1100, 620);
        this.setLocationRelativeTo(null);
        CrearModelo();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TME = new javax.swing.JLabel();
        IS = new javax.swing.JLabel();
        TMS = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnGantt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Tabulado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 29, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1020, 336));

        jLabel2.setText("Tiempo medio de servicio: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 432, -1, -1));

        jLabel3.setText("Tiempo medio de espera:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 432, -1, -1));

        jLabel4.setText("Indice de servicio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 432, -1, -1));
        getContentPane().add(TME, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 432, 74, 16));
        getContentPane().add(IS, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 432, 78, 16));
        getContentPane().add(TMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 432, 67, 16));

        btnBack.setText("Volver");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 509, 88, -1));

        btnGantt.setText("Gantt ");
        btnGantt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanttActionPerformed(evt);
            }
        });
        getContentPane().add(btnGantt, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 509, 80, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siplapro/red.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        inicio win = new inicio();
        win.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGanttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanttActionPerformed
        ganttChart demo = new ganttChart("Diagrama de gantt", historial0, Time, iProcesos);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }//GEN-LAST:event_btnGanttActionPerformed

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
            java.util.logging.Logger.getLogger(tabulado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabulado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabulado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabulado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabulado().setVisible(true);
            }
        });
    }
    
    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Proceso", "T. Llegada", "Refaga CPU",
                        "E/S", "Refaga CPU", "T. Final", "T. Servicio", "T. Espera", "Indice de Servicio"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Problema con el modelo de tabla");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IS;
    private javax.swing.JLabel TME;
    private javax.swing.JLabel TMS;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGantt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
