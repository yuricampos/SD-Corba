import AgendaApp.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuricampos
 */
public class AgendaImpl extends AgendaPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public int salvar(String nome, String telefone) {
        try {
            Database d = new Database();
            return d.cadastrar(nome, telefone);
        } catch (IOException ex) {
            Logger.getLogger(AgendaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int atualizar(String nome, String telefone) {
        try {
            Database d = new Database();
            return d.atualizar(nome, telefone);
        } catch (IOException ex) {
            Logger.getLogger(AgendaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int apagar(String nome) {;
        try {
            Database d = new Database();
            return d.apagar(nome);
        } catch (IOException ex) {
            Logger.getLogger(AgendaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public String consultar(String nome) {
        Database d;
        try {
            d = new Database();
            return d.consultar(nome);
        } catch (IOException ex) {
            Logger.getLogger(AgendaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "nao";
        }
    }

}
