/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.bean.Convidados;

/**
 *
 * @author rickf
 */
public class ConvidadosDAO {
    private ConnectionFactory connection;
    private Connection conn;
    
    public ConvidadosDAO(){
        this.connection = new ConnectionFactory();
        this.conn = this.connection.getConnection();
    }
    
    public void inserir(Convidados convidados){
        String sql = "INSERT INTO convidados(nome, sobrenome, cpf, diaria, rua, cep, numero, estado, cidade, bairro, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, convidados.getNome());
            stmt.setString(2, convidados.getSobrenome());
            stmt.setString(3, convidados.getCpf());
            stmt.setString(4, convidados.getDiaria());
            stmt.setString(5, convidados.getRua());
            stmt.setString(6, convidados.getCep());
            stmt.setInt(7, convidados.getNumero()); 
            stmt.setString(8, convidados.getEstado());
            stmt.setString(9, convidados.getCidade());
            stmt.setString(10, convidados.getBairro());
            stmt.setString(11, convidados.getTelefone());          
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    
    public void editar(Convidados convidados){
        String sql = "UPDATE convidados SET nome=?, sobrenome=?, cpf=?, diaria=?, rua=?, cep=?, numero=?, estado=?, cidade=?, bairro=?, telefone=? WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, convidados.getNome());
            stmt.setString(2, convidados.getSobrenome());
            stmt.setString(3, convidados.getCpf());
            stmt.setString(4, convidados.getDiaria());
            stmt.setString(5, convidados.getRua());
            stmt.setString(6, convidados.getCep());
            stmt.setInt(7, convidados.getNumero()); 
            stmt.setString(8, convidados.getEstado());
            stmt.setString(9, convidados.getCidade());
            stmt.setString(10, convidados.getBairro());
            stmt.setString(11, convidados.getTelefone()); 
            stmt.setString(12, convidados.getCpf());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
    }
    
    public void excluir(String cpf){
        String sql = "DELETE FROM convidados WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar convidado: " + e.getMessage());
        }
    }
    
    public Convidados getConvidado(String cpf){
        String sql = "SELECT * FROM convidados WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Convidados convidado = new Convidados();
            rs.first();
            
            convidado.setNome(rs.getString("nome"));
            convidado.setSobrenome(rs.getString("sobrenome"));
            convidado.setCpf(cpf);
            convidado.setDiaria(rs.getString("diaria"));
            convidado.setRua(rs.getString("Rua"));
            convidado.setCep(rs.getString("cep"));
            convidado.setNumero(rs.getInt("numero"));
            convidado.setEstado(rs.getString("estado"));
            convidado.setCidade(rs.getString("cidade"));
            convidado.setBairro(rs.getString("bairro"));
            convidado.setTelefone(rs.getString("telefone"));
            return convidado;
            
        } catch (Exception e) {
            return null;
            }
    }
    
}
