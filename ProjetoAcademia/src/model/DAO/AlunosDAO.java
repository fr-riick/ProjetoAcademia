/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.bean.Alunos;
import java.sql.ResultSet;

/**
 *
 * @author rickf
 */
public class AlunosDAO {
    private ConnectionFactory connection;
    private Connection conn;
    
    public AlunosDAO(){
        this.connection = new ConnectionFactory();
        this.conn = this.connection.getConnection();
    }
    
    public void inserir(Alunos alunos){
        String sql = "INSERT INTO alunos(nome, sobrenome, cpf, idade, mensalidade, multa, rua, cep, numero, estado, cidade, bairro, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getSobrenome());
            stmt.setString(3, alunos.getCpf());
            stmt.setInt(4,alunos.getIdade());
            stmt.setString(5, alunos.getMensalidade());
            stmt.setFloat(6, alunos.getMulta());
            stmt.setString(7, alunos.getRua());
            stmt.setString(8, alunos.getCep());
            stmt.setInt(9, alunos.getNumero()); 
            stmt.setString(10, alunos.getEstado());
            stmt.setString(11, alunos.getCidade());
            stmt.setString(12, alunos.getBairro());
            stmt.setString(13, alunos.getTelefone());          
            stmt.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }
    
    public void editar(Alunos alunos){
        String sql = "UPDATE alunos SET nome=?, sobrenome=?, cpf=?, idade=?, mensalidade=?, multa=?, rua=?, cep=?, numero=?, estado=?, cidade=?, bairro=?, telefone=? WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getSobrenome());
            stmt.setString(3, alunos.getCpf());
            stmt.setInt(4,alunos.getIdade());
            stmt.setString(5, alunos.getMensalidade());
            stmt.setFloat(6, alunos.getMulta());
            stmt.setString(7, alunos.getRua());
            stmt.setString(8, alunos.getCep());
            stmt.setInt(9, alunos.getNumero()); 
            stmt.setString(10, alunos.getEstado());
            stmt.setString(11, alunos.getCidade());
            stmt.setString(12, alunos.getBairro());
            stmt.setString(13, alunos.getTelefone());
            stmt.setString(14, alunos.getCpf());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
    }
    
    public void excluir(String cpf){
        String sql = "DELETE FROM alunos WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        }
    }
   
    
    public Alunos getAluno(String cpf){
        String sql = "SELECT * FROM alunos WHERE cpf = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Alunos aluno = new Alunos();
            rs.first();
            
            aluno.setNome(rs.getString("nome"));
            aluno.setSobrenome(rs.getString("sobrenome"));
            aluno.setCpf(cpf);
            aluno.setIdade(rs.getInt("idade"));
            aluno.setMensalidade(rs.getString("mensalidade"));
            aluno.setMulta(rs.getFloat("multa"));
            aluno.setRua(rs.getString("Rua"));
            aluno.setCep(rs.getString("cep"));
            aluno.setNumero(rs.getInt("numero"));
            aluno.setEstado(rs.getString("estado"));
            aluno.setCidade(rs.getString("cidade"));
            aluno.setBairro(rs.getString("bairro"));
            aluno.setTelefone(rs.getString("telefone"));
            return aluno;
            
        } catch (Exception e) {
            return null;
            }
    }
    
}
