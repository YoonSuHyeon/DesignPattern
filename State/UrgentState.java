package State;

public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();
    private UrgentState() {
    }
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        // 시간설정에서는 아무 처리를 하지 않는다
    }
    public void doUse(Context context) {
        context.callSecurityCenter("비상:비상사태 금고사용!");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(비상사태)");
    }
    public void doPhone(Context context) {
        context.callSecurityCenter("일반통화(비상사태)");
    }
    public String toString() {
        return "[비상사태]";
    }
}
