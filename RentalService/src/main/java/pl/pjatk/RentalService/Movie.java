package pl.pjatk.RentalService;


    public class Movie {

        private Integer id;
        private String name;
        private Category category;

        private Boolean isAvailable;

        public Movie(Integer id, String name, Category category, Boolean isAvailable) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.isAvailable = isAvailable;
        }

        public Movie() {

        }

        public Category getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        public Boolean getIsAvailable() {
            return isAvailable;
        }

        public void updateAvailability(Boolean isAvailable) {
            this.isAvailable = isAvailable;
        }
    }
