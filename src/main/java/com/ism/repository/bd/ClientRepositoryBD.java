package com.ism.repository.bd;

import java.util.List;
import java.util.ArrayList;
import com.ism.entities.Client;
import com.ism.repository.ClientRepository;
import java.sql.*;

public class ClientRepositoryBD extends RepositoryBDImpl<Client> implements ClientRepository {
    @Override
    public Client selectByTelephone(String telephone) {
        PreparedStatement ps;
        Connection conn = null;
        Client client = null;
        // 1-OuvreConnexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/gestion_dette_glrs_2024", "root", "root");
            String sql = "select * from client where telephone like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, telephone);
            // ORM
            ResultSet rs = ps.executeQuery(
                
            );
            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone"));
                client.setAdresse(rs.getString("adresse"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public Client selectBySurname(String surname) {
        return null;
    }

    @Override
    public void insert(Client data) {
        PreparedStatement stmt;
        Connection conn = null;
        // 1-OuvreConnexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/gestion_dette_glrs_2024", "root", "root");
            String sql = "INSERT INTO `client` (`surname`, `telephone`, `adresse`) VALUES (?,?,?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, data.getSurname());
            stmt.setString(2, data.getTelephone());
            stmt.setString(3, data.getAdresse());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // System.out.println("Erreur Execution : " +);
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {

            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        // Variable
        // 2-Execute Requete

        // 3-Ferme Connexion

    }

    @Override
    public List<Client> selectAll() {
        Statement stmt;
        Connection conn = null;
        List<Client> clients = new ArrayList<Client>();
        // 1-OuvreConnexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/gestion_dette_glrs_2024", "root", "root");
            stmt = conn.createStatement();
            String sql = "select * from client";
            // ORM
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone"));
                client.setAdresse(rs.getString("adresse"));
                clients.add(client);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return clients;
    }
}
