package com.wordpress.javaes.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class Agenda implements Serializable {

    private ObjectId id;
    private String codigo;
    private String nome;
    private String sobrenome;
    private List<Contato> contatos;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Contato> getContatos() {
        return this.contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Document> transformaContatosDocumentos() {
        List<Document> documentos = new ArrayList<>();
        this.contatos.stream().map((Contato contato) -> {
            Document document = new Document();
            document.put("email", contato.getEmail());
            document.put("telefone", contato.getTelefone());
            document.put("tipo", contato.getTipo());
            return document;
        }).forEach((document) -> {
            documentos.add(document);
        });

        return documentos;
    }

    public void transformaDocumentosContatos(List<Document> documentos) {
        if (this.contatos == null) {
            this.contatos = new ArrayList<Contato>();
        }
        if (documentos != null && documentos.size() > 0) {
            for (Document documento : documentos) {
                Contato contato = new Contato();
                contato.setEmail((String) documento.get("email"));
                contato.setTelefone((String) documento.get("telefone"));
                int tipo = (int) documento.get("tipo");
                contato.setTipo(tipo);
                this.contatos.add(contato);
            }
        }
    }
}
