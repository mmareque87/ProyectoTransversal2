/*

 */
package AccesoDatos;

import java.sql.Connection;
import Entidades.Alumno;
import Entidades.Materia;
import Entidades.Inscripcion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private AlumnoData aluData;
    private MateriaData mateData;

    public InscripcionData() {

        con = Conexion.getConexion();
        aluData = new AlumnoData();
        mateData = new MateriaData();
    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion (idAlumno, idMateria) VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, insc.getAlumno().getIdAlumno());
            System.out.println(insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            System.out.println(insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Inscripcion " + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscList = new ArrayList<>();
        inscList.clear();
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setMateria(mateData.buscarMateria(rs.getInt("idMateria")));
                inscripcion.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
                inscripcion.setNota(rs.getDouble("nota"));
                inscList.add(inscripcion);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return inscList;

    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();
        materias.clear();

        try {
            String sql = "SELECT inscripcion.idMateria,nombre, anio FROM inscripcion, materia WHERE inscripcion.idMateria=materia.idMateria\n"
                    + "AND inscripcion.idAlumno=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;

            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("Anio"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripcion" + ex.getMessage());
        }
        return materias;
    }
///// a hequear con los videos y teorias >>>>>>

    public List<Inscripcion> obtenerInscripcionesXalumno(int id) {
        InscripcionData inscrdata = new InscripcionData();
        List<Inscripcion> inscList = new ArrayList<>();
        //inscList = inscrdata.obtenerInscripciones();
        inscList.addAll(inscrdata.obtenerInscripciones());

        List<Inscripcion> inscListAlumno = new ArrayList<>();
        inscListAlumno.clear();

        for (Inscripcion inscripcion : inscList) {
            if (inscripcion.getAlumno().getIdAlumno() == id) {
                inscListAlumno.add(inscripcion);
            }
        }
        if (inscList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encuentra Alumno con ese ID");
        }
        return inscListAlumno;
    }

    public List<Materia> obtenerMateriasNoCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();
        materias.clear();

        try {
            String sql = "SELECT* FROM materia WHERE activo=1 AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno=?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;

            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("Anio"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripcion" + ex.getMessage());
        }
        return materias;
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);

            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "Error de parametros:no existe el ID de alumno o materia");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Nota : " + ex.getMessage());
        }

    }

    public List<Alumno> obtenerAlumnosXMaterias(int idMateria) {
        List<Alumno> materiasCursadas = new ArrayList<>();

        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, activo FROM inscripcion i, alumno a WHERE i.idAlumno=a.idAlumno AND idMateria=? AND a.activo=1";
        try {
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
//        if (!rs.next()){
//            JOptionPane.showMessageDialog(null, "La Materia no existe");
//        }
            while (rs.next()) {
                Alumno alu = new Alumno();
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setNombre(rs.getString("nombre"));
                alu.setApellido(rs.getString("apellido"));
                alu.setDni(rs.getInt("dni"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setActivo(rs.getBoolean("activo"));
                materiasCursadas.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo la tabla alumno" + ex.getMessage());
        }
        return materiasCursadas;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        //String sql = "DELETE FROM inscripcion WHERE idAlumno =  ? AND  idMateria =  ?";
        String sql = "DELETE FROM inscripcion WHERE idAlumno =  ? AND  idMateria =  ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Se borro la inscripcion seleccionada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se obtuvo la tabla Inscripcion" + ex.getMessage());
        }
    }
}
