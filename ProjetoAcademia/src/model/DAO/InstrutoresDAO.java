/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.bean.Funcionarios;
import model.bean.Instrutores;
/**
 *
 * @author rickf
 */
public class InstrutoresDAO {
    private ConnectionFactory connection;
    private Connection conn;
    
    public InstrutoresDAO(){
        this.connection = new ConnectionFactory();
        this.conn = this.connection.getConnection();
    }
    
    public void inserir(Instrutores instrutores){
        String sql = "INSERT INTO instrutores(nome, sobrenome, cpf, salario, rua, cep, numero, estado, cidade, bairro, telefone, horastrab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, instrutores.getNome());
            stmt.setString(2, instrutores.getSobrenome());
            stmt.setString(3, instrutores.getCpf());
            stmt.setFloat(4, instrutores.getSalario());
            stmt.setString(5, instrutores.getRua());
            stmt.setString(6, instrutores.getCep());
            stmt.setInt(7, instrutores.getNumero()); 
            stmt.setString(8, instrutores.getEstado());
            stmt.setString(9, instrutores.getCidade());
            stmt.setString(10, instrutores.getBairro());
            stmt.setString(11, instrutores.getTelefone()); 
            stmt.setInt(12, instrutores.getHorastrab());
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    
    public void editar(Instrutores instrutores){
        String sql = "UPDATE instrutores SET nome=?, sobrenome=?, cpf=?, salario=?, rua=?, cep=?, numero=?, estado=?, cidade=?, bairro=?, telefone=?, horastrab=? WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, instrutores.getNome());
            stmt.setString(2, instrutores.getSobrenome());
            stmt.setString(3, instrutores.getCpf());
            stmt.setFloat(4, instrutores.getSalario());
            stmt.setString(5, instrutores.getRua());
            stmt.setString(6, instrutores.getCep());
            stmt.setInt(7, instrutores.getNumero()); 
            stmt.setString(8, instrutores.getEstado());
            stmt.setString(9, instrutores.getCidade());
            stmt.setString(10, instrutores.getBairro());
            stmt.setString(11, instrutores.getTelefone()); 
            stmt.setInt(12, instrutores.getHorastrab());
            stmt.setString(13, instrutores.getCpf());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
    }
    
    public void excluir(String cpf){
        String sql = "DELETE FROM instrutores WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar instrutor: " + e.getMessage());
        }
    }
    
    
    public Instrutores getInstrutor(String cpf){
        String sql = "SELECT * FROM instrutores WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Instrutores instrutor = new Instrutores();
            rs.first();
            
            instrutor.setNome(rs.getString("nome"));
            instrutor.setSobrenome(rs.getString("sobrenome"));
            instrutor.setCpf(cpf);
            instrutor.setSalario(rs.getFloat("salario"));
            instrutor.setRua(rs.getString("Rua"));
            instrutor.setCep(rs.getString("cep"));
            instrutor.setNumero(rs.getInt("numero"));
            instrutor.setEstado(rs.getString("estado"));
            instrutor.setCidade(rs.getString("cidade"));
            instrutor.setBairro(rs.getString("bairro"));
            instrutor.setTelefone(rs.getString("telefone"));
            instrutor.setHorastrab(rs.getInt("horastrab"));
            return instrutor;
            
        } catch (Exception e) {
            return null;
            }
    }
}
