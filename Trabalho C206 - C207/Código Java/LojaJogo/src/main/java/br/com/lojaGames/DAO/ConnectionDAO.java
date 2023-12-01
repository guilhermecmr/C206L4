package br.com.lojaGames.DAO;

import java.sql.*;

//classe abstrata para gerenciar conexões com bancos de dados
public abstract class ConnectionDAO
{
    //membros de conexão com o banco de dados
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    //parâmetros de conexão com o banco de dados
    String database = "lojaGames";
    String user = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    //método para estabelecer uma conexão com o banco de dados
    public void connectToDB()
    {
        //tentativa de estabelecer uma conexão
        try
        {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        }

        //exibe mensagem de erro se a conexão falhar
        catch (SQLException exc)
        {
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}