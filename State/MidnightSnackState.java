package State;

public class MidnightSnackState  implements State{
    private static MidnightSnackState singleton = new MidnightSnackState();
    private MidnightSnackState(){

    }
    public static State getInstance(){
        return singleton;
    }
    public void doClock(Context context, int hour){
        if (0 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(Context context) {
        context.recordLog("금고사용(야식시간)");
        context.callSecurityCenter("비상 :야식시간금고 사용!");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨 (야식시간)");
        context.changeState(UrgentState.getInstance());
    }
    public void doPhone(Context context) { // 일반통화
        context.recordLog("야식시간통화 녹음");
    }
    public String toString() { // 문자열 표현
        return "[야식시간]";
    }
}
