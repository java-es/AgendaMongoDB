package com.wordpress.javaes.principal;

import com.wordpress.javaes.dominio.Agenda;
import com.wordpress.javaes.dominio.Contato;
import com.wordpress.javaes.repositorio.AgendaDAO;
import com.wordpress.javaes.repositorio.ConexaoDB;
import com.wordpress.javaes.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class Principal {

    public static void main(String[] args) throws IOException {
//        Properties p = Util.getProp();
        // String host = p.getProperty("prop.server.host");
        // String ss = "";

        // ConexaoDB con = ConexaoDB.getInstance();
       /* AgendaDAO dao = new AgendaDAO();
        for(int i=0;i<100;i++){
        Agenda agenda = new Agenda();
        agenda.setCodigo(""+i);
        agenda.setNome("Agenda "+i);
        agenda.setSobrenome("Sobrenome "+i);

        Contato ct1 = new Contato();
        ct1.setEmail("email"+i+"@email.com");
        ct1.setTelefone("12345678");
        ct1.setTipo((short) 1);

        Contato ct2 = new Contato();
        ct2.setEmail("email"+i+"@email2.com");
        ct2.setTelefone("9999999");
        ct2.setTipo((short) 2);

        List<Contato> contatos = new ArrayList<Contato>();
        contatos.add(ct1);
        contatos.add(ct2);
        agenda.setContatos(contatos);

        dao.salvar(agenda);
        }*/
        //Agenda agenda = dao.buscaAgenda("1");
        //agenda.setNome("OPA");
        //agenda.getContatos().get(0).setEmail("LLLLLLAAA");
        //dao.atualizar(agenda);
        ///dao.deletar(agenda.getId());
        // List<Agenda> agendas = dao.buscaAgendas();
        //  String ss = "";
    }

}
