/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HasinMahir;

import java.util.Dictionary;
import java.util.Hashtable;
import HasinMahir.order;

/**
 *
 * @author hasin
 */
public class orderList {
    static Integer nextid = 0;
    static Dictionary<Integer,order> data = new Hashtable<>();
    
    
    public static void addOrder(order newOrder){
        orderList.data.put(orderList.nextid, newOrder);
        nextid++;
    
    }
    
}
