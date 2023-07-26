/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

public class Controller {

    private Model model;
    private pizza view;

    public Controller(Model model, pizza view) {
        this.model = model;
        this.view = view;
    }

    public String getSize() {
        return model.getSize();
    }

    public void setSize(String Size) {
        model.setSize(Size);
    }

    public String getFlavours() {
        return model.getFlavours();
    }

    public void setFlavours(String Flavours) {
        model.setFlavours(Flavours);
    }

    public String getExtra() {
        return model.getExtra();
    }

    public void setExtra(String Extra) {
        model.setExtra(Extra);
    }

    public String getPrice() {
        return model.getPrice();
    }

    public void setPrice(String Price) {
        model.setPrice(Price);
    }

    public String getQty() {
        return model.getQty();
    }

    public void setQty(String Qty) {
        model.setQty(Qty);
    }

    public String getDrink() {
        return model.getDrink();
    }

    public void setDrink(String Drink) {
        model.setDrink(Drink);
    }

    public String getTotal() {
        return model.getTotal();
    }

    public void setTotal(String Total) {
        model.setTotal(Total);
    }

    public void updateView() {
        view.displayData(model.getSize(), model.getFlavours(), model.getExtra(), model.getPrice(), model.getQty(), model.getDrink(), model.getTotal());
    }

}
