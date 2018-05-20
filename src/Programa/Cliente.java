
package Programa;

public class Cliente {
    int cpf_cnpj, id_customer;
    double vl_total;
    String nm_customer;
    
    public Cliente(){
        this(0,0.0,"", 0);
    }
    
    public Cliente(int cpf_cnpj, double vl_total, String nm_customer, int id_customer){
        this.cpf_cnpj = cpf_cnpj;
        this.vl_total = vl_total;
        this.nm_customer = nm_customer;
        this.id_customer = id_customer;
    }

}
