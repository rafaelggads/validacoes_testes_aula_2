package order;

import exceptions.OrderNotFoundException;
import exceptions.OrderSaveException;
import exceptions.OrderUpdateException;

/**
 * Created by gilmario on 19/02/17.
 */
public class OrderBo {
    public void save(Order order) throws OrderSaveException{
        if(order == null){
            throw new OrderSaveException("Order is empty");
        }
        //persist it
    }

    public void update(Order order) throws OrderUpdateException, OrderNotFoundException{
        if(order == null){
            throw new OrderUpdateException("Order is empty");
        }
        //If order is not available in the database
        throw new OrderNotFoundException("Order is not exists");
    }


}
