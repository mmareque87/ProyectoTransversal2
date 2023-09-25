/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import AccesoDatos.AlumnoData;
import AccesoDatos.InscripcionData;
import AccesoDatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class FormularioInscripcion extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public FormularioInscripcion() {
        initComponents();
        armarCabecera();
        cargarCombo();
        limpiarTabla();
        jrbInscripto.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jrbInscripto = new javax.swing.JRadioButton();
        jrbNoInscripto = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un alumno: ");

        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        jrbInscripto.setText("Materias Inscriptas");
        jrbInscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInscriptoActionPerformed(evt);
            }
        });

        jrbNoInscripto.setText("Materias No Inscriptas");
        jrbNoInscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNoInscriptoActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado de Materias");

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtMaterias);

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnularInscripcion.setText("Anular Inscrpcion");
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(jcbAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jrbInscripto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jrbNoInscripto)))
                                .addGap(30, 30, 30)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbInscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAnularInscripcion)
                        .addGap(137, 137, 137)
                        .addComponent(jbSalir)
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbInscripto)
                    .addComponent(jrbNoInscripto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbSalir))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInscriptoActionPerformed
        jbInscribir.setEnabled(false);
        jrbNoInscripto.setSelected(false);
        limpiarTabla();
        InscripcionData id = new InscripcionData();
        MateriaData md = new MateriaData();
        Alumno alumnoSele = (Alumno) jcbAlumnos.getSelectedItem();
        
        List<Materia> listaMaterias = id.obtenerMateriasCursadas(alumnoSele.getIdAlumno());
        // modelo.setRowCount(listaMaterias.size());
        for (Materia listaMateria : listaMaterias) {
            modelo.addRow(new Object[]{
                listaMateria.getIdMateria(),
                listaMateria.getNombre(),
                listaMateria.getAnio(),});
        }
        

    }//GEN-LAST:event_jrbInscriptoActionPerformed

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        
        AlumnoData ad = new AlumnoData();
        InscripcionData id = new InscripcionData();
        Alumno alumnoSele = (Alumno) jcbAlumnos.getSelectedItem();
        
        if (jrbInscripto.isSelected()) {
            jrbInscriptoActionPerformed(evt);
            
        } else {
            jrbNoInscriptoActionPerformed(evt);
        }

//        String rubroSeleccionado = (String) jcbRubro.getSelectedItem();
//        borraFilas();
//        for(Producto produc: Menu.listaProductos){
//            
//            if(produc.getRubro().toString().equalsIgnoreCase(rubroSeleccionado)){
//                
//                modelo.addRow(new Object[]{
//                    produc.getCodigo(),
//                    produc.getDescripcion(),
//                    produc.getPrecio(),
//                    produc.getStock(),
//                });
    }//GEN-LAST:event_jcbAlumnosActionPerformed

    private void jrbNoInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNoInscriptoActionPerformed
        jbInscribir.setEnabled(true);
        jrbInscripto.setSelected(false);
        limpiarTabla();
        InscripcionData id = new InscripcionData();
        MateriaData md = new MateriaData();
        Alumno alumnoSele = (Alumno) jcbAlumnos.getSelectedItem();
        
        List<Materia> listaMaterias = id.obtenerMateriasNoCursadas(alumnoSele.getIdAlumno());
        
        for (Materia listaMateria : listaMaterias) {
            
            modelo.addRow(new Object[]{
                listaMateria.getIdMateria(),
                listaMateria.getNombre(),
                listaMateria.getAnio(),});
        }
    }//GEN-LAST:event_jrbNoInscriptoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
        try {
            
            Alumno alumnoSel = (Alumno) jcbAlumnos.getSelectedItem();
            int columnaSel = jtMaterias.getSelectedRow();
            
            int idMateria = (Integer) modelo.getValueAt(columnaSel, 0);
            InscripcionData id = new InscripcionData();

// pregunta de confirmacion                
            int input = JOptionPane.showConfirmDialog(null, "Esta seguro desea borrar la Inscricpcion del Alumno: " + alumnoSel.getDni() + " > En la Materia ID: " + idMateria + "?", "Seleccione una opcion...",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == 0) {
                id.borrarInscripcionMateriaAlumno(alumnoSel.getIdAlumno(), idMateria);
                jcbAlumnosActionPerformed(evt);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe selecionar del Alumno una materia que este inscripto");
        }
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        try {
            
            Alumno alumnoSel = (Alumno) jcbAlumnos.getSelectedItem();
            int columnaSel = jtMaterias.getSelectedRow();
            int idMat = (Integer) modelo.getValueAt(columnaSel, 0);
            
            MateriaData md = new MateriaData();
            Materia materiaSel = md.buscarMateria(idMat);
            
            Inscripcion nueva = new Inscripcion(alumnoSel, materiaSel);
            InscripcionData id = new InscripcionData();

            // pregunta de confirmacion                
            int input = JOptionPane.showConfirmDialog(null, "Esta seguro desea Inscricbir al Alumno: " + alumnoSel.getDni() + " > En la Materia: " + materiaSel.getNombre() + "?", "Seleccione una opcion...",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            if (input == 0) {
                id.guardarInscripcion(nueva);
                
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una materia No-Iscripta del Alumno ");
        }
    }//GEN-LAST:event_jbInscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumnos;
    private javax.swing.JRadioButton jrbInscripto;
    private javax.swing.JRadioButton jrbNoInscripto;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jtMaterias.setModel(modelo);
    }
    
    private void limpiarTabla() {
        int f = modelo.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
    
    private void cargarCombo() {
        AlumnoData ad = new AlumnoData();
        List<Alumno> listaAlumno = new ArrayList<>();
        listaAlumno = ad.listarAlumnos();
        
        for (Alumno alumno : listaAlumno) {
            jcbAlumnos.addItem(alumno);
        }
        
    }
}
