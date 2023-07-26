/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manipulate;

/**
 *
 * @author faraz
 */
public class Controller {
    
    Model model;
    Manipulator_Pizza view;
    
    public Controller(Model model, Manipulator_Pizza view){
        this.model=model;
        this.view=view;
    }
    
    
     public String getCUSTOMER_ID() {
        return model.getCUSTOMER_ID();
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        model.setCUSTOMER_ID(CUSTOMER_ID);
    }

    public String getCUSTOMER_NAME() {
        return model.getCUSTOMER_NAME();
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        model.setCUSTOMER_NAME(CUSTOMER_NAME);
    }

    public String getADDRESS() {
        return model.getADDRESS();
    }

    public void setADDRESS(String ADDRESS) {
        model.setADDRESS(ADDRESS);
    }

    public String getCONTACT() {
        return model.getCONTACT();
    }

    public void setCONTACT(String CONTACT) {
        model.setCONTACT(CONTACT);
    }

    public String getSALES_ID() {
        return model.getSALES_ID();
    }

    public void setSALES_ID(String SALES_ID) {
        model.setSALES_ID(SALES_ID);
    }

    public String getPAY() {
        return model.getPAY();
    }

    public void setPAY(String PAY) {
        model.setPAY(PAY);
    }

    public String getBALANCE() {
        return model.getBALANCE();
    }

    public void setBALANCE(String BALANCE) {
        model.setBALANCE(BALANCE);
    }

    public String getNO_OF_PRODUCTS() {
        return model.getNO_OF_PRODUCTS();
    }

    public void setNO_OF_PRODUCTS(String NO_OF_PRODUCTS) {
        model.setNO_OF_PRODUCTS(NO_OF_PRODUCTS);
    }

    public String getTOTAL() {
        return model.getTOTAL();
    }

    public void setTOTAL(String TOTAL) {
        model.setTOTAL(TOTAL);
    }
    
    
    public void updateView() {
        view.displayData(model.getCUSTOMER_ID(),model.getCUSTOMER_NAME(),model.getADDRESS(),model.getCONTACT(),model.getSALES_ID(),model.getPAY(),model.getBALANCE(),model.getNO_OF_PRODUCTS(),model.getTOTAL());
    }
    
    
    
    
    
}
