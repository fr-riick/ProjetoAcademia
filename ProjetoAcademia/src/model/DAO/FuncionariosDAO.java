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

/**
 *
 * @author rickf
 */
public class FuncionariosDAO {
    
    private ConnectionFactory connection;
    private Connection conn;
    
    public FuncionariosDAO(){
        this.connection = new ConnectionFactory();
        this.conn = this.connection.getConnection();
    }
    
    public void inserir(Funcionarios funcionarios){
        String sql = "INSERT INTO funcionarios(nome, sobrenome, cpf, salario, funcao, rua, cep, numero, estado, cidade, bairro, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionarios.getNome());
            stmt.setString(2, funcionarios.getSobrenome());
            stmt.setString(3, funcionarios.getCpf());
            stmt.setFloat(4, funcionarios.getSalario());
            stmt.setString(5, funcionarios.getFuncao());
            stmt.setString(6, funcionarios.getRua());
            stmt.setString(7, funcionarios.getCep());
            stmt.setInt(8, funcionarios.getNumero()); 
            stmt.setString(9, funcionarios.getEstado());
            stmt.setString(10, funcionarios.getCidade());
            stmt.setString(11, funcionarios.getBairro());
            stmt.setString(12, funcionarios.getTelefone());          
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    
    public void editar(Funcionarios funcionarios){
        String sql = "UPDATE funcionarios SET nome=?, sobrenome=?, cpf=?, salario=?, funcao=?, rua=?, cep=?, numero=?, estado=?, cidade=?, bairro=?, telefone=? WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionarios.getNome());
            stmt.setString(2, funcionarios.getSobrenome());
            stmt.setString(3, funcionarios.getCpf());
            stmt.setFloat(4, funcionarios.getSalario());
            stmt.setString(5, funcionarios.getFuncao());
            stmt.setString(6, funcionarios.getRua());
            stmt.setString(7, funcionarios.getCep());
            stmt.setInt(8, funcionarios.getNumero()); 
            stmt.setString(9, funcionarios.getEstado());
            stmt.setString(10, funcionarios.getCidade());
            stmt.setString(11, funcionarios.getBairro());
            stmt.setString(12, funcionarios.getTelefone()); 
            stmt.setString(13, funcionarios.getCpf());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
    }
    
    public void excluir(String cpf){
        String sql = "DELETE FROM funcionarios WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar funcionario: " + e.getMessage());
        }
    }
    
    public Funcionarios getFuncionario(String cpf){
        String sql = "SELECT * FROM funcionarios WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Funcionarios funcionario = new Funcionarios();
            rs.first();
            
            funcionario.setNome(rs.getString("nome"));
            funcionario.setSobrenome(rs.getString("sobrenome"));
            funcionario.setCpf(cpf);
            funcionario.setSalario(rs.getFloat("salario"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setRua(rs.getString("Rua"));
            funcionario.setCep(rs.getString("cep"));
            funcionario.setNumero(rs.getInt("numero"));
            funcionario.setEstado(rs.getString("estado"));
            funcionario.setCidade(rs.getString("cidade"));
            funcionario.setBairro(rs.getString("bairro"));
            funcionario.setTelefone(rs.getString("telefone"));
            return funcionario;
            
        } catch (Exception e) {
            return null;
            }
    }
}
