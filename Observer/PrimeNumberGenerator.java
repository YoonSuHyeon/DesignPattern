package Observer;

import java.util.ArrayList;

public class PrimeNumberGenerator extends NumberGenerator {
    private int number;

    private boolean calcPrimeNumber(int num){//소수인지 판별
        if(num==0 || num==1) return false;
        int temp = num /2;
        for(int i =2;i<=temp;i++){
            if(num %i == 0){
                return false;
            }
        }
        return true;
    }
    public int getNumber(){
        return number;
    }
    public void execute(){ //1~50 사이의 소수를 생성한다.
        for(int i =1 ; i<50;i++){
            if(calcPrimeNumber(i)) {
                number=i;
                notifyObservers();
            }
        }
    }

}
