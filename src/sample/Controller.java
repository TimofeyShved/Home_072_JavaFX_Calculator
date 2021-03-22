package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML public Text output;
    private long num1 = 0;
    private long num2 = 0;

    private boolean start = true;

    private String operator = "";
    private Modal model = new Modal();

    @FXML
    private void num(ActionEvent event){
        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText()+value);
    }

    @FXML
    private void operator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!"=".equals(value)){
            if(!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }else {
            System.out.println(value);
            if(value.equals("c")) {
                operator="";
                num1 = 0;
                output.setText("");
                System.out.println(000);
                return;
            }
            if (operator.isEmpty())return;
            num2 = Long.parseLong(output.getText());
            output.setText(String.valueOf(model.calculation(num1, num2, operator)));
            operator="";
            start=true;
        }
    }
}
