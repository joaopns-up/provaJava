package model;

import java.util.Arrays;

public enum Estado {
    AC("Acre", "AC"),
    AL("Alagoas", "AL"),
    AP("Amapá", "AP"),
    AM("Amazonas", "AM"),
    BA("Bahia", "BA"),
    CE("Ceará", "CE"),
    DF("Distrito Federal", "DF"),
    ES("Espírito Santo", "ES"),
    GO("Goiás", "GO"),
    MA("Maranhão", "MA"),
    MT("Mato Grosso", "MT"),
    MS("Mato Grosso do Sul", "MS"),
    MG("Minas Gerais", "MG"),
    PA("Pará", "PA"),
    PB("Paraíba", "PB"),
    PR("Paraná", "PR"),
    PE("Pernambuco", "PE"),
    PI("Piauí", "PI"),
    RJ("Rio de Janeiro", "RJ"),
    RN("Rio Grande do Norte", "RN"),
    RS("Rio Grande do Sul", "RS"),
    RO("Rondônia", "RO"),
    RR("Roraima", "RR"),
    SC("Santa Catarina", "SC"),
    SP("São Paulo", "SP"),
    SE("Sergipe", "SE"),
    TO("Tocantins", "TO");

    private String nome;
    private String sigla;

    private Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
    
    public static Estado buscarEstadoPorSilga(String sigla) throws Exception{
          if (sigla.length() != 2) {
            throw new Exception("Estado inválido");
          }
          return Estado.valueOf(sigla.toUpperCase());
    }
    
    public static Estado buscarEstadoPorNome(String nome) throws Exception{
          return Arrays.stream(Estado.values())
                .filter(e -> e.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst()
                .orElseThrow(() -> new Exception("Estado não encontrado"));
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public String toString(){
        return getNome();
    }
}