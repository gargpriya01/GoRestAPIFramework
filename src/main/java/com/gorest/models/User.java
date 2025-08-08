package com.gorest.models;


public class User {

        private String name;
        private String email;
        private String gender;
        private String status;

        public User() {}

        public User(String name, String email, String gender, String status) {
            this.name = name;
            this.email = email;
            this.gender = gender;
            this.status = status;
        }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }


    public String getStatus() {
        return status;
    }


    public static class Builder{
        private String name;
        private String email;
        private String gender;
        private String status;

        public Builder setName(String name){
            this.name=name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public User build(){
            return new User(name,email,gender,status);

        }

    }
}


