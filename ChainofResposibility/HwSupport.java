package ChainofResposibility;

public class HwSupport extends Support{

    public HwSupport(String name){
        super(name);
    }

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
    protected boolean resolve(Trouble trouble) {
        if(calcPrimeNumber(trouble.getNumber())){
            return true;
        }else{
            return false;
        }
    }
}
