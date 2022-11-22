package com.lufegaba75.repositorio;

import com.lufegaba75.modelo.ConexionBD;
import com.lufegaba75.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario>{

    public static Connection getConnection() throws SQLException {
            return ConexionBD.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")){
            while(rs.next()){
                Usuario u  = crearUsuario(rs);
                usuarios.add(u);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void guardar(Usuario usuario) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO usuarios(username, password, email) VALUES(?,?,?)")){
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();

        }
//"INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)"
    }

    @Override
    public void actualizar(Usuario usuario) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE usuarios SET username=?, password=?, email=? WHERE id=?")){
            stmt.setLong(4, usuario.getId());
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();

        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "DELETE * FROM usuarios WHERE id=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private static Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getLong("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        return u;
    }
}
//private static Producto crearProducto(ResultSet rs) throws SQLException {
//        Producto p = new Producto();
//        p.setId(rs.getLong("id"));
//        p.setNombre(rs.getString("nombre"));
//        p.setPrecio(rs.getLong("precio"));
//        p.setFechaRegistro(rs.getDate("fecha_registro"));
//        Categoria categoria = new Categoria();
//        categoria.setId(rs.getLong("categoria_id"));
//        categoria.setNombre(rs.getString("categoria"));
//        p.setCategoria(categoria);
//        return p;
//    }