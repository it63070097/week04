package com.example.week04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;

@Route(value = "index1")
public class MathView extends VerticalLayout{
    public MathView() {
        TextField t1 = new TextField("Number1");
        TextField t2 = new TextField("Number2");
        Label l1 = new Label("Operator");
        Button bt1 = new Button("+");
        Button bt2 = new Button("-");
        Button bt3 = new Button("*");
        Button bt4 = new Button("/");
        Button bt5 = new Button("Mod");
        Button bt6 = new Button("Max");
        Label l2 = new Label("Answer");
        TextField t3 = new TextField();
        HorizontalLayout hl = new HorizontalLayout();
        hl.add(bt1, bt2, bt3, bt4, bt5, bt6);
        add(t1, t2, l1, hl, l2,t3);

        bt1.addClickListener(even ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            t3.setValue(out);
        });
        bt2.addClickListener(even ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            t3.setValue(out);
        });
        bt3.addClickListener(even ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            t3.setValue(out);
        });
        bt4.addClickListener(even ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            t3.setValue(out);
        });
        bt5.addClickListener(even ->{
            double num1 = Double.parseDouble(t1.getValue());
            double num2 = Double.parseDouble(t2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            t3.setValue(out);
        });
        bt6.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", t1.getValue());
            formData.add("n2", t2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            t3.setValue(out);
        });
    }
}
