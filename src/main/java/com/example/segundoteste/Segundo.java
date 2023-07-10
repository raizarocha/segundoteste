package com.example.segundoteste;

import java.util.*;


public class Segundo {
    public Random codCandidato = new Random();
    public List<Candidato> candidatos = new ArrayList<>();

    public int iniciarProcesso(String nome) throws Exception {
        if (!nome.isEmpty()) {
            boolean candidatoExiste = buscaCandidatoPorNome(nome);
            if (candidatoExiste) {
                throw  new Exception("Candidato já participa do processo");
            }
        } else {
            throw new Exception("Nome inválido");
        }

        Integer id = codCandidato.nextInt(1000);
        String status = "Recebido";
        Candidato candidato = new Candidato(id, nome, status);
        candidatos.add(candidato);
        return candidato.getId();
    }

    public boolean buscaCandidatoPorNome(String nome) {
        return candidatos.stream().anyMatch(candidato -> candidato.getNome().equals(nome));
    }

    public Candidato buscaCandidatoPorId(Integer id) {
        for (Candidato candidato : candidatos) {
            if (candidato.getId().equals(id)) {
                return candidato;
            }
        }
        return null;
    }

    public void marcarEntrevista(int codCandidato) throws Exception {
        Candidato candidato = buscaCandidatoPorId(codCandidato);
        if (candidato == null || !Objects.equals(candidato.getStatus(), "Recebido")) {
            throw new Exception("Candidato não encontrado");
        } else {
            candidato.setStatus("Qualificado");
        }
    }

    public void desqualificarCandidato(int codCandidato) throws Exception {
        Candidato candidato = buscaCandidatoPorId(codCandidato);
        if (candidato == null) {
            throw new Exception("Candidato não encontrado");
        } else {
            candidatos.remove(candidato);
        }
    }

    public String verificarStatusCandidato(int codCandidato) throws Exception {
        Candidato candidato = buscaCandidatoPorId(codCandidato);
        if (candidato == null) {
            throw new Exception("Candidato não encontrado");
        } else {
            return candidato.getStatus();
        }
    }

    public void aprovarCandidato(int codCandidato) throws Exception {
        Candidato candidato = buscaCandidatoPorId(codCandidato);
        if (candidato == null || !Objects.equals(candidato.getStatus(), "Qualificado")) {
            throw new Exception("Candidato não encontrado");
        } else {
            candidato.setStatus("Aprovado");
        }
    }

    public List<String> obterAprovados(){
        List<String> aprovados = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if (candidato.getStatus().equals("Aprovado")) {
                aprovados.add(candidato.getNome());
            }
        }
        return aprovados;
    }

}
