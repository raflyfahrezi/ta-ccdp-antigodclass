/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.login;
/**
 *
 * @author Azis Naufal
 */
public class loginPresenter {
    private loginView view;
    private login model;
  
    public loginPresenter(loginView view) {
        this.view = view;
        this.model = new login();
    }
    
    public void setPassword(String password) {
        model.setPassword(password);
    }
    
    public void setName(String name) {
        model.setName(name);
    }
     
    public String getName() {
        return model.getName();
    } 
    
    public void login(){
        if (model.getName().equals("admin") && model.getPassword().equals("admin")){
            view.loginSuccess();
        }
        else {
            view.loginError();
        }
    }
}
