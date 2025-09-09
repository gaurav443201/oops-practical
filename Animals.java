class Animal {
    void displaydog() {
        System.out.println("This is a Dog.");
    }
}

class Sound extends Animal {
    void displaysound() {
        System.out.println("Bhaww Bhaww Bhaww");
    }
}

public class Animals {
    public static void main(String[] args) {
        Sound obj = new Sound();
        obj.displaydog();
        obj.displaysound();
    }
}
