package com.wordpress.javaes.repositorio;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.wordpress.javaes.dominio.Agenda;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class AgendaDAO implements IAgendaDAO {

    @Override
    public void salvar(Agenda agenda) {
        ConexaoDB conexaoDB = new ConexaoDB();
        try {
            Document agendaParaGravar = new Document();
            agendaParaGravar.append("codigo", agenda.getCodigo());
            agendaParaGravar.append("nome", agenda.getNome());
            agendaParaGravar.append("sobrenome", agenda.getSobrenome());
            agendaParaGravar.append("contatos", agenda.transformaContatosDocumentos());
            conexaoDB.getMongoCollection().insertOne(agendaParaGravar);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexaoDB.fecharConexao();
        }
    }

    @Override
    public void atualizar(Agenda agenda) {
        ConexaoDB conexaoDB = new ConexaoDB();
        try {
            Document query = new Document("_id", agenda.getId());

            Document agedaParaAtualizar = new Document();
            agedaParaAtualizar.append("nome", agenda.getNome());
            agedaParaAtualizar.append("sobrenome", agenda.getSobrenome());
            agedaParaAtualizar.append("contatos", agenda.transformaContatosDocumentos());

            Document update = new Document();
            update.append("$set", agedaParaAtualizar);

            conexaoDB.getMongoCollection().updateOne(query, update);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexaoDB.fecharConexao();
        }
    }

    @Override
    public void deletar(ObjectId id) {
        ConexaoDB conexaoDB = new ConexaoDB();
        try {
            Document query = new Document("_id", id);
            conexaoDB.getMongoCollection().deleteOne(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexaoDB.fecharConexao();
        }
    }

    @Override
    public List<Agenda> buscaAgendas() {
        ConexaoDB conexaoDB = new ConexaoDB();
        final List<Agenda> agendas = new ArrayList<>();
        try {
            FindIterable<Document> iterable = conexaoDB.getMongoCollection().find();

            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    Agenda agenda = new Agenda();
                    agenda.setId((ObjectId) document.get("_id"));
                    agenda.setNome((String) document.get("nome"));
                    agenda.setSobrenome((String) document.get("sobrenome"));
                    agenda.transformaDocumentosContatos((List<Document>) document.get("contatos"));
                    agendas.add(agenda);
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexaoDB.fecharConexao();
        }

        return agendas;
    }

    @Override
    public Agenda buscaAgenda(String codigo) {
        ConexaoDB conexaoDB = new ConexaoDB();
        Agenda agenda = new Agenda();
        try {
            Document query = new Document("codigo", codigo);
            FindIterable<Document> iterable = conexaoDB.getMongoCollection().find(query);
            for (Document current : iterable) {
                agenda.setId((ObjectId) current.get("_id"));
                agenda.setNome((String) current.get("nome"));
                agenda.setSobrenome((String) current.get("sobrenome"));
                agenda.transformaDocumentosContatos((List<Document>) current.get("contatos"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexaoDB.fecharConexao();
        }

        return agenda;
    }
}
