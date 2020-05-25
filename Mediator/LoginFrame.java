package Mediator;

import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame  extends Frame implements ActionListener,Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueCheckbox checkMember;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueTextField textRegistrationNumber;
    private ColleagueButton buttonOK;
    private ColleagueButton buttonCancel;
    public LoginFrame(String title){
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(5,3));

        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(checkMember);



        add(new Label("Username:"));
        add(textUser);
        add(new Label(""));

        add(new Label("Password:"));
        add(textPass);
        add(new Label(""));

        add(new Label("RegistrationNumber"));
        add(textRegistrationNumber);
        add(new Label(""));
        add(buttonOK);
        add(buttonCancel);

        colleagueChanged();
        pack();
        show();
    }

    public void createColleagues(){
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest",g,true);
        checkLogin = new ColleagueCheckbox("Login",g,false);
        checkMember=new ColleagueCheckbox("Member",g,false);

        textUser = new ColleagueTextField("",10);

        textPass = new ColleagueTextField("",10);
        textRegistrationNumber= new ColleagueTextField("",13);

        textPass.setEchoChar('*');

        buttonOK = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        checkMember.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        textRegistrationNumber.setMediator(this);
        buttonOK.setMediator(this);
        buttonCancel.setMediator(this);

        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        checkMember.addItemListener(checkMember);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        textRegistrationNumber.addTextListener(textRegistrationNumber);
        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    public void colleagueChanged(){
        if(checkGuest.getState()){
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            textRegistrationNumber.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(true);
        }else if(checkLogin.getState()){
            textUser.setColleagueEnabled(true);
            textRegistrationNumber.setColleagueEnabled(false);
            userpassChanged();
        }else{ //Member 체크시
            textUser.setColleagueEnabled(true);
            textPass.setColleagueEnabled(true);
            textRegistrationNumber.setColleagueEnabled(true);
            buttonOK.setColleagueEnabled(false);
            userOkChanged();
        }
    }

    private void userpassChanged(){
        if(textUser.getText().length() > 0){
            textPass.setColleagueEnabled(true);
            if(textPass.getText().length() >0){
                buttonOK.setColleagueEnabled(true);
            }else{
                buttonOK.setColleagueEnabled(false);
            }
        }else {
            textPass.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(false);
        }
    }
    private void userOkChanged(){
        if(textRegistrationNumber.getText().length()==13){
            if(isInteger(textRegistrationNumber.getText())){
                buttonOK.setColleagueEnabled(true);
            }
        }
    }
    private boolean isInteger(String s){
        char temp;
        for(int i =0;i<s.length();i++){
            temp=s.charAt(i);
            if(temp <48 || temp >58){
                return false;
            }
        }
        return true;
    }
    public void actionPerformed(ActionEvent e){
        System.out.println(e.toString());
        System.exit(0);
    }
}
