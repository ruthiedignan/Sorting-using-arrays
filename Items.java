
/**
 * This class declares a constructor for items in a store.
 *
 * @author Ruthie Dignan
 * @version 4/19/21
 */
public class Items
{
    //instance variables
    private String item;
    private int productNum;
    private double price;
    private int quantity;
    
    //constructor for items
    public Items(String item, int productNum, double price, int quantity)
    {
        this.item = item;
        this.productNum = productNum;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String toString()
    {
        String information = item + " " + productNum + " " + String.format("$%,10.2f", price) + " " + quantity;
        return information;
    }
    
    public String getItem()
    {
        return item;
    }
    
    public void setItem(String item)
    {
        this.item = item;
    }
    
    public int getProductNum()
    {
        return productNum;
    }
    
    public void setProductNum(int productNum)
    {
        this.productNum = productNum;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
