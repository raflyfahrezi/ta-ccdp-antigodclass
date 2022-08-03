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
public class LoginPresenter {
    private LoginView view;
    private Login model;
  
    public LoginPresenter(LoginView view) {
        this.view = view;
        this.model = new Login();
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
