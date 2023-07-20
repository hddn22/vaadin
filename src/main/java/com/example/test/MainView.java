package com.example.test;

import com.example.test.Entity.Counter;
import com.example.test.service.CounterService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.AllArgsConstructor;

@Route("main")
public class MainView extends VerticalLayout {
    private final CounterService counterService;
    private final TextField counterField;

    public MainView(CounterService counterService) {
        this.counterService = counterService;


        counterField = new TextField("Counter value");
        counterField.addValueChangeListener(e -> {
            String newValue = e.getValue();
            if (newValue != null && !newValue.isEmpty()) {
                int counterValue = Integer.parseInt(newValue);
                updateCounterValue(counterValue);
            }
        });

        Button incrementButton = new Button("Increment");
        incrementButton.addClickListener(e -> incrementCounter());


        add(counterField, incrementButton);

        updateCounterField();
    }

    private void incrementCounter() {
        Counter counter = counterService.findById(1L).orElse(new Counter());
        counter.setCounterValue(counter.getCounterValue() + 1);
        counterService.save(counter);
        updateCounterField();
    }

    private void updateCounterField() {
        Counter counter = counterService.findById(1L).orElse(new Counter());
        counterField.setValue(String.valueOf(counter.getCounterValue()));
    }

    private void updateCounterValue(int counterValue) {
        Counter counter = counterService.findById(1L).orElse(new Counter());
        counter.setCounterValue(counterValue);
        counterService.save(counter);
    }


}
