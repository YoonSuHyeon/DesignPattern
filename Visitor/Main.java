package Visitor;

import java.util.Iterator;

public class Main {
    public static void main(String[]args){
        try{
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi",10000));
            bindir.add(new File("latex",200000));

            Directory Kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory Park = new Directory("Park");

            usrdir.add(Kim);
            usrdir.add(Lee);
            usrdir.add(Park);

            Kim.add(new File("diary.html",100));
            Kim.add(new File("Composite",200));
            Kim.add(new File("hyejaKim.txt",100));

            Kim.add(new File("memo.tex",300));
            Kim.add(new File("index.html",350));
            Kim.add(new File("Leehyeja.txt",100));

            Kim.add(new File("game.doc",400));
            Kim.add(new File("junk.mail",500));
            Kim.add(new File("Parkhyeja",100));

            FileNameFindVisitor fnfv =new FileNameFindVisitor("hyeja");
            rootdir.accept(fnfv);

            System.out.println("Files containing Hyeja");

            Iterator it = fnfv.getFoundFiles();
            while(it.hasNext()){
                File file = (File) it.next();
                System.out.println(file.toString());
            }

        }catch(FileTreatmentException e){
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
        try {
           예제 System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new ListVisitor());



            System.out.println("");
            System.out.println("Making user entries...");
            Directory Kim = new Directory("Kim");
            Directory Lee = new Directory("Lee");
            Directory Park = new Directory("Park");
            usrdir.add(Kim);
            usrdir.add(Lee);
            usrdir.add(Park);
            Kim.add(new File("diary.html", 100));
            Kim.add(new File("Composite.java", 200));
            Lee.add(new File("memo.tex", 300));
            Park.add(new File("game.doc", 400));
            Park.add(new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }*/
}
