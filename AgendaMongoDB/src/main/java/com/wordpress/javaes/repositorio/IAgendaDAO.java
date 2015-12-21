package com.wordpress.javaes.repositorio;

import com.wordpress.javaes.dominio.Agenda;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public interface IAgendaDAO {
    public void salvar(Agenda agenda);
    public void atualizar(Agenda agenda);
    public void deletar(ObjectId id);
    public List<Agenda> buscaAgendas();
    public Agenda buscaAgenda(String codigo);
}
