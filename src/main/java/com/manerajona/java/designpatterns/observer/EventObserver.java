package com.manerajona.java.designpatterns.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class HandmadeEventsDemo {
    public static void main(String[] args) {
        
      Persona Persona = new Persona();

        try (Event<PropertyChangedArgs>.Subscription sub =
                     Persona.propertyChanged.addHandler(HandmadeEventsDemo::accept)) {

            Persona.setAge(17);
            Persona.setAge(18);
            //sub.close();
            Persona.setAge(19);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  private static void accept(PropertyChangedArgs x) {
    System.out.printf("Persona's %s has changed%n", x.propertyName);
  }
}

class Event<TArgs> {
    private int count = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handler) {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler : handlers.values())
            handler.accept(args);
    }

    public class Subscription implements AutoCloseable {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id) {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() throws Exception {
            event.handlers.remove(id);
        }
    }
}

class PropertyChangedArgs {

    public Object source;
    public String propertyName;

    public PropertyChangedArgs(Object source, String propertyName) {
        this.source = source;
        this.propertyName = propertyName;
    }
}

class Persona {

    public Event<PropertyChangedArgs> propertyChanged = new Event<>();

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age != age) {

            boolean oldCanVote = canVote();

            this.age = age;
            propertyChanged.fire(new PropertyChangedArgs(this, "age"));

            if (oldCanVote != canVote()) {
                propertyChanged.fire(new PropertyChangedArgs(this, "canVote"));
            }
        }
    }

    public boolean canVote() {
        return age >= 18;
    }
}

