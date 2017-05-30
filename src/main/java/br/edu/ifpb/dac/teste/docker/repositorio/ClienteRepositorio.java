/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.teste.docker.repositorio;

import br.edu.ifpb.dac.teste.docker.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose2
 */
public class ClienteRepositorio {

    Connection getConnection() throws SQLException{
         String driver = "org.postgresql.Driver";
         //banco local
           // String url = "jdbc:postgresql://localhost:5432/teste-docker";
             String url = "jdbc:postgresql://bd:5432/teste-docker";
            String user = "postgres";
            String password = "123456";
          return DriverManager.getConnection(url, user, password);
    }

    public List<Cliente> todos() {
          PreparedStatement stat = null;
        try {
            stat = getConnection().prepareStatement("SELECT * FROM cliente");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            List<Cliente> clientes = new ArrayList<>();
          ResultSet result = stat.executeQuery();
            while (result.next()) {
                clientes.add(montarCliente(result));
            }
            return clientes;
        } catch (SQLException ex) {
            System.err.println("erro bd "+ex);
        }
        return Collections.EMPTY_LIST;
    }

    private Cliente montarCliente(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String email = result.getString("email");
        return new Cliente(id, nome, email);
    }
}
