
package connection;

import Programa.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AcessaBanco {
    static Connection con;
    static Statement stat;
    static ResultSet r;
    
    public static void inicializaVariaveis() throws SQLException{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbCliente", "root", "");
         stat = con.createStatement();
    }
    
    public static ArrayList<Cliente> selecionaClientes() throws SQLException{
         inicializaVariaveis();
         ArrayList<Cliente> dadosClientes = new ArrayList<Cliente>();
         r = stat.executeQuery("select `id_customer`, `cpf_cnpj`, `nm_customer`, `vl_total` from `tb_customer_account` order by `vl_total` desc ");
         while(r.next()){
             dadosClientes.add(new Cliente(r.getInt("cpf_cnpj"), r.getDouble("vl_total"), r.getString("nm_customer"), r.getInt("id_customer")));
         }
         con.close();
         stat.close();
         r.close();
         return dadosClientes;
    }

    public static boolean inserirCliente(String nm_customer, int cpf_cnpj, double vl_total) throws SQLException {
        inicializaVariaveis();
        stat.executeUpdate("insert into `tb_customer_account`(`cpf_cnpj`, `nm_customer`, `is_active`, `vl_total`) values(" + cpf_cnpj + ", '" + nm_customer + "', true," +  vl_total + ")");
        con.close();
        stat.close();
        return true;
    }
    
}
