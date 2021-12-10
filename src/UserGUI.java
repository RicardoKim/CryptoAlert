import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
// Frame ����ؼ� 
public class UserGUI extends Frame implements ActionListener
{
	JButton submitButton = new JButton("Enroll");
	
	TextField IDTextfield = new TextField(20);
	Panel p = new Panel();
    Label KakaoID = new Label(" īī���� ���̵�:");
	Label cryptoIntervalText = new Label("����ȭ�� ���� ����");
	Label cryptoRatioText = new Label("����ȭ�� �˶� ���� ��");
	Choice cryptoInterval = new Choice();
	Choice cryptoRatio = new Choice();
	String UserId = null;
	String optionSelect = null;
	Integer Interval = 0;
	double Ratio = 0.0;
	
	public void actionPerformed(ActionEvent actionEvent)
    {
        if (actionEvent.getSource() == submitButton) {
            optionSelect = cryptoInterval.getSelectedItem();
            if(optionSelect == "1��") {
            	Interval = 1;
            }
            else if(optionSelect == "30��") {
            	Interval = 5;
            }
            else if(optionSelect == "1��") {
            	Interval = 60;
            }
            
            optionSelect = cryptoRatio.getSelectedItem();
            if(optionSelect == "0.1%") {
            	Ratio = 0.1;
            }
            else if(optionSelect == "0.01%") {
            	Ratio = 0.01;
            }
            else if(optionSelect == "0.5%") {
            	Ratio = 0.5;
            }
            else if(optionSelect == "1%") {
            	Ratio = 1;
            }
            setVisible(false);
        }
    }
	
	
	public Integer getInterval(){
		return Interval;
	}
	
	public Double getRatio(){
		return Ratio;
	}
	
    public UserGUI()
    {
        super("�˶� ���� �Է� â");
        
        
        
        // �޺� �ڽ� ������ ����
        cryptoInterval.addItem("1��");
        cryptoInterval.addItem("30��");
        cryptoInterval.addItem("1��");
        
        cryptoRatio.addItem("0.01%");
        cryptoRatio.addItem("0.1%");
        cryptoRatio.addItem("0.5%");
        cryptoRatio.addItem("1%");
        p.add(cryptoIntervalText);
        p.add(cryptoInterval);
        p.add(cryptoRatioText);
        p.add(cryptoRatio);
        p.add(submitButton);
        add(p);

        submitButton.addActionListener(this);
        setBounds(100, 100, 300, 300);
        setVisible(true);
    }
}
