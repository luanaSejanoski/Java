public class RegistroUsuario {

        private String usuario;
        private double espacoDisco;
    
        public RegistroUsuario(String usuario, double espacoDisco) {
            this.usuario = usuario;
            setEspacoDisco(espacoDisco);
        }
    
        // Getters
        public String getUsuario() {
            return usuario;
        }
    
        public double getEspacoDisco() {
            return espacoDisco;
        }
    
        // Setters
        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }
    
        public void setEspacoDisco(double espacoDisco) {
            this.espacoDisco = espacoDisco / (1024 * 1024);
        }
    
    }

