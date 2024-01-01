package fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes=new ArrayList<>();

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes=new ArrayList<>();
    }
    public void addFish(Fish fish){
        if (this.capacity>this.fishes.size()){
            this.fishes.add(fish);
        }
    }
    public boolean removeFish(String species){
        for (Fish fish:this.fishes) {
            if (fish.getSpecies().equals(species)){
                this.fishes.remove(fish);
                return true;
            }
        }
        return false;
    }
    public Fish getOldestFish(){
        Fish fish=this.fishes.get(0);
        for (int i = 0; i <this.fishes.size() ; i++) {
            if (this.fishes.get(i).getAge()>=fish.getAge()){
                fish=this.fishes.get(i);
            }
        }
        return fish;

    }
    public Fish getFish(String species){
        for (Fish fish:this.fishes) {
            if (fish.getSpecies().equals(species)){
                return fish;
            }
        }
        return null;
    }
    public int getCount(){
        return this.fishes.size();
    }
    public int getVacancies(){
        return this.capacity-this.fishes.size();
    }
    public String report(){
        StringBuilder out=new StringBuilder("Fishes in the pond:");
        out.append(System.lineSeparator());
        for (Fish fish:this.fishes) {
            out.append(fish);
            out.append(System.lineSeparator());
        }
        return out.toString();
    }
}
