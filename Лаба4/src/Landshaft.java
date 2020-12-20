public class Landshaft implements Craft{

        private String name;
        private String description;
        private String action;
        private String how;
        private Craft to;

        public Landshaft(String name) {
            this.name = name;
        }

        public Landshaft(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public Landshaft(String name, String description, String action) {
            this.name = name;
            this.action = action;
            this.description = description;
        }

        public Landshaft(String name, String description, String action, String how) {
            this.name = name;
            this.action = action;
            this.description = description;
            this.how = how;
        }

        public Landshaft(String name, String description, String action, String how, Craft to) {
            this.name = name;
            this.action = action;
            this.description = description;
            this.how = how;
            this.to = to;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description == null ? "" : description;

        }

        public String getAction() {
            return action == null ? "" : action;
        }

        public String getHow() {
            return how == null ? "" : how;
        }

        public Craft getTo() {
            return to;
        }

    }

