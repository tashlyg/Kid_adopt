package org.example;

class Shelter{
    String name;
    String location;
    int places;
    public Shelter(String name, String location, int places){
        this.name = name;
        this.location = location;
        this.places = places;
    }
    public Shelter(){
        this.name = "unknown";
        this.location = "unknown";
        this.places = -1;
    }

    void setName(String name){
        this.name = name;
    }
    void setPlaces(int places){
        this.places = places;
    }

    String getName(){
        return this.name;
    }
    String getLocation(){
        return this.location;
    }
    int getPlaces(){
        return this.places;
    }

    @Override
    public String toString() {
        return "Shelter Name:'"+ name +"', location:'"+location+"', places:'"+places+"'";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
