package br.com.project.dummy.handler;

public class ExistingEntityException extends RuntimeException{

    public ExistingEntityException(EntityNotFoundException.EntityType entityType) {
        super("O(a) " + entityType + " em questão já existe na base de dados");
    }

}
