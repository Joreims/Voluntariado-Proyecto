/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import datos.DActividades;
import entidades.Actividades;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author abiga
 */
public class FrmActividades extends javax.swing.JFrame {

    private int actividadID;
    private String fecha;
    private String hora;
    private String descripcion;
    private DActividades dActividades = new DActividades();
    private ArrayList<Actividades> lista = new ArrayList<>();
    //Declaramos un filtro de datos para la tabla
    TableRowSorter trsFiltro;

    private void limpiar() {
        TfId.setText("");
        TfFecha.setText("");
        TfHora.setText("");
        TaDesc.setText("");
        BtnGuardar.setEnabled(true);
        BtnEditar.setEnabled(false);
        BtnEliminar.setEnabled(false);
    }

    private void llenarArrayList() {
        if (!lista.isEmpty()) {
            lista.clear();
        }
        lista = dActividades.listarActividades();
    }

    private void llenarTabla() {
        llenarArrayList();
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String titulos[] = {"Fecha", "Hora", "Descripción"};
        dtm.setColumnIdentifiers(titulos);
        for (Actividades a : lista) {
            Object[] fila = new Object[]{
                a.getActividadID(),
                a.getFecha(),
                a.getHora(),
                a.getDescripcion()
            };
            dtm.addRow(fila);
        }
        this.TblRegistros.setModel(dtm);

    }

    private void filtrarTabla() {
        trsFiltro.setRowFilter(RowFilter.regexFilter(TfDato.getText(), 0));
    }

    private void ubicarDatos() {
        int fila = TblRegistros.getSelectedRow();
        actividadID = lista.get(fila).getActividadID();
        TfFecha.setText(lista.get(fila).getFecha());
        TfHora.setText(lista.get(fila).getHora());
        TaDesc.setText(lista.get(fila).getDescripcion());
    }

    private void verificarDatosVacios() {
        if (TfFecha.getText().equals("") || TfFecha.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por Favor verifique la fecha"
                    + "no esté vacía.", "Actividades",
                    JOptionPane.WARNING_MESSAGE);
            TfFecha.requestFocus();
        }
        if (TfHora.getText().equals("") || TfHora.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por Favor verifique el tipo"
                    + "no este vacio.", "Actividades",
                    JOptionPane.WARNING_MESSAGE);
            TfHora.requestFocus();
        }
        if (TaDesc.getText().equals("") || TaDesc.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por Favor verifique la descripción"
                    + "no esté vacía.", "Actividades",
                    JOptionPane.WARNING_MESSAGE);
            TaDesc.requestFocus();
        }
    }

    public FrmActividades() {
        initComponents();
        this.llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        TbPanel = new javax.swing.JTabbedPane();
        Datos = new javax.swing.JPanel();
        TbComandos = new javax.swing.JToolBar();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();
        Tipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TfFecha = new javax.swing.JTextField();
        TfHora = new javax.swing.JTextField();
        TaDesc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TfId = new javax.swing.JTextField();
        Registros = new javax.swing.JPanel();
        Buscar = new javax.swing.JLabel();
        TfDato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRegistros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Datos.setBackground(new java.awt.Color(159, 188, 204));

        TbComandos.setRollover(true);

        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/nuevo.png"))); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        TbComandos.add(BtnNuevo);

        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/guardar.png"))); // NOI18N
        BtnGuardar.setText("Guardar");
        BtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        TbComandos.add(BtnGuardar);

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/Editar.png"))); // NOI18N
        BtnEditar.setText("Editar");
        BtnEditar.setEnabled(false);
        BtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        TbComandos.add(BtnEditar);

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/iconos/eliminar.png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setEnabled(false);
        BtnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        TbComandos.add(BtnEliminar);

        BtnRegresar.setText("Regresar al menu");
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });

        Tipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Tipo.setText("Fecha:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hora:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        TfFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfFechaActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnRegresar)
                .addGap(361, 361, 361))
            .addGroup(DatosLayout.createSequentialGroup()
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TfFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(TfHora, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(TfId)))))
                    .addComponent(TbComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(TaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addComponent(TbComandos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipo)
                    .addComponent(TfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRegresar)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        TbPanel.addTab("Datos", Datos);

        Registros.setBackground(new java.awt.Color(157, 197, 210));

        Buscar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Buscar.setText("Buscar: ");

        TfDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfDatoActionPerformed(evt);
            }
        });
        TfDato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfDatoKeyTyped(evt);
            }
        });

        TblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblRegistros);

        javax.swing.GroupLayout RegistrosLayout = new javax.swing.GroupLayout(Registros);
        Registros.setLayout(RegistrosLayout);
        RegistrosLayout.setHorizontalGroup(
            RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrosLayout.createSequentialGroup()
                .addGroup(RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Buscar)
                        .addGap(45, 45, 45)
                        .addComponent(TfDato, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrosLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        RegistrosLayout.setVerticalGroup(
            RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrosLayout.createSequentialGroup()
                .addGroup(RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrosLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistrosLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(TfDato, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbPanel.addTab("Registros", Registros);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TbPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        // TODO add your handling code here:
        limpiar();
        TbPanel.setSelectedIndex(0);
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        try {
            Actividades a = new Actividades(0,
                    TfFecha.getText(),
                    TfHora.getText(),
                    TaDesc.getText()
            );
            if (dActividades.guardarActividades(a)) {
                JOptionPane.showMessageDialog(this, "Registro Guardado.",
                        "Actividades", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla();
                TbPanel.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar",
                        "Actividades", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException ex) {
            System.out.println("Error al intentar guardar: " + ex.getMessage());
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed


    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        Actividades a = new Actividades(
                actividadID,
                TfFecha.getText(),
                TfHora.getText(),
                TaDesc.getText()
        );
        if (dActividades.editarActividades(a)){
                JOptionPane.showMessageDialog(this, "Resgistro Editado.",
                        "Actividades", JOptionPane.WARNING_MESSAGE);
                llenarTabla();
                TbPanel.setSelectedIndex(1);
            } else{
                JOptionPane.showMessageDialog(this, "Error al editar",
                        "Actividades", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void TfDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfDatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfDatoActionPerformed

    private void TblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblRegistrosMouseClicked
        // TODO add your handling code here:
        TblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseCLicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ubicarDatos();
                }
            }
        });


    }//GEN-LAST:event_TblRegistrosMouseClicked

    private void TfDatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfDatoKeyTyped
        // TODO add your handling code here:
        TfDato.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                filtrarTabla();
            }
        });
        trsFiltro = new TableRowSorter(TblRegistros.getModel());
        TblRegistros.setRowSorter(trsFiltro);
    }//GEN-LAST:event_TfDatoKeyTyped

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        int resp = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este registro?",
                "Voluntariado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == 0) {
            if (dActividades.eliminarActividades(actividadID)) {
                JOptionPane.showMessageDialog(this, "Registro eliminado satisfactoriamente",
                        "Voluntariado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        llenarTabla();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TfFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfFechaActionPerformed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        FrmUsuario regresar = new FrmUsuario();
        regresar.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FrmActividades frm = new FrmActividades();
        frm.setVisible(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmActividades().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JLabel Buscar;
    private javax.swing.JPanel Datos;
    private javax.swing.JPanel Registros;
    private javax.swing.JTextField TaDesc;
    private javax.swing.JToolBar TbComandos;
    private javax.swing.JTabbedPane TbPanel;
    private javax.swing.JTable TblRegistros;
    private javax.swing.JTextField TfDato;
    private javax.swing.JTextField TfFecha;
    private javax.swing.JTextField TfHora;
    private javax.swing.JTextField TfId;
    private javax.swing.JLabel Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
