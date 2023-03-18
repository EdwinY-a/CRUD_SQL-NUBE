package com.example.examen_mysql;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContollerAutomovil {

    @FXML
    TextField txtIdAutomovil;
    @FXML
    TextField txtMarca;
    @FXML
    TextField txtNacionalidad;
    @FXML
    TextField txModelo;
    @FXML
    TextField txtPrecio;
    @FXML
    TextField txtTransmicion;
    @FXML
    TextField txtCilindraje;
    @FXML
    TextField txtTipo;
    @FXML
    Button btnSave;
    @FXML
    Button btnUpdate;
    @FXML
    Button btnShow;
    @FXML
    Button btnDelete;
    @FXML
    Label lblResult;

    public void save() throws SQLException {
        lblResult.setText("Los datos se estan guardando o hubo un error");
        String sql="INSERT INTO Automovil(idAutomovil, pais, precio , marca , " +
                "modelo, trasmision, cilindraje, tipo) " +
                "VALUES(?, ?, ?, ?, ?, ?,?,?);";
        ConexionSQL connMySQL=new ConexionSQL();
        Connection conn=connMySQL.open();
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(txtIdAutomovil.getText()));
        pstm.setString(2, txtNacionalidad.getText());
        pstm.setString(3, txtPrecio.getText());
        pstm.setString(4, txtMarca.getText());
        pstm.setString(5, txModelo.getText());
        pstm.setString(6, txtTransmicion.getText());
        pstm.setString(7, txtCilindraje.getText());
        pstm.setString(8, txtTipo.getText());
        pstm.executeUpdate();
        pstm.close();
        connMySQL.close();
        lblResult.setText("Los datos se guardaron con exito.");
    }

    public void update() throws SQLException{
        lblResult.setText("Los datos se estan actualizando o hubo un error.");
        String sql="UPDATE Automovil" +
                " SET pais=?, precio=?, marca=?, modelo=?, trasmision=?, cilindraje=?, tipo=?" +
                " WHERE idAutomovil=?;";
        ConexionSQL connMySQL=new ConexionSQL();
        Connection conn= connMySQL.open();
        PreparedStatement pstm= conn.prepareStatement(sql);
        pstm.setString(1, txtNacionalidad.getText());
        pstm.setString(2, txtPrecio.getText());
        pstm.setString(3, txtMarca.getText());
        pstm.setString(4, txModelo.getText());
        pstm.setString(5, txtTransmicion.getText());
        pstm.setString(6, txtCilindraje.getText());
        pstm.setString(7, txtTipo.getText());
        pstm.setInt(8, Integer.parseInt(txtIdAutomovil.getText()));
        pstm.executeUpdate();
        pstm.close();
        connMySQL.close();
        lblResult.setText("Los datos se actualizaron con exito");
    }

    public void show() throws SQLException{
        lblResult.setText("Los datos se estan consultando o hubo un error.");
        String sql="SELECT * FROM Automovil;";
        ConexionSQL connMySQL=new ConexionSQL();
        Connection conn= connMySQL.open();
        PreparedStatement pstm= conn.prepareStatement(sql);
        ResultSet rs= pstm.executeQuery();
        Automovil auto =new Automovil();
        while(rs.next()){
            auto.setIdAutomovil(rs.getInt("idAutomovil"));
            auto.setPais(rs.getString("pais"));
            auto.setPrecio(rs.getString("precio"));
            auto.setMarca(rs.getString("marca"));
            auto.setModelo(rs.getString("modelo"));
            auto.setTrasmision(rs.getString("trasmision"));
            auto.setCilindraje(rs.getString("cilindraje"));
            auto.setTipo(rs.getString("tipo"));

            System.out.println("idAutomovil: "+auto.getIdAutomovil());
            System.out.println("pais: "+auto.getPais());
            System.out.println("precio: "+auto.getPrecio());
            System.out.println("marca: "+auto.getMarca());
            System.out.println("modelo: "+auto.getModelo());
            System.out.println("trasmision: "+auto.getTrasmision());
            System.out.println("cilindraje: "+auto.getCilindraje());
            System.out.println("tipo: "+auto.getTipo());
            System.out.println("-------------------------------------------------------");
        }
        rs.close();
        pstm.close();
        connMySQL.close();
        lblResult.setText("Los datos fueron mostrados en la consola de manera correcta.");
    }

    public void delete() throws SQLException{
        lblResult.setText("El registro se esta eliminando o hubo un error");
        String sql="DELETE FROM Automovil WHERE idAutomovil=?;";
        ConexionSQL connMySQL=new ConexionSQL();
        Connection conn=connMySQL.open();
        PreparedStatement pstm= conn.prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(txtIdAutomovil.getText()));
        pstm.executeUpdate();
        pstm.close();
        connMySQL.close();
        lblResult.setText("El registro se elimino con exito.");
    }
}
