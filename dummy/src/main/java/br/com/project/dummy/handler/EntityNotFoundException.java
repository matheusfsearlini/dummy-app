package br.com.project.dummy.handler;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(EntityType entityType) {
        super("Nao foi possivel encontrar o(a) " + entityType + " na base");
    }

    public enum EntityType {
        CUSTOMER("cliente");
        String type;
        private EntityType(String type) {
            this.type = type;
        }
        @Override
        public String toString() {
            return type;
        }
    }

}
