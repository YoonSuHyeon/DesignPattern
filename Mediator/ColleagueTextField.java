package Mediator;

import java.awt.*;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;
    public ColleagueTextField(String text, int columns){
        super(text,columns);
    }
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }
    public void setColleagueEnabled(boolean enabled){
        setEnabled(enabled);
        setBackground(enabled? Color.white:Color.lightGray);
    }

    @Override
    public void textValueChanged(TextEvent textEvent) {
        mediator.colleagueChanged();
    }
}
