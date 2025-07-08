package src.HashMaps_16.MyImplementation;

import java.util.ArrayList;
import java.util.LinkedList;


//custom hash map implementation with chaining
public class HashMapFinal <K, V>{
    ArrayList<LinkedList<Entity>> list;
    private int size=0;
    private float lf=0.5f; //load factor // (n/m)


    public HashMapFinal(){
        list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
    }

    public class Entity{
        K key;
        V value;

        public Entity(K key, V value){
            this.key=key;
            this.value=value;
        }
    }

    public void put(K key, V value){
        int hash=Math.abs(key.hashCode()%list.size());
        LinkedList<Entity> entities=list.get(hash);
        for (Entity entity:entities){
            if (entity.key.equals(key)){
                entity.value=value;
                return;
            }
        }

        if ((float) size / list.size()>lf){ //size: list length, list.size() : total elements in a list
            //Work of load factor(lf): //when a list is 50% full, then we copy all the linked
            // list to new arraylist of double the list size
            reHash();
        }
        entities.add(new Entity(key, value));
        size++;
    }

    private void reHash(){
        //Work of load factor(lf): //when a list is 50% full, then we copy all the linked
        // list to new arraylist of double the list size
        System.out.println("We are now rehashing!");
        ArrayList<LinkedList<Entity>> old=list;
        list=new ArrayList<>();
        size=0;
        for (int i = 0; i < old.size()*2; i++) {
            list.add(new LinkedList<>());
        }
        for (LinkedList<Entity> entries:old){
            for (Entity entry : entries){
                put(entry.key, entry.value);
            }
        }
    }

    public V get(K key){
        int hash=Math.abs(key.hashCode()%list.size()); //converting key to an index less than list size
        LinkedList<Entity> entities = list.get(hash);

        for (Entity entity:entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash=Math.abs(key.hashCode()%list.size()); //converting key to an index less than list size
        LinkedList<Entity> entities = list.get(hash);

        Entity target=null;
        for (Entity entity:entities) {
            if (entity.key.equals(key)) {
                target=entity;
                break;
            }
        }
        entities.remove(target);
        size--;
    }

    public boolean containsKey(K key){
        return get(key)!=null;
    }

    @Override
    public String toString() {
        StringBuilder st=new StringBuilder();
        st.append("[\n");
        for (LinkedList<Entity> entities:list){
            if (entities.isEmpty()){
                continue;
            }
            st.append("  [");
            for (Entity entity:entities){
                st.append("(");
                st.append(entity.key);
                st.append(": ");
                st.append(entity.value);
                st.append(")");
            }
            st.append("]\n");
        }
        st.append("]");

        return st.toString();
    }
}
