package State;

public class NightState  implements State{
    private static NightState singleton = new NightState();
    private NightState(){

    }
    public static State getInstance(){
        return singleton;
    }
    public void doClock(Context context, int hour){
         if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }else if(23 <= hour && hour < 24){
             context.changeState(MidnightSnackState.getInstance());
         }
    }
    public void doUse(Context context) { // 금고사용
        context.callSecurityCenter("비상 :야간금고 사용!");
    }
    public void doAlarm(Context context) { // 비상벨
        context.callSecurityCenter("비상벨 (야간)");
        context.changeState(UrgentState.getInstance());
    }
    public void doPhone(Context context) { // 일반통화
        context.recordLog("야간통화 녹음");
    }
    public String toString() { // 문자열 표현
        return "[야간]";
    }
}
