package com.example.week04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout{
    public CashierView(){
        TextField t1 = new TextField("เงินทอน");
        t1.setPrefixComponent(new Span("$"));
        Button bt1 = new Button("คำนวณเงินทอน");
        TextField t2 = new TextField();
        t2.setPrefixComponent(new Span("$1000 : "));
        TextField t3 = new TextField();
        t3.setPrefixComponent(new Span("$500 : "));
        TextField t4 = new TextField();
        t4.setPrefixComponent(new Span("$100 : "));
        TextField t5 = new TextField();
        t5.setPrefixComponent(new Span("$20 : "));
        TextField t6 = new TextField();
        t6.setPrefixComponent(new Span("$10 : "));
        TextField t7= new TextField();
        t7.setPrefixComponent(new Span("$5 : "));
        TextField t8 = new TextField();
        t8.setPrefixComponent(new Span("$1 : "));
        add(t1, bt1,t2, t3, t4, t5, t6, t7, t8);

        bt1.addClickListener(even ->{
            int num1 = Integer.parseInt(t1.getValue());

            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+num1)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            t2.setValue(out.getB1000()+"");
            t3.setValue(out.getB500()+"");
            t4.setValue(out.getB100()+"");
            t5.setValue(out.getB20()+"");
            t6.setValue(out.getB10()+"");
            t7.setValue(out.getB5()+"");
            t8.setValue(out.getB1()+"");
        });
    }

}
