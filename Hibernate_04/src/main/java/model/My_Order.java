package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class My_Order {
    @Id
    private String orderId;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public My_Order() {
    }

    public My_Order(String orderId, String address, Customer customer) {
        this.address = address;
        this.orderId = orderId;
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "My_Order{" +
                "orderId='" + orderId + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }
}
