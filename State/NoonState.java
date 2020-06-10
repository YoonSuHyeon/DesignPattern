package State;

public class NoonState implements State {
    private static NoonState singleton = new NoonState();
    private NoonState() {
    }
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        } else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {
        context.callSecurityCenter("비상:점심시간 금고사용!");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(점심시간)");
        context.changeState(UrgentState.getInstance());
    }
    public void doPhone(Context context) {
        context.recordLog("점심시간 통화녹음");
    }
    public String toString() {
        return "[점심시간]";
    }
}
