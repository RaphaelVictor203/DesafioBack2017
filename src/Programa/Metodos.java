
package Programa;

import connection.AcessaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Metodos {
    public static void menu() throws SQLException{
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL:\n 1 - Cadastrar cliente\n 2 - Consultar clientes\n 9 - SAIR"));
            switch(opc){
                case 1:
                    inserirClientes();
                    break;
                case 2:
                    retornaMediaEClientes();
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opçao invalida !!!");
            }
        }while(opc!=9);
    }
    
    public static void inserirClientes() throws SQLException{
        int opc = 0;
        Cliente cliente = new Cliente();
        while(opc!=2){
            cliente.nm_customer = JOptionPane.showInputDialog("Insira o nome do cliente");
            cliente.vl_total = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor total que o cliente possui: "));
            cliente.cpf_cnpj = Integer.parseInt(JOptionPane.showInputDialog("Insira(sem pontuação) o numero do cpf ou cnpj do cliente: "));
            if(AcessaBanco.inserirCliente(cliente.nm_customer, cliente.cpf_cnpj, cliente.vl_total)){
                JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO !!!");
            }else{
                JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL REALIZAR O CADASTRO", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            opc = Integer.parseInt(JOptionPane.showInputDialog("Deseja inserir mais algum cliente ?\n 1 - SIM\n 2 - NÃO"));
        }
    }
    
    public static void retornaMediaEClientes() throws SQLException{
        double media = 0.0;
        int cont = 0;
        String clientes = "";
        ArrayList<Cliente> dadosClientes = new ArrayList<Cliente>();
        dadosClientes = AcessaBanco.selecionaClientes();
        for(Cliente cliente : dadosClientes){
            if(cliente.vl_total > 560 && (cliente.id_customer > 1500 && cliente.id_customer < 2700)){
                media += cliente.vl_total;
                cont++;
                clientes += "Cliente: " + cliente.nm_customer + ", Saldo: " + cliente.vl_total + "\n";
            }
        }
        if(cont != 0){
            media /= cont;
        }
        JOptionPane.showMessageDialog(null, "Média final: " + media + "\nCLIENTES UTILIZADOS:\n " + clientes);
    }
}
