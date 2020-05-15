package Visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class FileNameFindVisitor extends Visitor {
    private String name = "";
    private ArrayList found = new ArrayList();
    public FileNameFindVisitor(String name){
        this.name = name;
    }
    public Iterator getFoundFiles(){
        return found.iterator();
    }

    @Override
    public void visit(File file) {
        if(file.getName().contains(name))
            found.add(file);
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}
