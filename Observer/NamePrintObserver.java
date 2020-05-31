package Observer;

public class NamePrintObserver implements Observer{
    public void update(NumberGenerator generator){
        System.out.print("NamePrintObserver:");
        int count = generator.getNumber();
        for(int i =0 ; i< count;i++){
            System.out.print("윤수현 ");
        }
        System.out.println("");
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){

        }
    }
}
