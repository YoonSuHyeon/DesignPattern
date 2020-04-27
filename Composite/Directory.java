package Composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;
    private ArrayList directory = new ArrayList();
    public Directory(String name) {                  // 생성자
         this.name = name;
    }
    public String getName() {                       // 이름을 얻는다
         return name;
    }
    public int getSize() {                            // 크기를 얻는다
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }

     return size;
    }
    public Entry add(Entry entry) {                  // 엔트리의 추가
         directory.add(entry);
         return this;
    }
    protected void printList(String prefix) {           // 엔트리의 일람
         System.out.println(prefix + "/" + this);
         Iterator it = directory.iterator();
         while (it.hasNext()) {
             Entry entry = (Entry)it.next();
             entry.printList(prefix + "/" + name);
         }
    }
}

