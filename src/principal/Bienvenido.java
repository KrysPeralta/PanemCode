package principal;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenido extends javax.swing.JFrame {
    
    private Timer timer;
    private int alpha = 255;

    public Bienvenido() {
        initComponents();
        iniciarDesvanecimiento();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo-panem-code.png")));
        this.setLocationRelativeTo(null); //Centrar pantalla
        
        btnAcceder.setBackground(new Color(255,255,255));
        
        
    }
    
    private void iniciarDesvanecimiento() {
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 5; // Cambia la velocidad del desvanecimiento ajustando este valor
                if (alpha <= 0) {
                    alpha = 0;
                    timer.stop();
                }
                lblImagen.setForeground(new Color(0, 0, 0, alpha));
            }
        });
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWelcome = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        btnAcceder = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelWelcome.setBackground(new java.awt.Color(221, 221, 221));

        lblBienvenido.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        lblBienvenido.setText("PanemCode");

        btnAcceder.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnAcceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAccederMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAccederMouseExited(evt);
            }
        });
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-panem-code.png"))); // NOI18N

        javax.swing.GroupLayout panelWelcomeLayout = new javax.swing.GroupLayout(panelWelcome);
        panelWelcome.setLayout(panelWelcomeLayout);
        panelWelcomeLayout.setHorizontalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWelcomeLayout.createSequentialGroup()
                .addGroup(panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelWelcomeLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(lblImagen))
                    .addGroup(panelWelcomeLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(lblBienvenido))
                    .addGroup(panelWelcomeLayout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        panelWelcomeLayout.setVerticalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblBienvenido)
                .addGap(18, 18, 18)
                .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        Compiler ini = new Compiler();
        ini.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAccederActionPerformed

    private void btnAccederMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccederMouseEntered
        btnAcceder.setBackground(new Color(204,204,255));
    }//GEN-LAST:event_btnAccederMouseEntered

    private void btnAccederMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccederMouseExited
        btnAcceder.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnAccederMouseExited

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
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
                
                new Bienvenido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JPanel panelWelcome;
    // End of variables declaration//GEN-END:variables
}
