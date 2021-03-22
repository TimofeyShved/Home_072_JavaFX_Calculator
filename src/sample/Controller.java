package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML public Text output;
    private long num1 = 0; // переменные
    private long num2 = 0;

    private boolean start = true; // это если в первый раз, или нажали на кнопку "="

    private String operator = "";
    private Modal model = new Modal();

    @FXML
    private void num(ActionEvent event){ // нажатие на кнопку
        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText(); // принимем значение кнопки и записываем его в текст
        output.setText(output.getText()+value);
    }

    @FXML
    private void operator(ActionEvent event){ // нажатие на оператор
        String value = ((Button)event.getSource()).getText();

        if(value.equals("C")) { // очистить всё
            operator="";
            num1 = 0;
            output.setText("");
            return;
        }

        if(!"=".equals(value)){ // Если оно не равно "=", то

            if(!operator.isEmpty()) { // если мы ещё раз делаем действие, то мы записываем его в num1
                num2 = Long.parseLong(output.getText());
                output.setText(String.valueOf(model.calculation(num1, num2, operator)));
            } // иначе, просто записываем обычное число в num1

            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }else { // иначе заверщаем действия с 2 числами, вызываем метод со свитчем
            if (operator.isEmpty())return;
            num2 = Long.parseLong(output.getText());
            output.setText(String.valueOf(model.calculation(num1, num2, operator)));
            operator="";
            start=true;
        }
    }
}
