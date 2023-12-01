package br.com.lojaGames.DAO;

import br.com.lojaGames.produtos.*;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.lojaGames.dadoscadastrais.*;

public class UserDAO extends ConnectionDAO
{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertJogoFisico(Fisico jogo)
    {
        connectToDB();
        String sql = "INSERT INTO MidiaFisica(nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, usado) values (?,?,?,?,?,?,?,?)";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogo.getNome());
            pst.setString(2, jogo.getCodigoDeBarra());
            pst.setInt(3, jogo.getEstoque());
            pst.setFloat(4, jogo.getPreco());
            pst.setByte(5, jogo.getClassificacaoIndicativa());
            pst.setString(6, jogo.getEstudio());
            pst.setString(7, jogo.getConsole());
            pst.setBoolean(8, jogo.isUsado());
            pst.execute();
            sucesso = true;
        }

        catch (SQLException exc)
        {
            System.out.println("\nErro: " + exc.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("\nErro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean insertJogoDigital(Digital jogo)
    {
        connectToDB();

        String sql = "INSERT INTO MidiaDigital(nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, anoExpiracao) values (?,?,?,?,?,?,?,?)";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogo.getNome());
            pst.setString(2, jogo.getCodigoDeBarra());
            pst.setInt(3, jogo.getEstoque());
            pst.setFloat(4, jogo.getPreco());
            pst.setByte(5, jogo.getClassificacaoIndicativa());
            pst.setString(6, jogo.getEstudio());
            pst.setString(7, jogo.getConsole());
            pst.setInt(8, jogo.getAnoExpiracao());
            pst.execute();
            sucesso = true;
        }

        catch (SQLException exc)
        {
            System.out.println("\nErro: " + exc.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("\nErro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean insertJogoColecionador(Colecionador jogo)
    {
        connectToDB();

        String sql = "INSERT INTO EdicaoColecionador(nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, figure, steelbook, ost) values (?,?,?,?,?,?,?,?,?,?)";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogo.getNome());
            pst.setString(2, jogo.getCodigoDeBarra());
            pst.setInt(3, jogo.getEstoque());
            pst.setFloat(4, jogo.getPreco());
            pst.setByte(5, jogo.getClassificacaoIndicativa());
            pst.setString(6, jogo.getEstudio());
            pst.setString(7, jogo.getConsole());
            pst.setBoolean(8, jogo.isFigure());
            pst.setBoolean(9, jogo.isSteelBook());
            pst.setBoolean(10, jogo.isOst());
            pst.execute();
            sucesso = true;
        }

        catch (SQLException exc)
        {
            System.out.println("\nErro: " + exc.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("\nErro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean insertBoneco(Boneco boneco)
    {
        connectToDB();

        String sql = "INSERT INTO Boneco(nome, codigoDeBarra, estoque, preco, tamanho) values (?,?,?,?,?)";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, boneco.getNome());
            pst.setString(2, boneco.getCodigoDeBarra());
            pst.setInt(3, boneco.getEstoque());
            pst.setFloat(4, boneco.getPreco());
            pst.setInt(5, boneco.getTamanho());
            pst.execute();
            sucesso = true;
        }

        catch (SQLException exc)
        {
            System.out.println("\nErro: " + exc.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("\nErro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean insertCliente(Cliente cliente)
    {
        connectToDB();

        String sql = "INSERT INTO Cliente(nome, telefone, id_Vendedor) values (?,?,?)";

        try
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getTelefone());
            pst.setInt(3, cliente.getIdVendedor());
            pst.execute();
            sucesso = true;
        }

        catch (SQLException exc)
        {
            System.out.println("\nErro: " + exc.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("\nErro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    //UPDATE
    public boolean updateEstoque(String codigoDeBarra, int novoEstoque)
    {
        connectToDB();

        try
        {
            con.setAutoCommit(false);

            // Update na tabela MidiaFisica
            String sqlMidiaFisica = "UPDATE MidiaFisica SET estoque=? WHERE codigoDeBarra=?";
            pst = con.prepareStatement(sqlMidiaFisica);
            pst.setInt(1, novoEstoque);
            pst.setString(2, codigoDeBarra);
            pst.executeUpdate();

            // Update na tabela MidiaDigital
            String sqlMidiaDigital = "UPDATE MidiaDigital SET estoque=? WHERE codigoDeBarra=?";
            pst = con.prepareStatement(sqlMidiaDigital);
            pst.setInt(1, novoEstoque);
            pst.setString(2, codigoDeBarra);
            pst.executeUpdate();

            // Update na tabela EdicaoColecionador
            String sqlEdicaoColecionador = "UPDATE EdicaoColecionador SET estoque=? WHERE codigoDeBarra=?";
            pst = con.prepareStatement(sqlEdicaoColecionador);
            pst.setInt(1, novoEstoque);
            pst.setString(2, codigoDeBarra);
            pst.executeUpdate();

            // Update na tabela Boneco
            String sqlBoneco = "UPDATE Boneco SET estoque=? WHERE codigoDeBarra=?";
            pst = con.prepareStatement(sqlBoneco);
            pst.setInt(1, novoEstoque);
            pst.setString(2, codigoDeBarra);
            pst.executeUpdate();

            con.commit();
            sucesso = true;
        }

        catch (SQLException ex)
        {
            try
            {
                con.rollback();
            }

            catch (SQLException rollbackEx)
            {
                System.out.println("Erro no rollback: " + rollbackEx.getMessage());
            }

            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.setAutoCommit(true);
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public void updateBonus(int id, float bonus)
    {
        connectToDB();

        try
        {
            con.setAutoCommit(false);

            // Update na tabela MidiaFisica
            String sqlMidiaFisica = "UPDATE Vendedor SET bonus = ? WHERE id=?";
            pst = con.prepareStatement(sqlMidiaFisica);
            pst.setFloat(1, bonus);
            pst.setInt(2, id);
            pst.executeUpdate();

            con.commit();
        }

        catch (SQLException ex)
        {
            try
            {
                con.rollback();
            }

            catch (SQLException rollbackEx)
            {
                System.out.println("Erro no rollback: " + rollbackEx.getMessage());
            }

            System.out.println("Erro = " + ex.getMessage());
        }

        finally
        {
            try
            {
                con.setAutoCommit(true);
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }

    //DELETE
    public boolean deleteProduto(String codigoDeBarras)
    {
        connectToDB();

        String sqlFisico = "DELETE FROM MidiaFisica where codigoDeBarra = ?";
        String sqlDigital = "DELETE FROM MidiaDigital where codigoDeBarra = ?";
        String sqlColecionador = "DELETE FROM EdicaoColecionador where codigoDeBarra = ?";
        String sqlBoneco = "DELETE FROM Boneco where codigoDeBarra = ?";

        try
        {
            pst = con.prepareStatement(sqlFisico);
            pst.setString(1, codigoDeBarras);
            pst.execute();

            pst = con.prepareStatement(sqlDigital);
            pst.setString(1, codigoDeBarras);
            pst.execute();

            pst = con.prepareStatement(sqlColecionador);
            pst.setString(1, codigoDeBarras);
            pst.execute();

            pst = con.prepareStatement(sqlBoneco);
            pst.setString(1, codigoDeBarras);
            pst.execute();

            sucesso = true;
        }

        catch (SQLException ex)
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException exc)
            {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    //SELECT
    public boolean selectProdutoNomePreco(String codigoDeBarras)
    {
        Produto produto = null;
        connectToDB();

        String sql = "SELECT nome, preco FROM MidiaFisica WHERE codigoDeBarra = ? " +
                     "UNION SELECT nome, preco FROM MidiaDigital WHERE codigoDeBarra = ? " +
                     "UNION SELECT nome, preco FROM EdicaoColecionador WHERE codigoDeBarra = ? " +
                     "UNION SELECT nome, preco FROM Boneco WHERE codigoDeBarra = ?";

        try
        {
            pst = con.prepareStatement(sql);

            for (int i = 1; i <= 4; i++)
                pst.setString(i, codigoDeBarras);

            rs = pst.executeQuery();

            while (rs.next())
            {
                produto = new Produto(rs.getString("nome"), codigoDeBarras, 0, rs.getFloat("preco"));

                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: " + produto.getPreco());
            }

            if (produto == null)
            {
                System.out.println("Produto não encontrado.");
                return false;
            }

            sucesso = true;
        }

        catch (SQLException e)
        {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                if (rs != null)
                    rs.close();

                if (pst != null)
                    pst.close();

                con.close();
            }

            catch (SQLException e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return true;
    }

    public int selectEstoque(String codigoDeBarras)
    {
        connectToDB();

        int estoque = -1;
        String sql = "SELECT estoque FROM MidiaFisica WHERE codigoDeBarra = ? " +
                "UNION SELECT estoque FROM MidiaDigital WHERE codigoDeBarra = ? " +
                "UNION SELECT estoque FROM EdicaoColecionador WHERE codigoDeBarra = ? " +
                "UNION SELECT estoque FROM Boneco WHERE codigoDeBarra = ?";

        try
        {
            pst = con.prepareStatement(sql);

            for (int i = 1; i <= 4; i++)
                pst.setString(i, codigoDeBarras);

            rs = pst.executeQuery();

            if (rs.next())
                estoque = rs.getInt("estoque");

            else
                System.out.println("Produto não encontrado.");

            sucesso = true;
        }

        catch (SQLException e)
        {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return estoque;
    }

    public void selectProdutoPrint(String codigoDeBarras)
    {
        connectToDB();

        boolean aux;
        String sql = "SELECT nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, usado, NULL as anoExpiracao, NULL as figure, NULL as steelbook, NULL as ost, NULL as tamanho " +
                "FROM MidiaFisica WHERE codigoDeBarra = ? " +
                "UNION " +
                "SELECT nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, NULL as usado, anoExpiracao, NULL as figure, NULL as steelbook, NULL as ost, NULL as tamanho " +
                "FROM MidiaDigital WHERE codigoDeBarra = ? " +
                "UNION " +
                "SELECT nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, NULL as usado, NULL as anoExpiracao, figure, steelbook, ost, NULL as tamanho " +
                "FROM EdicaoColecionador WHERE codigoDeBarra = ? " +
                "UNION " +
                "SELECT nome, codigoDeBarra, estoque, preco, NULL as classificacaoIndicativa, NULL as estudio, NULL as console, NULL as usado, NULL as anoExpiracao, NULL as figure, NULL as steelbook, NULL as ost, tamanho " +
                "FROM Boneco WHERE codigoDeBarra = ?";

        try
        {
            pst = con.prepareStatement(sql);

            for (int i = 1; i <= 4; i++)
                pst.setString(i, codigoDeBarras);

            rs = pst.executeQuery();

            if (rs.next())
            {
                // Imprime as informações específicas da tabela
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Código de Barras: " + rs.getString("codigoDeBarra"));
                System.out.println("Estoque: " + rs.getInt("estoque"));
                System.out.println("Preço: " + rs.getFloat("preco"));

                // Adapte conforme necessário para as colunas específicas de cada tabela
                if (rs.getMetaData().getColumnCount() > 4 && rs.getObject("classificacaoIndicativa") != null)
                {
                    System.out.println("Classificação Indicativa: " + rs.getInt("classificacaoIndicativa"));
                    System.out.println("Estúdio: " + rs.getString("estudio"));
                    System.out.println("Console: " + rs.getString("console"));
                }

                if (rs.getMetaData().getColumnCount() > 7 && rs.getObject("usado") != null)
                {
                    aux = rs.getBoolean("usado");

                    if(aux)
                        System.out.println("Usado: " + "Sim");

                    else
                        System.out.println("Usado: " + "Não");
                }

                if (rs.getMetaData().getColumnCount() > 8 && rs.getObject("anoExpiracao") != null)
                    System.out.println("Ano de Expiração: " + rs.getInt("anoExpiracao"));

                if (rs.getMetaData().getColumnCount() > 9 && rs.getObject("figure") != null)
                {
                    aux =  rs.getBoolean("figure");

                    if (aux)
                        System.out.println("Figure: " + "Incluso");

                    else
                        System.out.println("Figure: " + "Não incluso");

                    aux = rs.getBoolean("steelbook");

                    if (aux)
                        System.out.println("Figure: " + "Incluso");

                    else
                        System.out.println("Figure: " + "Não incluso");

                    aux = rs.getBoolean("ost");

                    if (aux)
                        System.out.println("Figure: " + "Incluso");

                    else
                        System.out.println("Figure: " + "Não incluso");

                }

                if (rs.getMetaData().getColumnCount() > 12 && rs.getObject("tamanho") != null)
                    System.out.println("Tamanho: " + rs.getInt("tamanho"));
            }

            else
                System.out.println("Produto não encontrado.");

            sucesso = true;
        }

        catch (SQLException e)
        {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public Produto selectProduto(String codigoDeBarras)
    {
        connectToDB();

        Produto produto = null;
        boolean aux;
        String sql = "SELECT nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, usado, NULL as anoExpiracao, NULL as figure, NULL as steelbook, NULL as ost, NULL as tamanho " +
                "FROM MidiaFisica WHERE codigoDeBarra = ? " +
                "UNION " +
                "SELECT nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, NULL as usado, anoExpiracao, NULL as figure, NULL as steelbook, NULL as ost, NULL as tamanho " +
                "FROM MidiaDigital WHERE codigoDeBarra = ? " +
                "UNION " +
                "SELECT nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console, NULL as usado, NULL as anoExpiracao, figure, steelbook, ost, NULL as tamanho " +
                "FROM EdicaoColecionador WHERE codigoDeBarra = ? " +
                "UNION " +
                "SELECT nome, codigoDeBarra, estoque, preco, NULL as classificacaoIndicativa, NULL as estudio, NULL as console, NULL as usado, NULL as anoExpiracao, NULL as figure, NULL as steelbook, NULL as ost, tamanho " +
                "FROM Boneco WHERE codigoDeBarra = ?";

        try
        {
            pst = con.prepareStatement(sql);

            for (int i = 1; i <= 4; i++)
                pst.setString(i, codigoDeBarras);

            rs = pst.executeQuery();

            if (rs.next())
                produto = new Produto(rs.getString("nome"), rs.getString("codigoDeBarra"), rs.getInt("estoque"), rs.getFloat("preco"));
        }

        catch (SQLException e)
        {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        }

        finally
        {
            try
            {
                con.close();
                pst.close();
            }

            catch (SQLException e)
            {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return produto;
    }

    public Cliente selectCliente(String telefone)
    {
        ArrayList<Cliente> clientes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Cliente where telefone = " + telefone;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Cliente clienteAux = new Cliente(rs.getString("nome"),rs.getString("telefone"),rs.getInt("id_Vendedor"));

                clientes.add(clienteAux);
            }
            sucesso = true;
        }

        catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        }

        finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        try
        {
            return clientes.get(0);
        }
        catch(IndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public Vendedor selectVendedor(int id) {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Vendedor where id = " + id;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Vendedor vendedorAux = new Vendedor(rs.getString("nome"), rs.getInt("id"), rs.getFloat("bonus"));

                vendedores.add(vendedorAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        try
        {
            return vendedores.get(0);
        }

        catch(IndexOutOfBoundsException e)
        {
            return null;
        }
    }
}