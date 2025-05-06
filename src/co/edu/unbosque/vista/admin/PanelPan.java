package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class PanelPan extends JPanel {

    private JRadioButton conQueso;
    private JRadioButton sinQueso;
    private ButtonGroup grupoQueso;

    public PanelPan() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createTitledBorder("Atributos específicos del Pan"));

        conQueso = new JRadioButton("Con queso");
        sinQueso = new JRadioButton("Sin queso");

        grupoQueso = new ButtonGroup();
        grupoQueso.add(conQueso);
        grupoQueso.add(sinQueso);

        add(conQueso);
        add(sinQueso);
    }

    public boolean isConQueso() {
        return conQueso.isSelected();
    }

    public void setConQueso(boolean valor) {
        if (valor) {
            conQueso.setSelected(true);
        } else {
            sinQueso.setSelected(true);
        }
    }

    public void limpiar() {
        grupoQueso.clearSelection();
    }
}
