package GUIs;

import Classes.*;
import java.util.ArrayList;

public class GUI_Localidades extends javax.swing.JFrame {
    final String FileRoute = "PeregrinosBinary.data";
    final String FileRouteLocalidad = "LocalidadesBinary.data";
    static int indexL;
    
    public GUI_Localidades(int index) {
        indexL = index;
        initComponents();
        setLocationRelativeTo(null);
        ArrayList<Peregrino> newfile = new ArrayList<>();
        newfile = FilesManager_bin.showListedPeregrinoFile(FileRoute);
        String currentCamino = newfile.get(indexL).getCamino().getNombre();
        ArrayList<Localidad> localidades = FilesManager_bin.showListedLocalidadFile(FileRouteLocalidad);
        LocalidadesTextArea.setText("Nro.\tNombre\tComunidadAutonoma\tCodigoPostal\tTipo\n");
        switch(currentCamino){
            case "Camino Frances":
                int j1 = 1;
                for(int i = 1; i < 33; i++){
                    LocalidadesTextArea.append((localidades.get(i-1)).formatRegister(j1) + "\n");
                    j1++;
                }
                LocalidadesTextArea.append((localidades.get(64)).formatRegister(34));
                break;
            case "Camino Portugués":
                int j2 = 1;
                for(int i = 34; i < 58; i++){
                    LocalidadesTextArea.append((localidades.get(i-1)).formatRegister(j2) + "\n");
                    j2++;
                }
                LocalidadesTextArea.append((localidades.get(64)).formatRegister(26));
                break;
            case "Camino Inglés":
                int j3 = 1;
                for(int i = 59; i < 64; i++){
                    LocalidadesTextArea.append((localidades.get(i-1)).formatRegister(j3) + "\n");
                    j3++;
                }
                LocalidadesTextArea.append((localidades.get(64)).formatRegister(6));
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LocalidadesTextArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(35, 36, 76));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOCALIDADES ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jButton2.setBackground(new java.awt.Color(37, 40, 70));
        jButton2.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Albergues");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, -1, -1));

        LocalidadesTextArea.setEditable(false);
        LocalidadesTextArea.setBackground(new java.awt.Color(45, 36, 76));
        LocalidadesTextArea.setColumns(20);
        LocalidadesTextArea.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        LocalidadesTextArea.setForeground(new java.awt.Color(255, 255, 255));
        LocalidadesTextArea.setRows(5);
        jScrollPane2.setViewportView(LocalidadesTextArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 800, 400));

        jButton3.setBackground(new java.awt.Color(37, 40, 70));
        jButton3.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        GUI_Albergue pVisible = new GUI_Albergue(indexL);
        pVisible.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        GUI_Principal pVisible = new GUI_Principal(indexL);
        pVisible.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea LocalidadesTextArea;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
