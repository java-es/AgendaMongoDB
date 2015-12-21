package com.wordpress.javaes.dominio;

/**
 *
 * @author https://javaes.wordpress.com/
 */
public class Contato {

    private String email;
    private String telefone;
    private int tipo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
