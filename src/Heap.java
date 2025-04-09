import java.util.List;

public class Heap {
    List<Integer> heap;
    int size;
    public void heapify(List<Integer> insert){
        if(heap.size()==0)
            heap.add(insert.remove(0));
        for (int i = 0; i < insert.size(); i++) {
            Integer child = insert.get(i);
            heap.add(insert.remove(i));
            int index=heap.size()-1;
            Integer parent=heap.get((int) Math.floor((double) index /2));
            if(parent<child){
                Integer temp = child;
                child = parent;
                parent = temp;
            }

        }
    }
}
